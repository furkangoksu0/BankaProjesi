package com.example.banka.DAO;

import com.example.banka.Entity.Islemler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class IslemlerDAO {

    private final JdbcTemplate jdbcTemplate;

    public IslemlerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addIslem(Islemler islem) {
        String sql = "INSERT INTO islemler (hesap_id, islem_tarihi, islem_turu, tutar, aciklama, sube_id) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                islem.getHesapId(),
                islem.getIslemTarihi(),
                islem.getIslemTuru(),
                islem.getTutar(),
                islem.getAciklama(),
                islem.getSubeId());
    }


    public List<Islemler> getAllIslemler() {
        String sql = "SELECT * FROM islemler";
        return jdbcTemplate.query(sql, new IslemlerRowMapper());
    }


    public Islemler getIslemById(Long islemId) {
        String sql = "SELECT * FROM islemler WHERE islem_id = ?";
        return jdbcTemplate.queryForObject(sql, new IslemlerRowMapper(), islemId);
    }

    public List<Map<String, Object>> getAllIslemlerByMusteri() {
        String sql = """
            SELECT i.islem_id, i.islem_turu, i.islem_tarihi, i.tutar, i.aciklama, 
                   m.ad AS musteri_ad, m.soyad AS musteri_soyad, 
                   h.hesap_adi, s.sube_adi
            FROM islemler i
            JOIN hesaplar h ON i.hesap_id = h.hesap_id
            JOIN musteriler m ON h.musteri_id = m.musteri_id
            JOIN subeler s ON i.sube_id = s.sube_id
        """;
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> getIslemlerByMusteriId(Long musteriId) {
        String sql = """
            SELECT i.islem_id, i.islem_turu, i.islem_tarihi, i.tutar, i.aciklama, 
                   m.ad AS musteri_ad, m.soyad AS musteri_soyad, 
                   h.hesap_adi, s.sube_adi
            FROM islemler i
            JOIN hesaplar h ON i.hesap_id = h.hesap_id
            JOIN musteriler m ON h.musteri_id = m.musteri_id
            JOIN subeler s ON i.sube_id = s.sube_id
            WHERE m.musteri_id = ?
        """;
        return jdbcTemplate.queryForList(sql, musteriId);
    }

    public List<Map<String, Object>> getIslemlerByHesapId(Long hesapId) {
        String sql = """
            SELECT i.islem_id, i.islem_turu, i.islem_tarihi, i.tutar, i.aciklama, 
                   h.hesap_adi, s.sube_adi
            FROM islemler i
            JOIN hesaplar h ON i.hesap_id = h.hesap_id
            JOIN subeler s ON i.sube_id = s.sube_id
            WHERE i.hesap_id = ?
        """;
        return jdbcTemplate.queryForList(sql, hesapId);
    }


    public List<Map<String, Object>> getIslemlerBySubeId(Long subeId) {
        String sql = """
            SELECT i.islem_id, i.islem_turu, i.islem_tarihi, i.tutar, i.aciklama, 
                   s.sube_adi, h.hesap_adi
            FROM islemler i
            JOIN subeler s ON i.sube_id = s.sube_id
            JOIN hesaplar h ON i.hesap_id = h.hesap_id
            WHERE i.sube_id = ?
        """;
        return jdbcTemplate.queryForList(sql, subeId);
    }


    public void updateIslem(Islemler islem) {
        String sql = "UPDATE islemler SET hesap_id = ?, islem_tarihi = ?, islem_turu = ?, tutar = ?, aciklama = ?, sube_id = ? WHERE islem_id = ?";
        jdbcTemplate.update(sql,
                islem.getHesapId(),
                islem.getIslemTarihi(),
                islem.getIslemTuru(),
                islem.getTutar(),
                islem.getAciklama(),
                islem.getSubeId(),
                islem.getIslemId());
    }


    public void deleteIslem(Long islemId) {
        String sql = "DELETE FROM islemler WHERE islem_id = ?";
        jdbcTemplate.update(sql, islemId);
    }


    private static class IslemlerRowMapper implements RowMapper<Islemler> {
        @Override
        public Islemler mapRow(ResultSet rs, int rowNum) throws SQLException {
            Islemler islem = new Islemler();
            islem.setIslemId(rs.getLong("islem_id"));
            islem.setHesapId(rs.getLong("hesap_id"));
            islem.setIslemTarihi(rs.getTimestamp("islem_tarihi").toLocalDateTime());
            islem.setIslemTuru(rs.getString("islem_turu"));
            islem.setTutar(rs.getDouble("tutar"));
            islem.setAciklama(rs.getString("aciklama"));
            islem.setSubeId(rs.getLong("sube_id"));
            return islem;
        }
    }
}
