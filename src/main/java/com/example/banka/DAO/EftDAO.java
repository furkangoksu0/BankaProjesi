package com.example.banka.DAO;

import com.example.banka.Entity.Eft;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EftDAO {

    private final JdbcTemplate jdbcTemplate;

    public EftDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // EFT Ekleme
    public void addEft(Eft eft) {
        String sql = "INSERT INTO eft (gonderici_hesap_id, alici_hesap_id, tutar, eft_tarihi, durum) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                eft.getGondericiHesapId(),
                eft.getAliciHesapId(),
                eft.getTutar(),
                eft.getEftTarihi(),
                eft.getDurum());
    }

    // Tüm EFT'leri Getirme
    public List<Eft> getAllEft() {
        String sql = "SELECT * FROM eft";
        return jdbcTemplate.query(sql, new EftRowMapper());
    }

    // Belirli Bir EFT'yi Getirme
    public Eft getEftById(Long eftId) {
        String sql = "SELECT * FROM eft WHERE eft_id = ?";
        return jdbcTemplate.queryForObject(sql, new EftRowMapper(), eftId);
    }

    // EFT Güncelleme
    public void updateEft(Eft eft) {
        String sql = "UPDATE eft SET gonderici_hesap_id = ?, alici_hesap_id = ?, tutar = ?, eft_tarihi = ?, durum = ? WHERE eft_id = ?";
        jdbcTemplate.update(sql,
                eft.getGondericiHesapId(),
                eft.getAliciHesapId(),
                eft.getTutar(),
                eft.getEftTarihi(),
                eft.getDurum(),
                eft.getEftId());
    }

    // EFT Silme
    public void deleteEft(Long eftId) {
        String sql = "DELETE FROM eft WHERE eft_id = ?";
        jdbcTemplate.update(sql, eftId);
    }

    // RowMapper Sınıfı
    private static class EftRowMapper implements RowMapper<Eft> {
        @Override
        public Eft mapRow(ResultSet rs, int rowNum) throws SQLException {
            Eft eft = new Eft();
            eft.setEftId(rs.getLong("eft_id"));
            eft.setGondericiHesapId(rs.getLong("gonderici_hesap_id"));
            eft.setAliciHesapId(rs.getLong("alici_hesap_id"));
            eft.setTutar(rs.getDouble("tutar"));
            eft.setEftTarihi(rs.getTimestamp("eft_tarihi").toLocalDateTime());
            eft.setDurum(rs.getString("durum"));
            return eft;
        }
    }
}
