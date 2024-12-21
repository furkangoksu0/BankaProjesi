package com.example.banka.DAO;

import com.example.banka.Entity.Eft;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class EftDAO {

    private final JdbcTemplate jdbcTemplate;

    public EftDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addEft(Eft eft) {
        String sql = "INSERT INTO eft (gonderici_hesap_id, alici_hesap_id, tutar, eft_tarihi, durum) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                eft.getGondericiHesapId(),
                eft.getAliciHesapId(),
                eft.getTutar(),
                eft.getEftTarihi(),
                eft.getDurum());
    }


    public List<Eft> getAllEft() {
        String sql = "SELECT * FROM eft";
        return jdbcTemplate.query(sql, new EftRowMapper());
    }

    public List<Map<String, Object>> getAllEftByMusteri() {
        String sql = """
            SELECT e.eft_id, e.gonderici_hesap_id, e.alici_hesap_id, e.tutar, e.eft_tarihi, e.durum,
                   m.ad AS musteri_ad, m.soyad AS musteri_soyad,
                   g_hesap.hesap_adi AS gonderici_hesap_adi, a_hesap.hesap_adi AS alici_hesap_adi
            FROM eft e
            JOIN hesaplar g_hesap ON e.gonderici_hesap_id = g_hesap.hesap_id
            JOIN hesaplar a_hesap ON e.alici_hesap_id = a_hesap.hesap_id
            JOIN musteriler m ON g_hesap.musteri_id = m.musteri_id
        """;
        return jdbcTemplate.queryForList(sql);
    }


    public List<Map<String, Object>> getEftByMusteriId(Long musteriId) {
        String sql = """
            SELECT e.eft_id, e.gonderici_hesap_id, e.alici_hesap_id, e.tutar, e.eft_tarihi, e.durum,
                   m.ad AS musteri_ad, m.soyad AS musteri_soyad,
                   g_hesap.hesap_adi AS gonderici_hesap_adi, a_hesap.hesap_adi AS alici_hesap_adi
            FROM eft e
            JOIN hesaplar g_hesap ON e.gonderici_hesap_id = g_hesap.hesap_id
            JOIN hesaplar a_hesap ON e.alici_hesap_id = a_hesap.hesap_id
            JOIN musteriler m ON g_hesap.musteri_id = m.musteri_id
            WHERE m.musteri_id = ?
        """;
        return jdbcTemplate.queryForList(sql, musteriId);
    }


    public List<Map<String, Object>> getEftByHesapId(Long hesapId) {
        String sql = """
            SELECT e.eft_id, e.gonderici_hesap_id, e.alici_hesap_id, e.tutar, e.eft_tarihi, e.durum,
                   g_hesap.hesap_adi AS gonderici_hesap_adi, a_hesap.hesap_adi AS alici_hesap_adi
            FROM eft e
            JOIN hesaplar g_hesap ON e.gonderici_hesap_id = g_hesap.hesap_id
            JOIN hesaplar a_hesap ON e.alici_hesap_id = a_hesap.hesap_id
            WHERE g_hesap.hesap_id = ? OR a_hesap.hesap_id = ?
        """;
        return jdbcTemplate.queryForList(sql, hesapId, hesapId);
    }

    public Eft getEftById(Long eftId) {
        String sql = "SELECT * FROM eft WHERE eft_id = ?";
        return jdbcTemplate.queryForObject(sql, new EftRowMapper(), eftId);
    }


    public void updateEft(Eft eft) {
        String sql = "UPDATE eft SET gonderici_hesap_id = ?, alici_hesap_id = ?, tutar = ?, eft_tarihi = ?, durum = ? WHERE eft_id = ?";
        jdbcTemplate.update(sql,
                eft.getGondericiHesapId(),
                eft.getAliciHesapId(),
                eft.getTutar(),
                eft.getEftTarihi(),
                eft.getDurum(),
                eft.getEftId());
    }


    public void deleteEft(Long eftId) {
        String sql = "DELETE FROM eft WHERE eft_id = ?";
        jdbcTemplate.update(sql, eftId);
    }

    private static class EftRowMapper implements RowMapper<Eft> {
        @Override
        public Eft mapRow(ResultSet rs, int rowNum) throws SQLException {
            Eft eft = new Eft();
            eft.setEftId(rs.getLong("eft_id"));
            eft.setGondericiHesapId(rs.getLong("gonderici_hesap_id"));
            eft.setAliciHesapId(rs.getLong("alici_hesap_id"));
            eft.setTutar(rs.getDouble("tutar"));
            eft.setEftTarihi(rs.getTimestamp("eft_tarihi").toLocalDateTime());
            eft.setDurum(rs.getString("durum"));
            return eft;
        }
    }
}
