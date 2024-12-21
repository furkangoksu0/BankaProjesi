package com.example.banka.Service;

import com.example.banka.DAO.EftDAO;
import com.example.banka.Entity.Eft;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EftService {

    private final EftDAO eftDAO;

    public EftService(EftDAO eftDAO) {
        this.eftDAO = eftDAO;
    }

    public void addEft(Eft eft) {
        eftDAO.addEft(eft);
    }

    public List<Eft> getAllEft() {
        return eftDAO.getAllEft();
    }
    
    public List<Map<String, Object>> getAllEftByMusteri() {
        return eftDAO.getAllEftByMusteri();
    }

    public List<Map<String, Object>> getEftByMusteriId(Long musteriId) {
        return eftDAO.getEftByMusteriId(musteriId);
    }

    public List<Map<String, Object>> getEftByHesapId(Long hesapId) {
        return eftDAO.getEftByHesapId(hesapId);
    }

    public Eft getEftById(Long eftId) {
        return eftDAO.getEftById(eftId);
    }

    public void updateEft(Eft eft) {
        eftDAO.updateEft(eft);
    }

    public void deleteEft(Long eftId) {
        eftDAO.deleteEft(eftId);
    }
}
