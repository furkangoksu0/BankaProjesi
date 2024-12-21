package com.example.banka.DAO;

import com.example.banka.Entity.NakitAvans;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NakitAvansDAO {

    private final JdbcTemplate jdbcTemplate;

    public NakitAvansDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Nakit Avans Ekleme
    public void addNakitAvans(NakitAvans avans) {
        String sql = "INSERT INTO nakit_avans (kart_id, avans_tutari, avans_tarihi, odenen_tutar) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                avans.getKartId(),
                avans.getAvansTutari(),
                avans.getAvansTarihi(),
                avans.getOdenenTutar());
    }

    // Tüm Nakit Avansları Getirme
    public List<NakitAvans> getAllNakitAvans() {
        String sql = "SELECT * FROM nakit_avans";
        return jdbcTemplate.query(sql, new NakitAvansRowMapper());
    }

    // Belirli Nakit Avansı Getirme
    public NakitAvans getNakitAvansById(Long avansId) {
        String sql = "SELECT * FROM nakit_avans WHERE avans_id = ?";
        return jdbcTemplate.queryForObject(sql, new NakitAvansRowMapper(), avansId);
    }

    // Nakit Avans Güncelleme
    public void updateNakitAvans(NakitAvans avans) {
        String sql = "UPDATE nakit_avans SET avans_tutari = ?, avans_tarihi = ?, odenen_tutar = ? WHERE avans_id = ?";
        jdbcTemplate.update(sql,
                avans.getAvansTutari(),
                avans.getAvansTarihi(),
                avans.getOdenenTutar(),
                avans.getAvansId());
    }

    // Nakit Avans Silme
    public void deleteNakitAvans(Long avansId) {
        String sql = "DELETE FROM nakit_avans WHERE avans_id = ?";
        jdbcTemplate.update(sql, avansId);
    }

    // RowMapper Sınıfı
    private static class NakitAvansRowMapper implements RowMapper<NakitAvans> {
        @Override
        public NakitAvans mapRow(ResultSet rs, int rowNum) throws SQLException {
            NakitAvans avans = new NakitAvans();
            avans.setAvansId(rs.getLong("avans_id"));
            avans.setKartId(rs.getLong("kart_id"));
            avans.setAvansTutari(rs.getDouble("avans_tutari"));
            avans.setAvansTarihi(rs.getTimestamp("avans_tarihi").toLocalDateTime());
            avans.setOdenenTutar(rs.getDouble("odenen_tutar"));
            return avans;
        }
    }
}
