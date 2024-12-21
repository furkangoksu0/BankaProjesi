package com.example.banka.DAO;

import com.example.banka.Entity.YatirimHesaplari;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class YatirimHesaplariDAO {

    private final JdbcTemplate jdbcTemplate;

    public YatirimHesaplariDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Yatırım Hesabı Ekleme
    public void addYatirimHesabi(YatirimHesaplari yatirimHesabi) {
        String sql = "INSERT INTO yatirim_hesaplari (bakiye, alis_tarihi, satis_tarihi, yatirim_turu, musteri_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                yatirimHesabi.getBakiye(),
                yatirimHesabi.getAlisTarihi(),
                yatirimHesabi.getSatisTarihi(),
                yatirimHesabi.getYatirimTuru(),
                yatirimHesabi.getMusteriId());
    }

    // Tüm Yatırım Hesaplarını Getirme
    public List<YatirimHesaplari> getAllYatirimHesaplari() {
        String sql = "SELECT * FROM yatirim_hesaplari";
        return jdbcTemplate.query(sql, new YatirimHesaplariRowMapper());
    }

    // Belirli Bir Yatırım Hesabını Getirme
    public YatirimHesaplari getYatirimHesabiById(Long yatirimId) {
        String sql = "SELECT * FROM yatirim_hesaplari WHERE yatirim_id = ?";
        return jdbcTemplate.queryForObject(sql, new YatirimHesaplariRowMapper(), yatirimId);
    }

    // Yatırım Hesabını Güncelleme
    public void updateYatirimHesabi(YatirimHesaplari yatirimHesabi) {
        String sql = "UPDATE yatirim_hesaplari SET bakiye = ?, alis_tarihi = ?, satis_tarihi = ?, yatirim_turu = ?, musteri_id = ? WHERE yatirim_id = ?";
        jdbcTemplate.update(sql,
                yatirimHesabi.getBakiye(),
                yatirimHesabi.getAlisTarihi(),
                yatirimHesabi.getSatisTarihi(),
                yatirimHesabi.getYatirimTuru(),
                yatirimHesabi.getMusteriId(),
                yatirimHesabi.getYatirimId());
    }

    // Yatırım Hesabını Silme
    public void deleteYatirimHesabi(Long yatirimId) {
        String sql = "DELETE FROM yatirim_hesaplari WHERE yatirim_id = ?";
        jdbcTemplate.update(sql, yatirimId);
    }

    // RowMapper Sınıfı
    private static class YatirimHesaplariRowMapper implements RowMapper<YatirimHesaplari> {
        @Override
        public YatirimHesaplari mapRow(ResultSet rs, int rowNum) throws SQLException {
            YatirimHesaplari yatirimHesabi = new YatirimHesaplari();
            yatirimHesabi.setYatirimId(rs.getLong("yatirim_id"));
            yatirimHesabi.setBakiye(rs.getDouble("bakiye"));
            yatirimHesabi.setAlisTarihi(rs.getTimestamp("alis_tarihi").toLocalDateTime());
            if (rs.getTimestamp("satis_tarihi") != null) {
                yatirimHesabi.setSatisTarihi(rs.getTimestamp("satis_tarihi").toLocalDateTime());
            }
            yatirimHesabi.setYatirimTuru(rs.getString("yatirim_turu"));
            yatirimHesabi.setMusteriId(rs.getLong("musteri_id"));
            return yatirimHesabi;
        }
    }
}
