package com.example.banka.DAO;

import com.example.banka.Entity.Krediler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class KredilerDAO {

    private final JdbcTemplate jdbcTemplate;

    public KredilerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addKredi(Krediler kredi) {
        String sql = "INSERT INTO krediler (kalan_borc, alinan_borc, odenen_miktar, vade, musteri_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                kredi.getKalanBorc(),
                kredi.getAlinanBorc(),
                kredi.getOdenenMiktar(),
                kredi.getVade(),
                kredi.getMusteriId());
    }


    public List<Krediler> getAllKrediler() {
        String sql = "SELECT * FROM krediler";
        return jdbcTemplate.query(sql, new KredilerRowMapper());
    }
    public List<Map<String, Object>> getKredilerByMusteriId(Long musteriId) {
        String sql = """
            SELECT 
                k.kredi_id, 
                k.kredi_turu, 
                k.alinan_borc, 
                k.kalan_borc, 
                m.ad AS musteri_adi, 
                m.soyad AS musteri_soyadi
            FROM krediler k
            JOIN musteriler m ON k.musteri_id = m.musteri_id
            WHERE m.musteri_id = ?
        """;
        return jdbcTemplate.queryForList(sql, musteriId);
    }


    public Krediler getKrediById(Long krediId) {
        String sql = "SELECT * FROM krediler WHERE kredi_id = ?";
        return jdbcTemplate.queryForObject(sql, new KredilerRowMapper(), krediId);
    }


    public void deleteKredi(Long krediId) {
        String sql = "DELETE FROM krediler WHERE kredi_id = ?";
        jdbcTemplate.update(sql, krediId);
    }


    private static class KredilerRowMapper implements RowMapper<Krediler> {
        @Override
        public Krediler mapRow(ResultSet rs, int rowNum) throws SQLException {
            Krediler kredi = new Krediler();
            kredi.setKrediId(rs.getLong("kredi_id"));
            kredi.setKalanBorc(rs.getDouble("kalan_borc"));
            kredi.setAlinanBorc(rs.getDouble("alinan_borc"));
            kredi.setOdenenMiktar(rs.getDouble("odenen_miktar"));
            kredi.setVade(rs.getInt("vade"));
            kredi.setMusteriId(rs.getLong("musteri_id"));
            return kredi;
        }
    }
}
