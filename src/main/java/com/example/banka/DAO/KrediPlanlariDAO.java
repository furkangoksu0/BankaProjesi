package com.example.banka.DAO;

import com.example.banka.Entity.KrediPlanlari;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KrediPlanlariDAO {

    private final JdbcTemplate jdbcTemplate;

    public KrediPlanlariDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Plan Ekleme
    public void addPlan(KrediPlanlari plan) {
        String sql = "INSERT INTO kredi_planlari (kredi_id, odeme_tarihi, odenen_tutar, kalan_borc) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                plan.getKrediId(),
                plan.getOdemeTarihi(),
                plan.getOdenenTutar(),
                plan.getKalanBorc());
    }

    // Tüm Planları Getirme
    public List<KrediPlanlari> getAllPlans() {
        String sql = "SELECT * FROM kredi_planlari";
        return jdbcTemplate.query(sql, new KrediPlanlariRowMapper());
    }

    // Plan Bulma (ID ile)
    public KrediPlanlari getPlanById(Long planId) {
        String sql = "SELECT * FROM kredi_planlari WHERE plan_id = ?";
        return jdbcTemplate.queryForObject(sql, new KrediPlanlariRowMapper(), planId);
    }

    // Plan Silme
    public void deletePlan(Long planId) {
        String sql = "DELETE FROM kredi_planlari WHERE plan_id = ?";
        jdbcTemplate.update(sql, planId);
    }

    // RowMapper Sınıfı
    private static class KrediPlanlariRowMapper implements RowMapper<KrediPlanlari> {
        @Override
        public KrediPlanlari mapRow(ResultSet rs, int rowNum) throws SQLException {
            KrediPlanlari plan = new KrediPlanlari();
            plan.setPlanId(rs.getLong("plan_id"));
            plan.setKrediId(rs.getLong("kredi_id"));
            plan.setOdemeTarihi(rs.getTimestamp("odeme_tarihi").toLocalDateTime());
            plan.setOdenenTutar(rs.getDouble("odenen_tutar"));
            plan.setKalanBorc(rs.getDouble("kalan_borc"));
            return plan;
        }
    }
}
