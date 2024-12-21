package com.example.banka.DAO;

import com.example.banka.Entity.Islemler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class IslemlerDAO {

    private final JdbcTemplate jdbcTemplate;

    public IslemlerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // İşlem Ekleme
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

    // Tüm İşlemleri Getirme
    public List<Islemler> getAllIslemler() {
        String sql = "SELECT * FROM islemler";
        return jdbcTemplate.query(sql, new IslemlerRowMapper());
    }

    // Belirli Bir İşlemi Getirme
    public Islemler getIslemById(Long islemId) {
        String sql = "SELECT * FROM islemler WHERE islem_id = ?";
        return jdbcTemplate.queryForObject(sql, new IslemlerRowMapper(), islemId);
    }

    // İşlem Güncelleme
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

    // İşlem Silme
    public void deleteIslem(Long islemId) {
        String sql = "DELETE FROM islemler WHERE islem_id = ?";
        jdbcTemplate.update(sql, islemId);
    }

    // RowMapper Sınıfı
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
