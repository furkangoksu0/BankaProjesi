package com.example.banka.DAO;

import com.example.banka.Entity.KrediOdemeleri;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KrediOdemeleriDAO {

    private final JdbcTemplate jdbcTemplate;

    public KrediOdemeleriDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Ödeme Ekleme
    public void addOdeme(KrediOdemeleri odeme) {
        String sql = "INSERT INTO kredi_odemeleri (kredi_id, odeme_tarihi, odenen_tutar, odeme_turu) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                odeme.getKrediId(),
                odeme.getOdemeTarihi(),
                odeme.getOdenenTutar(),
                odeme.getOdemeTuru());
    }

    // Tüm Ödemeleri Getirme
    public List<KrediOdemeleri> getAllOdemeler() {
        String sql = "SELECT * FROM kredi_odemeleri";
        return jdbcTemplate.query(sql, new KrediOdemeleriRowMapper());
    }

    // Ödeme Bulma (ID ile)
    public KrediOdemeleri getOdemeById(Long odemeId) {
        String sql = "SELECT * FROM kredi_odemeleri WHERE odeme_id = ?";
        return jdbcTemplate.queryForObject(sql, new KrediOdemeleriRowMapper(), odemeId);
    }

    // Ödeme Silme
    public void deleteOdeme(Long odemeId) {
        String sql = "DELETE FROM kredi_odemeleri WHERE odeme_id = ?";
        jdbcTemplate.update(sql, odemeId);
    }

    // RowMapper Sınıfı
    private static class KrediOdemeleriRowMapper implements RowMapper<KrediOdemeleri> {
        @Override
        public KrediOdemeleri mapRow(ResultSet rs, int rowNum) throws SQLException {
            KrediOdemeleri odeme = new KrediOdemeleri();
            odeme.setOdemeId(rs.getLong("odeme_id"));
            odeme.setKrediId(rs.getLong("kredi_id"));
            odeme.setOdemeTarihi(rs.getTimestamp("odeme_tarihi").toLocalDateTime());
            odeme.setOdenenTutar(rs.getDouble("odenen_tutar"));
            odeme.setOdemeTuru(rs.getString("odeme_turu"));
            return odeme;
        }
    }
}
