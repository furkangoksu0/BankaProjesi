package com.example.banka.DAO;

import com.example.banka.Entity.Cekler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CeklerDAO {

    private final JdbcTemplate jdbcTemplate;

    public CeklerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Çek Ekleme
    public void addCek(Cekler cek) {
        String sql = "INSERT INTO cekler (cek_numarasi, kesilme_tarihi, vade_tarihi, tutar, hesap_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                cek.getCekNumarasi(),
                cek.getKesilmeTarihi(),
                cek.getVadeTarihi(),
                cek.getTutar(),
                cek.getHesapId());
    }

    // Tüm Çekleri Getirme
    public List<Cekler> getAllCekler() {
        String sql = "SELECT * FROM cekler";
        return jdbcTemplate.query(sql, new CeklerRowMapper());
    }

    // Belirli Bir Çeki Getirme
    public Cekler getCekById(Long cekId) {
        String sql = "SELECT * FROM cekler WHERE cek_id = ?";
        return jdbcTemplate.queryForObject(sql, new CeklerRowMapper(), cekId);
    }

    // Çek Güncelleme
    public void updateCek(Cekler cek) {
        String sql = "UPDATE cekler SET cek_numarasi = ?, kesilme_tarihi = ?, vade_tarihi = ?, tutar = ?, hesap_id = ? WHERE cek_id = ?";
        jdbcTemplate.update(sql,
                cek.getCekNumarasi(),
                cek.getKesilmeTarihi(),
                cek.getVadeTarihi(),
                cek.getTutar(),
                cek.getHesapId(),
                cek.getCekId());
    }

    // Çek Silme
    public void deleteCek(Long cekId) {
        String sql = "DELETE FROM cekler WHERE cek_id = ?";
        jdbcTemplate.update(sql, cekId);
    }

    // RowMapper Sınıfı
    private static class CeklerRowMapper implements RowMapper<Cekler> {
        @Override
        public Cekler mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cekler cek = new Cekler();
            cek.setCekId(rs.getLong("cek_id"));
            cek.setCekNumarasi(rs.getString("cek_numarasi"));
            cek.setKesilmeTarihi(rs.getTimestamp("kesilme_tarihi").toLocalDateTime());
            cek.setVadeTarihi(rs.getTimestamp("vade_tarihi").toLocalDateTime());
            cek.setTutar(rs.getDouble("tutar"));
            cek.setHesapId(rs.getLong("hesap_id"));
            return cek;
        }
    }
}
