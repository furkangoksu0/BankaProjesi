package com.example.banka.DAO;

import com.example.banka.Entity.Hesaplar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class HesaplarDAO {

    private final JdbcTemplate jdbcTemplate;

    public HesaplarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addHesap(Hesaplar hesap) {
        String sql = "INSERT INTO hesaplar (acilis_tarih, hesap_turu, bakiye, hesap_adi, musteri_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                hesap.getAcilisTarih(),
                hesap.getHesapTuru(),
                hesap.getBakiye(),
                hesap.getHesapAdi(),
                hesap.getMusteriId());
    }


    public List<Hesaplar> getAllHesaplar() {
        String sql = "SELECT * FROM hesaplar";
        return jdbcTemplate.query(sql, new HesaplarRowMapper());
    }

    public List<Map<String, Object>> getHesaplarByMusteriId(Long musteriId) {
        String sql = """
            SELECT 
                h.hesap_id, 
                h.hesap_adi, 
                h.bakiye, 
                h.hesap_turu, 
                m.ad AS musteri_adi, 
                m.soyad AS musteri_soyadi
            FROM hesaplar h
            JOIN musteriler m ON h.musteri_id = m.musteri_id
            WHERE m.musteri_id = ?
        """;
        return jdbcTemplate.queryForList(sql, musteriId);
    }


    public List<Map<String, Object>> getHesapKartlari(Long hesapId) {
        String sql = """
            SELECT 
                k.kart_id, 
                k.kart_numarasi, 
                k.kart_turu, 
                k.kart_limit, 
                h.hesap_adi, 
                m.ad AS musteri_adi, 
                m.soyad AS musteri_soyadi
            FROM kartlar k
            JOIN hesaplar h ON k.hesap_id = h.hesap_id
            JOIN musteriler m ON h.musteri_id = m.musteri_id
            WHERE h.hesap_id = ?
        """;
        return jdbcTemplate.queryForList(sql, hesapId);
    }


    public List<Map<String, Object>> getHesapIslemleri(Long hesapId) {
        String sql = """
            SELECT 
                i.islem_id, 
                i.islem_turu, 
                i.tutar, 
                i.islem_tarihi, 
                i.aciklama, 
                h.hesap_adi, 
                s.sube_adi, 
                s.adres AS sube_adres
            FROM islemler i
            JOIN hesaplar h ON i.hesap_id = h.hesap_id
            JOIN subeler s ON i.sube_id = s.sube_id
            WHERE h.hesap_id = ?
        """;
        return jdbcTemplate.queryForList(sql, hesapId);
    }


    public Hesaplar getHesapById(Long hesapId) {
        String sql = "SELECT * FROM hesaplar WHERE hesap_id = ?";
        return jdbcTemplate.queryForObject(sql, new HesaplarRowMapper(), hesapId);
    }


    public void deleteHesap(Long hesapId) {
        String sql = "DELETE FROM hesaplar WHERE hesap_id = ?";
        jdbcTemplate.update(sql, hesapId);
    }


    private static class HesaplarRowMapper implements RowMapper<Hesaplar> {
        @Override
        public Hesaplar mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hesaplar hesap = new Hesaplar();
            hesap.setHesapId(rs.getLong("hesap_id"));
            hesap.setAcilisTarih(rs.getTimestamp("acilis_tarih").toLocalDateTime());
            hesap.setHesapTuru(rs.getString("hesap_turu"));
            hesap.setBakiye(rs.getDouble("bakiye"));
            hesap.setHesapAdi(rs.getString("hesap_adi"));
            hesap.setMusteriId(rs.getLong("musteri_id"));
            return hesap;
        }
    }
}
