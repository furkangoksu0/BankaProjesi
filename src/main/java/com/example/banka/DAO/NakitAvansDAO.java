package com.example.banka.DAO;

import com.example.banka.Entity.NakitAvans;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class NakitAvansDAO {

    private final JdbcTemplate jdbcTemplate;

    public NakitAvansDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addNakitAvans(NakitAvans avans) {
        String sql = "INSERT INTO nakit_avans (kart_id, avans_tutari, avans_tarihi, odenen_tutar) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                avans.getKartId(),
                avans.getAvansTutari(),
                avans.getAvansTarihi(),
                avans.getOdenenTutar());
    }


    public List<NakitAvans> getAllNakitAvans() {
        String sql = "SELECT * FROM nakit_avans";
        return jdbcTemplate.query(sql, new NakitAvansRowMapper());
    }

    public List<Map<String, Object>> getAllNakitAvansbyMusteri() {
        String sql = """
            SELECT na.avans_id, na.avans_tutari, na.avans_tarihi, na.odenen_tutar, 
                   k.kart_numarasi, h.hesap_adi, m.ad AS musteri_ad, m.soyad AS musteri_soyad
            FROM nakit_avans na
            JOIN kartlar k ON na.kart_id = k.kart_id
            JOIN hesaplar h ON k.hesap_id = h.hesap_id
            JOIN musteriler m ON h.musteri_id = m.musteri_id
        """;
        return jdbcTemplate.queryForList(sql);
    }


    public NakitAvans getNakitAvansById(Long avansId) {
        String sql = "SELECT * FROM nakit_avans WHERE avans_id = ?";
        return jdbcTemplate.queryForObject(sql, new NakitAvansRowMapper(), avansId);
    }

    public List<Map<String, Object>> getNakitAvansByMusteriId(Long musteriId) {
        String sql = """
            SELECT na.avans_id, na.avans_tutari, na.avans_tarihi, na.odenen_tutar, 
                   k.kart_numarasi, h.hesap_adi, m.ad AS musteri_ad, m.soyad AS musteri_soyad
            FROM nakit_avans na
            JOIN kartlar k ON na.kart_id = k.kart_id
            JOIN hesaplar h ON k.hesap_id = h.hesap_id
            JOIN musteriler m ON h.musteri_id = m.musteri_id
            WHERE m.musteri_id = ?
        """;
        return jdbcTemplate.queryForList(sql, musteriId);
    }


    public List<Map<String, Object>> getNakitAvansByKartNumarasi(String kartNumarasi) {
        String sql = """
            SELECT na.avans_id, na.avans_tutari, na.avans_tarihi, na.odenen_tutar, 
                   k.kart_numarasi, h.hesap_adi, m.ad AS musteri_ad, m.soyad AS musteri_soyad
            FROM nakit_avans na
            JOIN kartlar k ON na.kart_id = k.kart_id
            JOIN hesaplar h ON k.hesap_id = h.hesap_id
            JOIN musteriler m ON h.musteri_id = m.musteri_id
            WHERE k.kart_numarasi = ?
        """;
        return jdbcTemplate.queryForList(sql, kartNumarasi);
    }

    public void updateNakitAvans(NakitAvans avans) {
        String sql = "UPDATE nakit_avans SET avans_tutari = ?, avans_tarihi = ?, odenen_tutar = ? WHERE avans_id = ?";
        jdbcTemplate.update(sql,
                avans.getAvansTutari(),
                avans.getAvansTarihi(),
                avans.getOdenenTutar(),
                avans.getAvansId());
    }


    public void deleteNakitAvans(Long avansId) {
        String sql = "DELETE FROM nakit_avans WHERE avans_id = ?";
        jdbcTemplate.update(sql, avansId);
    }


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
