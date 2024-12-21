package com.example.banka.DAO;

import com.example.banka.Entity.Kartlar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class KartlarDAO {

    private final JdbcTemplate jdbcTemplate;

    public KartlarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addKart(Kartlar kart) {
        String sql = "INSERT INTO kartlar (kart_numarasi, kart_turu, hesap_id, vade_tarihi, kart_limit) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                kart.getKartNumarasi(),
                kart.getKartTuru(),
                kart.getHesapId(),
                kart.getVadeTarihi(),
                kart.getKartLimit());
    }


    public List<Kartlar> getAllKartlar() {
        String sql = "SELECT * FROM kartlar";
        return jdbcTemplate.query(sql, new KartlarRowMapper());
    }

    public List<Map<String, Object>> getKartlarByHesapId(Long hesapId) {
        String sql = """
            SELECT 
                k.kart_id, 
                k.kart_numarasi, 
                k.kart_turu, 
                k.kart_limit, 
                h.hesap_adi, 
                m.ad AS musteri_adi, 
                m.soyad AS musteri_soyadi
            FROM kartlar k
            JOIN hesaplar h ON k.hesap_id = h.hesap_id
            JOIN musteriler m ON h.musteri_id = m.musteri_id
            WHERE h.hesap_id = ?
        """;
        return jdbcTemplate.queryForList(sql, hesapId);
    }

    public Kartlar getKartById(Long kartId) {
        String sql = "SELECT * FROM kartlar WHERE kart_id = ?";
        return jdbcTemplate.queryForObject(sql, new KartlarRowMapper(), kartId);
    }


    public void deleteKart(Long kartId) {
        String sql = "DELETE FROM kartlar WHERE kart_id = ?";
        jdbcTemplate.update(sql, kartId);
    }


    private static class KartlarRowMapper implements RowMapper<Kartlar> {
        @Override
        public Kartlar mapRow(ResultSet rs, int rowNum) throws SQLException {
            Kartlar kart = new Kartlar();
            kart.setKartId(rs.getLong("kart_id"));
            kart.setKartNumarasi(rs.getString("kart_numarasi"));
            kart.setKartTuru(rs.getString("kart_turu"));
            kart.setHesapId(rs.getLong("hesap_id"));
            kart.setVadeTarihi(rs.getTimestamp("vade_tarihi").toLocalDateTime());
            kart.setKartLimit(rs.getDouble("kart_limit"));
            return kart;
        }
    }
}
