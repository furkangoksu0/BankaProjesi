package com.example.banka.DAO;

import com.example.banka.Entity.Cekler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class CeklerDAO {

    private final JdbcTemplate jdbcTemplate;

    public CeklerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addCek(Cekler cek) {
        String sql = "INSERT INTO cekler (cek_numarasi, kesilme_tarihi, vade_tarihi, tutar, hesap_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                cek.getCekNumarasi(),
                cek.getKesilmeTarihi(),
                cek.getVadeTarihi(),
                cek.getTutar(),
                cek.getHesapId());
    }

    public List<Cekler> getAllCekler() {
        String sql = "SELECT * FROM cekler";
        return jdbcTemplate.query(sql, new CeklerRowMapper());
    }

    public Cekler getCekById(Long cekId) {
        String sql = "SELECT * FROM cekler WHERE cek_id = ?";
        return jdbcTemplate.queryForObject(sql, new CeklerRowMapper(), cekId);
    }
    public List<Map<String, Object>> getAllCeklerByMusteri() {
        String sql = """
            SELECT c.cek_id, c.cek_numarasi, c.kesilme_tarihi, c.vade_tarihi, c.tutar,
                   m.ad AS musteri_ad, m.soyad AS musteri_soyad, h.hesap_adi
            FROM cekler c
            JOIN hesaplar h ON c.hesap_id = h.hesap_id
            JOIN musteriler m ON h.musteri_id = m.musteri_id
        """;
        return jdbcTemplate.queryForList(sql);
    }


    public List<Map<String, Object>> getCeklerByMusteriId(Long musteriId) {
        String sql = """
            SELECT c.cek_id, c.cek_numarasi, c.kesilme_tarihi, c.vade_tarihi, c.tutar,
                   m.ad AS musteri_ad, m.soyad AS musteri_soyad, h.hesap_adi
            FROM cekler c
            JOIN hesaplar h ON c.hesap_id = h.hesap_id
            JOIN musteriler m ON h.musteri_id = m.musteri_id
            WHERE m.musteri_id = ?
        """;
        return jdbcTemplate.queryForList(sql, musteriId);
    }


    public List<Map<String, Object>> getCeklerByHesapId(Long hesapId) {
        String sql = """
            SELECT c.cek_id, c.cek_numarasi, c.kesilme_tarihi, c.vade_tarihi, c.tutar,
                   h.hesap_adi
            FROM cekler c
            JOIN hesaplar h ON c.hesap_id = h.hesap_id
            WHERE c.hesap_id = ?
        """;
        return jdbcTemplate.queryForList(sql, hesapId);
    }

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

    public void deleteCek(Long cekId) {
        String sql = "DELETE FROM cekler WHERE cek_id = ?";
        jdbcTemplate.update(sql, cekId);
    }

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
