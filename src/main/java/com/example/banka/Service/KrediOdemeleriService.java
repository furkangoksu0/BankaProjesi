package com.example.banka.Service;

import com.example.banka.DAO.KrediOdemeleriDAO;
import com.example.banka.Entity.KrediOdemeleri;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KrediOdemeleriService {

    private final KrediOdemeleriDAO krediOdemeleriDAO;

    public KrediOdemeleriService(KrediOdemeleriDAO krediOdemeleriDAO) {
        this.krediOdemeleriDAO = krediOdemeleriDAO;
    }

    public void addOdeme(KrediOdemeleri odeme) {
        krediOdemeleriDAO.addOdeme(odeme);
    }

    public List<KrediOdemeleri> getAllOdemeler() {
        return krediOdemeleriDAO.getAllOdemeler();
    }

    public KrediOdemeleri getOdemeById(Long odemeId) {
        return krediOdemeleriDAO.getOdemeById(odemeId);
    }

    public void deleteOdeme(Long odemeId) {
        krediOdemeleriDAO.deleteOdeme(odemeId);
    }
}
