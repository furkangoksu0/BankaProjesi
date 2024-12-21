package com.example.banka.DAO;

import com.example.banka.Entity.Musteriler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MusterilerDAO {
    private final JdbcTemplate jdbcTemplate;

    public MusterilerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addMusteri(Musteriler musteri) {
        String sql = "INSERT INTO musteriler (ad, soyad, telefon, email, adres) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, musteri.getAd(), musteri.getSoyad(), musteri.getTelefon(), musteri.getEmail(), musteri.getAdres());
    }


    public List<Musteriler> getAllMusteriler() {
        String sql = "SELECT * FROM musteriler";
        return jdbcTemplate.query(sql, new MusteriRowMapper());
    }


    public Musteriler getMusteriById(Long id) {
        String sql = "SELECT * FROM musteriler WHERE musteri_id = ?";
        return jdbcTemplate.queryForObject(sql, new MusteriRowMapper(), id);
    }


    public void updateMusteri(Musteriler musteri) {
        String sql = "UPDATE musteriler SET ad = ?, soyad = ?, telefon = ?, email = ?, adres = ? WHERE musteri_id = ?";
        jdbcTemplate.update(sql, musteri.getAd(), musteri.getSoyad(), musteri.getTelefon(), musteri.getEmail(), musteri.getAdres(), musteri.getMusteriId());
    }


    public void deleteMusteri(Long id) {
        String sql = "DELETE FROM musteriler WHERE musteri_id = ?";
        jdbcTemplate.update(sql, id);
    }


    private static class MusteriRowMapper implements RowMapper<Musteriler> {
        @Override
        public Musteriler mapRow(ResultSet rs, int rowNum) throws SQLException {
            Musteriler musteri = new Musteriler();
            musteri.setMusteriId(rs.getLong("musteri_id"));
            musteri.setAd(rs.getString("ad"));
            musteri.setSoyad(rs.getString("soyad"));
            musteri.setTelefon(rs.getString("telefon"));
            musteri.setEmail(rs.getString("email"));
            musteri.setAdres(rs.getString("adres"));
            return musteri;
        }
    }
}

