package com.example.banka.DAO;

import com.example.banka.Entity.Subeler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class SubelerDAO {

    private final JdbcTemplate jdbcTemplate;

    public SubelerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addSube(Subeler sube) {
        String sql = "INSERT INTO subeler (adres, telefon, sube_kodu, sube_adi) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                sube.getAdres(),
                sube.getTelefon(),
                sube.getSubeKodu(),
                sube.getSubeAdi());
    }


    public List<Subeler> getAllSubeler() {
        String sql = "SELECT * FROM subeler";
        return jdbcTemplate.query(sql, new SubelerRowMapper());
    }


    public Subeler getSubeById(Long subeId) {
        String sql = "SELECT * FROM subeler WHERE sube_id = ?";
        return jdbcTemplate.queryForObject(sql, new SubelerRowMapper(), subeId);
    }
    public List<Map<String, Object>> getSubeIslemleri(Long subeId) {
        String sql = """
            SELECT 
                i.islem_id, 
                i.islem_turu, 
                i.tutar, 
                i.islem_tarihi, 
                i.aciklama, 
                s.sube_adi, 
                h.hesap_adi, 
                m.ad AS musteri_adi, 
                m.soyad AS musteri_soyadi
            FROM islemler i
            JOIN subeler s ON i.sube_id = s.sube_id
            JOIN hesaplar h ON i.hesap_id = h.hesap_id
            JOIN musteriler m ON h.musteri_id = m.musteri_id
            WHERE s.sube_id = ?
        """;
        return jdbcTemplate.queryForList(sql, subeId);
    }


    public void updateSube(Subeler sube) {
        String sql = "UPDATE subeler SET adres = ?, telefon = ?, sube_kodu = ?, sube_adi = ? WHERE sube_id = ?";
        jdbcTemplate.update(sql,
                sube.getAdres(),
                sube.getTelefon(),
                sube.getSubeKodu(),
                sube.getSubeAdi(),
                sube.getSubeId());
    }


    public void deleteSube(Long subeId) {
        String sql = "DELETE FROM subeler WHERE sube_id = ?";
        jdbcTemplate.update(sql, subeId);
    }


    private static class SubelerRowMapper implements RowMapper<Subeler> {
        @Override
        public Subeler mapRow(ResultSet rs, int rowNum) throws SQLException {
            Subeler sube = new Subeler();
            sube.setSubeId(rs.getLong("sube_id"));
            sube.setAdres(rs.getString("adres"));
            sube.setTelefon(rs.getString("telefon"));
            sube.setSubeKodu(rs.getString("sube_kodu"));
            sube.setSubeAdi(rs.getString("sube_adi"));
            return sube;
        }
    }
}
