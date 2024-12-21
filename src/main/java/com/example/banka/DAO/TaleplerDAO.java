package com.example.banka.DAO;

import com.example.banka.Entity.Talepler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class TaleplerDAO {

    private final JdbcTemplate jdbcTemplate;

    public TaleplerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addTalep(Talepler talep) {
        String sql = "INSERT INTO talepler (talep_turu, talep_tarihi, musteri_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                talep.getTalepTuru(),
                talep.getTalepTarihi(),
                talep.getMusteriId());
    }

    public List<Talepler> getAllTalepler() {
        String sql = "SELECT * FROM talepler";
        return jdbcTemplate.query(sql, new TaleplerRowMapper());
    }

    public Talepler getTalepById(Long talepId) {
        String sql = "SELECT * FROM talepler WHERE talep_id = ?";
        return jdbcTemplate.queryForObject(sql, new TaleplerRowMapper(), talepId);
    }

    public List<Map<String, Object>> getAllTaleplerByMusteri() {
        String sql = """
            SELECT t.talep_id, t.talep_turu, t.talep_tarihi, 
                   m.ad AS musteri_ad, m.soyad AS musteri_soyad, m.telefon, m.email
            FROM talepler t
            JOIN musteriler m ON t.musteri_id = m.musteri_id
        """;
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> getTaleplerByMusteriId(Long musteriId) {
        String sql = """
            SELECT t.talep_id, t.talep_turu, t.talep_tarihi, 
                   m.ad AS musteri_ad, m.soyad AS musteri_soyad, m.telefon, m.email
            FROM talepler t
            JOIN musteriler m ON t.musteri_id = m.musteri_id
            WHERE t.musteri_id = ?
        """;
        return jdbcTemplate.queryForList(sql, musteriId);
    }

    public void updateTalep(Talepler talep) {
        String sql = "UPDATE talepler SET talep_turu = ?, talep_tarihi = ?, musteri_id = ? WHERE talep_id = ?";
        jdbcTemplate.update(sql,
                talep.getTalepTuru(),
                talep.getTalepTarihi(),
                talep.getMusteriId(),
                talep.getTalepId());
    }

    public void deleteTalep(Long talepId) {
        String sql = "DELETE FROM talepler WHERE talep_id = ?";
        jdbcTemplate.update(sql, talepId);
    }

    private static class TaleplerRowMapper implements RowMapper<Talepler> {
        @Override
        public Talepler mapRow(ResultSet rs, int rowNum) throws SQLException {
            Talepler talep = new Talepler();
            talep.setTalepId(rs.getLong("talep_id"));
            talep.setTalepTuru(rs.getString("talep_turu"));
            talep.setTalepTarihi(rs.getTimestamp("talep_tarihi").toLocalDateTime());
            talep.setMusteriId(rs.getLong("musteri_id"));
            return talep;
        }
    }
}
