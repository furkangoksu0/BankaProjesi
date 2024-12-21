package com.example.banka.DAO;

import com.example.banka.Entity.Havale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class HavaleDAO {

    private final JdbcTemplate jdbcTemplate;

    public HavaleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addHavale(Havale havale) {
        String sql = "INSERT INTO havale (gonderici_hesap_id, alici_hesap_id, tutar, havale_tarihi, durum) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                havale.getGondericiHesapId(),
                havale.getAliciHesapId(),
                havale.getTutar(),
                havale.getHavaleTarihi(),
                havale.getDurum());
    }


    public List<Havale> getAllHavale() {
        String sql = "SELECT * FROM havale";
        return jdbcTemplate.query(sql, new HavaleRowMapper());
    }

    public List<Map<String, Object>> getAllHavaleByMusteri() {
        String sql = """
            SELECT h.havale_id, h.gonderici_hesap_id, h.alici_hesap_id, h.tutar, h.havale_tarihi, h.durum,
                   m.ad AS musteri_ad, m.soyad AS musteri_soyad,
                   g_hesap.hesap_adi AS gonderici_hesap_adi, a_hesap.hesap_adi AS alici_hesap_adi
            FROM havale h
            JOIN hesaplar g_hesap ON h.gonderici_hesap_id = g_hesap.hesap_id
            JOIN hesaplar a_hesap ON h.alici_hesap_id = a_hesap.hesap_id
            JOIN musteriler m ON g_hesap.musteri_id = m.musteri_id
        """;
        return jdbcTemplate.queryForList(sql);
    }


    public List<Map<String, Object>> getHavaleByMusteriId(Long musteriId) {
        String sql = """
            SELECT h.havale_id, h.gonderici_hesap_id, h.alici_hesap_id, h.tutar, h.havale_tarihi, h.durum,
                   m.ad AS musteri_ad, m.soyad AS musteri_soyad,
                   g_hesap.hesap_adi AS gonderici_hesap_adi, a_hesap.hesap_adi AS alici_hesap_adi
            FROM havale h
            JOIN hesaplar g_hesap ON h.gonderici_hesap_id = g_hesap.hesap_id
            JOIN hesaplar a_hesap ON h.alici_hesap_id = a_hesap.hesap_id
            JOIN musteriler m ON g_hesap.musteri_id = m.musteri_id
            WHERE m.musteri_id = ?
        """;
        return jdbcTemplate.queryForList(sql, musteriId);
    }


    public List<Map<String, Object>> getHavaleByHesapId(Long hesapId) {
        String sql = """
            SELECT h.havale_id, h.gonderici_hesap_id, h.alici_hesap_id, h.tutar, h.havale_tarihi, h.durum,
                   g_hesap.hesap_adi AS gonderici_hesap_adi, a_hesap.hesap_adi AS alici_hesap_adi
            FROM havale h
            JOIN hesaplar g_hesap ON h.gonderici_hesap_id = g_hesap.hesap_id
            JOIN hesaplar a_hesap ON h.alici_hesap_id = a_hesap.hesap_id
            WHERE g_hesap.hesap_id = ? OR a_hesap.hesap_id = ?
        """;
        return jdbcTemplate.queryForList(sql, hesapId, hesapId);
    }

    public Havale getHavaleById(Long havaleId) {
        String sql = "SELECT * FROM havale WHERE havale_id = ?";
        return jdbcTemplate.queryForObject(sql, new HavaleRowMapper(), havaleId);
    }


    public void updateHavale(Havale havale) {
        String sql = "UPDATE havale SET gonderici_hesap_id = ?, alici_hesap_id = ?, tutar = ?, havale_tarihi = ?, durum = ? WHERE havale_id = ?";
        jdbcTemplate.update(sql,
                havale.getGondericiHesapId(),
                havale.getAliciHesapId(),
                havale.getTutar(),
                havale.getHavaleTarihi(),
                havale.getDurum(),
                havale.getHavaleId());
    }


    public void deleteHavale(Long havaleId) {
        String sql = "DELETE FROM havale WHERE havale_id = ?";
        jdbcTemplate.update(sql, havaleId);
    }


    private static class HavaleRowMapper implements RowMapper<Havale> {
        @Override
        public Havale mapRow(ResultSet rs, int rowNum) throws SQLException {
            Havale havale = new Havale();
            havale.setHavaleId(rs.getLong("havale_id"));
            havale.setGondericiHesapId(rs.getLong("gonderici_hesap_id"));
            havale.setAliciHesapId(rs.getLong("alici_hesap_id"));
            havale.setTutar(rs.getDouble("tutar"));
            havale.setHavaleTarihi(rs.getTimestamp("havale_tarihi").toLocalDateTime());
            havale.setDurum(rs.getString("durum"));
            return havale;
        }
    }
}
