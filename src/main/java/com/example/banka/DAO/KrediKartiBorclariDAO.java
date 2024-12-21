package com.example.banka.DAO;

import com.example.banka.Entity.KrediKartiBorclari;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class KrediKartiBorclariDAO {

    private final JdbcTemplate jdbcTemplate;

    public KrediKartiBorclariDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addBorc(KrediKartiBorclari borc) {
        String sql = "INSERT INTO kredi_karti_borclari (kart_id, borc_tutari, son_odeme_tarihi, odenen_tutar) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                borc.getKartId(),
                borc.getBorcTutari(),
                borc.getSonOdemeTarihi(),
                borc.getOdenenTutar());
    }


    public List<KrediKartiBorclari> getAllBorclar() {
        String sql = "SELECT * FROM kredi_karti_borclari";
        return jdbcTemplate.query(sql, new KrediKartiBorclariRowMapper());
    }

    public List<Map<String, Object>> getAllMusteriKartBorclari() {
        String sql = """
            SELECT m.musteri_id, m.ad, m.soyad, h.hesap_id, h.hesap_adi, k.kart_id, k.kart_numarasi, kkb.borc_tutari, kkb.son_odeme_tarihi, kkb.odenen_tutar
            FROM kredi_karti_borclari kkb
            JOIN kartlar k ON kkb.kart_id = k.kart_id
            JOIN hesaplar h ON k.hesap_id = h.hesap_id
            JOIN musteriler m ON h.musteri_id = m.musteri_id
        """;
        return jdbcTemplate.queryForList(sql);
    }


    public List<Map<String, Object>> getKartBorclariByMusteriId(Long musteriId) {
        String sql = """
            SELECT m.musteri_id, m.ad, m.soyad, h.hesap_id, h.hesap_adi, k.kart_id, k.kart_numarasi, kkb.borc_tutari, kkb.son_odeme_tarihi, kkb.odenen_tutar
            FROM kredi_karti_borclari kkb
            JOIN kartlar k ON kkb.kart_id = k.kart_id
            JOIN hesaplar h ON k.hesap_id = h.hesap_id
            JOIN musteriler m ON h.musteri_id = m.musteri_id
            WHERE m.musteri_id = ?
        """;
        return jdbcTemplate.queryForList(sql, musteriId);
    }


    public KrediKartiBorclari getBorcById(Long borcId) {
        String sql = "SELECT * FROM kredi_karti_borclari WHERE borc_id = ?";
        return jdbcTemplate.queryForObject(sql, new KrediKartiBorclariRowMapper(), borcId);
    }


    public void updateBorc(KrediKartiBorclari borc) {
        String sql = "UPDATE kredi_karti_borclari SET borc_tutari = ?, son_odeme_tarihi = ?, odenen_tutar = ? WHERE borc_id = ?";
        jdbcTemplate.update(sql,
                borc.getBorcTutari(),
                borc.getSonOdemeTarihi(),
                borc.getOdenenTutar(),
                borc.getBorcId());
    }


    public void deleteBorc(Long borcId) {
        String sql = "DELETE FROM kredi_karti_borclari WHERE borc_id = ?";
        jdbcTemplate.update(sql, borcId);
    }


    private static class KrediKartiBorclariRowMapper implements RowMapper<KrediKartiBorclari> {
        @Override
        public KrediKartiBorclari mapRow(ResultSet rs, int rowNum) throws SQLException {
            KrediKartiBorclari borc = new KrediKartiBorclari();
            borc.setBorcId(rs.getLong("borc_id"));
            borc.setKartId(rs.getLong("kart_id"));
            borc.setBorcTutari(rs.getDouble("borc_tutari"));
            borc.setSonOdemeTarihi(rs.getTimestamp("son_odeme_tarihi").toLocalDateTime());
            borc.setOdenenTutar(rs.getDouble("odenen_tutar"));
            return borc;
        }
    }
}
