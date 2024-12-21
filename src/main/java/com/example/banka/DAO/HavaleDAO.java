package com.example.banka.DAO;

import com.example.banka.Entity.Havale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HavaleDAO {

    private final JdbcTemplate jdbcTemplate;

    public HavaleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Havale Ekleme
    public void addHavale(Havale havale) {
        String sql = "INSERT INTO havale (gonderici_hesap_id, alici_hesap_id, tutar, havale_tarihi, durum) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                havale.getGondericiHesapId(),
                havale.getAliciHesapId(),
                havale.getTutar(),
                havale.getHavaleTarihi(),
                havale.getDurum());
    }

    // Tüm Havale Kayıtlarını Getirme
    public List<Havale> getAllHavale() {
        String sql = "SELECT * FROM havale";
        return jdbcTemplate.query(sql, new HavaleRowMapper());
    }

    // Belirli Bir Havale Kaydını Getirme
    public Havale getHavaleById(Long havaleId) {
        String sql = "SELECT * FROM havale WHERE havale_id = ?";
        return jdbcTemplate.queryForObject(sql, new HavaleRowMapper(), havaleId);
    }

    // Havale Güncelleme
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

    // Havale Silme
    public void deleteHavale(Long havaleId) {
        String sql = "DELETE FROM havale WHERE havale_id = ?";
        jdbcTemplate.update(sql, havaleId);
    }

    // RowMapper Sınıfı
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
