package com.example.banka.Service;

import com.example.banka.DAO.KrediPlanlariDAO;
import com.example.banka.Entity.KrediPlanlari;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KrediPlanlariService {

    private final KrediPlanlariDAO krediPlanlariDAO;

    public KrediPlanlariService(KrediPlanlariDAO krediPlanlariDAO) {
        this.krediPlanlariDAO = krediPlanlariDAO;
    }

    public void addPlan(KrediPlanlari plan) {
        krediPlanlariDAO.addPlan(plan);
    }

    public List<KrediPlanlari> getAllPlans() {
        return krediPlanlariDAO.getAllPlans();
    }

    public KrediPlanlari getPlanById(Long planId) {
        return krediPlanlariDAO.getPlanById(planId);
    }

    public void deletePlan(Long planId) {
        krediPlanlariDAO.deletePlan(planId);
    }
}
