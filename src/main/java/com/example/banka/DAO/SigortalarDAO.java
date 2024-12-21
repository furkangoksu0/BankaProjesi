package com.example.banka.DAO;

import com.example.banka.Entity.Sigortalar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SigortalarDAO {

    private final JdbcTemplate jdbcTemplate;

    public SigortalarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Sigorta Ekleme
    public void addSigorta(Sigortalar sigorta) {
        String sql = "INSERT INTO sigortalar (sigorta_turu, baslangic_tarihi, bitis_tarihi, prim_tutari, musteri_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                sigorta.getSigortaTuru(),
                sigorta.getBaslangicTarihi(),
                sigorta.getBitisTarihi(),
                sigorta.getPrimTutari(),
                sigorta.getMusteriId());
    }

    // Tüm Sigortaları Getirme
    public List<Sigortalar> getAllSigortalar() {
        String sql = "SELECT * FROM sigortalar";
        return jdbcTemplate.query(sql, new SigortalarRowMapper());
    }

    // Belirli Bir Sigortayı Getirme
    public Sigortalar getSigortaById(Long sigortaId) {
        String sql = "SELECT * FROM sigortalar WHERE sigorta_id = ?";
        return jdbcTemplate.queryForObject(sql, new SigortalarRowMapper(), sigortaId);
    }

    // Sigorta Güncelleme
    public void updateSigorta(Sigortalar sigorta) {
        String sql = "UPDATE sigortalar SET sigorta_turu = ?, baslangic_tarihi = ?, bitis_tarihi = ?, prim_tutari = ?, musteri_id = ? WHERE sigorta_id = ?";
        jdbcTemplate.update(sql,
                sigorta.getSigortaTuru(),
                sigorta.getBaslangicTarihi(),
                sigorta.getBitisTarihi(),
                sigorta.getPrimTutari(),
                sigorta.getMusteriId(),
                sigorta.getSigortaId());
    }

    // Sigorta Silme
    public void deleteSigorta(Long sigortaId) {
        String sql = "DELETE FROM sigortalar WHERE sigorta_id = ?";
        jdbcTemplate.update(sql, sigortaId);
    }

    // RowMapper Sınıfı
    private static class SigortalarRowMapper implements RowMapper<Sigortalar> {
        @Override
        public Sigortalar mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sigortalar sigorta = new Sigortalar();
            sigorta.setSigortaId(rs.getLong("sigorta_id"));
            sigorta.setSigortaTuru(rs.getString("sigorta_turu"));
            sigorta.setBaslangicTarihi(rs.getTimestamp("baslangic_tarihi").toLocalDateTime());
            sigorta.setBitisTarihi(rs.getTimestamp("bitis_tarihi") != null ? rs.getTimestamp("bitis_tarihi").toLocalDateTime() : null);
            sigorta.setPrimTutari(rs.getDouble("prim_tutari"));
            sigorta.setMusteriId(rs.getLong("musteri_id"));
            return sigorta;
        }
    }
}
