package com.example.banka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        createAllTables();
    }

    private void createAllTables() {

        List<String> tableDefinitions = Arrays.asList(
                """
                CREATE TABLE IF NOT EXISTS musteriler (
                    musteri_id BIGSERIAL PRIMARY KEY,
                    ad VARCHAR(255) NOT NULL,
                    soyad VARCHAR(255) NOT NULL,
                    telefon VARCHAR(25) NOT NULL,
                    email VARCHAR(255),
                    adres VARCHAR(255)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS subeler (
                    sube_id BIGSERIAL PRIMARY KEY,
                    adres VARCHAR(255) NOT NULL,
                    telefon VARCHAR(25) NOT NULL,
                    sube_kodu VARCHAR(50) UNIQUE NOT NULL,
                    sube_adi VARCHAR(255) NOT NULL
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS hesaplar (
                    hesap_id BIGSERIAL PRIMARY KEY,
                    acilis_tarih TIMESTAMP NOT NULL,
                    hesap_turu VARCHAR(255) NOT NULL,
                    bakiye DOUBLE PRECISION NOT NULL,
                    hesap_adi VARCHAR(255) NOT NULL,
                    musteri_id BIGINT NOT NULL,
                    sube_id BIGINT,
                    FOREIGN KEY (musteri_id) REFERENCES musteriler(musteri_id),
                    FOREIGN KEY (sube_id) REFERENCES subeler(sube_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS sigortalar (
                    sigorta_id BIGSERIAL PRIMARY KEY,
                    sigorta_turu VARCHAR(255) NOT NULL,
                    baslangic_tarihi TIMESTAMP NOT NULL,
                    bitis_tarihi TIMESTAMP NOT NULL,
                    prim_tutari DOUBLE PRECISION NOT NULL,
                    musteri_id BIGINT NOT NULL,
                    FOREIGN KEY (musteri_id) REFERENCES musteriler(musteri_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS kartlar (
                    kart_id BIGSERIAL PRIMARY KEY,
                    kart_numarasi VARCHAR(255) UNIQUE NOT NULL,
                    kart_turu VARCHAR(50) NOT NULL,
                    hesap_id BIGINT NOT NULL,
                    vade_tarihi TIMESTAMP NOT NULL,
                    kart_limit DOUBLE PRECISION NOT NULL,
                    FOREIGN KEY (hesap_id) REFERENCES hesaplar(hesap_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS cekler (
                    cek_id BIGSERIAL PRIMARY KEY,
                    cek_numarasi VARCHAR(255) NOT NULL,
                    kesilme_tarihi TIMESTAMP NOT NULL,
                    vade_tarihi TIMESTAMP NOT NULL,
                    tutar DOUBLE PRECISION NOT NULL,
                    hesap_id BIGINT NOT NULL,
                    FOREIGN KEY (hesap_id) REFERENCES hesaplar(hesap_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS eft (
                    eft_id BIGSERIAL PRIMARY KEY,
                    gonderici_hesap_id BIGINT NOT NULL,
                    alici_hesap_id BIGINT NOT NULL,
                    tutar DOUBLE PRECISION NOT NULL,
                    eft_tarihi TIMESTAMP NOT NULL,
                    durum VARCHAR(50) NOT NULL,
                    FOREIGN KEY (gonderici_hesap_id) REFERENCES hesaplar(hesap_id),
                    FOREIGN KEY (alici_hesap_id) REFERENCES hesaplar(hesap_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS havale (
                    havale_id BIGSERIAL PRIMARY KEY,
                    gonderici_hesap_id BIGINT NOT NULL,
                    alici_hesap_id BIGINT NOT NULL,
                    tutar DOUBLE PRECISION NOT NULL,
                    havale_tarihi TIMESTAMP NOT NULL,
                    durum VARCHAR(50) NOT NULL,
                    FOREIGN KEY (gonderici_hesap_id) REFERENCES hesaplar(hesap_id),
                    FOREIGN KEY (alici_hesap_id) REFERENCES hesaplar(hesap_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS islemler (
                    islem_id BIGSERIAL PRIMARY KEY,
                    hesap_id BIGINT NOT NULL,
                    islem_tarihi TIMESTAMP NOT NULL,
                    islem_turu VARCHAR(50) NOT NULL,
                    tutar DOUBLE PRECISION NOT NULL,
                    aciklama VARCHAR(255),
                    sube_id BIGINT NOT NULL,
                    FOREIGN KEY (hesap_id) REFERENCES hesaplar(hesap_id),
                    FOREIGN KEY (sube_id) REFERENCES subeler(sube_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS krediler (
                    kredi_id BIGSERIAL PRIMARY KEY,
                    kalan_borc DOUBLE PRECISION NOT NULL,
                    alinan_borc DOUBLE PRECISION NOT NULL,
                    vade INT NOT NULL,
                    kredi_turu VARCHAR(50),
                    musteri_id BIGINT NOT NULL,
                    FOREIGN KEY (musteri_id) REFERENCES musteriler(musteri_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS kredi_odemeleri (
                    odeme_id BIGSERIAL PRIMARY KEY,
                    kredi_id BIGINT NOT NULL,
                    odeme_tarihi TIMESTAMP NOT NULL,
                    odenen_tutar DOUBLE PRECISION NOT NULL,
                    odeme_turu VARCHAR(50) NOT NULL,
                    FOREIGN KEY (kredi_id) REFERENCES krediler(kredi_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS kredi_planlari (
                    plan_id BIGSERIAL PRIMARY KEY,
                    kredi_id BIGINT NOT NULL,
                    odeme_tarihi TIMESTAMP NOT NULL,
                    odenen_tutar DOUBLE PRECISION NOT NULL,
                    kalan_borc DOUBLE PRECISION NOT NULL,
                    FOREIGN KEY (kredi_id) REFERENCES krediler(kredi_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS kredi_karti_borclari (
                    borc_id BIGSERIAL PRIMARY KEY,
                    kart_id BIGINT NOT NULL,
                    borc_tutari DOUBLE PRECISION NOT NULL,
                    son_odeme_tarihi TIMESTAMP NOT NULL,
                    odenen_tutar DOUBLE PRECISION NOT NULL,
                    FOREIGN KEY (kart_id) REFERENCES kartlar(kart_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS nakit_avans (
                    avans_id BIGSERIAL PRIMARY KEY,
                    kart_id BIGINT NOT NULL,
                    avans_tutari DOUBLE PRECISION NOT NULL,
                    avans_tarihi TIMESTAMP NOT NULL,
                    odenen_tutar DOUBLE PRECISION NOT NULL,
                    FOREIGN KEY (kart_id) REFERENCES kartlar(kart_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS talepler (
                    talep_id BIGSERIAL PRIMARY KEY,
                    talep_turu VARCHAR(255) NOT NULL,
                    talep_tarihi TIMESTAMP NOT NULL,
                    musteri_id BIGINT NOT NULL,
                    FOREIGN KEY (musteri_id) REFERENCES musteriler(musteri_id)
                )
                """,
                """
                CREATE TABLE IF NOT EXISTS yatirim_hesaplari (
                    yatirim_id BIGSERIAL PRIMARY KEY,
                    bakiye DOUBLE PRECISION NOT NULL,
                    alis_tarihi TIMESTAMP NOT NULL,
                    satis_tarihi TIMESTAMP,
                    yatirim_turu VARCHAR(255) NOT NULL,
                    musteri_id BIGINT NOT NULL,
                    FOREIGN KEY (musteri_id) REFERENCES musteriler(musteri_id)
                )
                """
        );





    }
}

