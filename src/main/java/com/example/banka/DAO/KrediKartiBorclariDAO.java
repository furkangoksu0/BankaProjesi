package com.example.banka.DAO;

import com.example.banka.Entity.KrediKartiBorclari;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KrediKartiBorclariDAO {

    private final JdbcTemplate jdbcTemplate;

    public KrediKartiBorclariDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Borç Ekleme
    public void addBorc(KrediKartiBorclari borc) {
        String sql = "INSERT INTO kredi_karti_borclari (kart_id, borc_tutari, son_odeme_tarihi, odenen_tutar) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                borc.getKartId(),
                borc.getBorcTutari(),
                borc.getSonOdemeTarihi(),
                borc.getOdenenTutar());
    }

    // Tüm Borçları Getirme
    public List<KrediKartiBorclari> getAllBorclar() {
        String sql = "SELECT * FROM kredi_karti_borclari";
        return jdbcTemplate.query(sql, new KrediKartiBorclariRowMapper());
    }

    // Belirli Borcu Getirme
    public KrediKartiBorclari getBorcById(Long borcId) {
        String sql = "SELECT * FROM kredi_karti_borclari WHERE borc_id = ?";
        return jdbcTemplate.queryForObject(sql, new KrediKartiBorclariRowMapper(), borcId);
    }

    // Borç Güncelleme
    public void updateBorc(KrediKartiBorclari borc) {
        String sql = "UPDATE kredi_karti_borclari SET borc_tutari = ?, son_odeme_tarihi = ?, odenen_tutar = ? WHERE borc_id = ?";
        jdbcTemplate.update(sql,
                borc.getBorcTutari(),
                borc.getSonOdemeTarihi(),
                borc.getOdenenTutar(),
                borc.getBorcId());
    }

    // Borç Silme
    public void deleteBorc(Long borcId) {
        String sql = "DELETE FROM kredi_karti_borclari WHERE borc_id = ?";
        jdbcTemplate.update(sql, borcId);
    }

    // RowMapper Sınıfı
    private static class KrediKartiBorclariRowMapper implements RowMapper<KrediKartiBorclari> {
        @Override
        public KrediKartiBorclari mapRow(ResultSet rs, int rowNum) throws SQLException {
            KrediKartiBorclari borc = new KrediKartiBorclari();
            borc.setBorcId(rs.getLong("borc_id"));
            borc.setKartId(rs.getLong("kart_id"));
            borc.setBorcTutari(rs.getDouble("borc_tutari"));
            borc.setSonOdemeTarihi(rs.getTimestamp("son_odeme_tarihi").toLocalDateTime());
            borc.setOdenenTutar(rs.getDouble("odenen_tutar"));
            return borc;
        }
    }
}
