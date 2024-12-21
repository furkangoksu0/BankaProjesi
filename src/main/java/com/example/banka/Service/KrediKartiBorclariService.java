package com.example.banka.Service;

import com.example.banka.DAO.KrediKartiBorclariDAO;
import com.example.banka.Entity.KrediKartiBorclari;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KrediKartiBorclariService {

    private final KrediKartiBorclariDAO krediKartiBorclariDAO;

    public KrediKartiBorclariService(KrediKartiBorclariDAO krediKartiBorclariDAO) {
        this.krediKartiBorclariDAO = krediKartiBorclariDAO;
    }

    public void addBorc(KrediKartiBorclari borc) {
        krediKartiBorclariDAO.addBorc(borc);
    }

    public List<KrediKartiBorclari> getAllBorclar() {
        return krediKartiBorclariDAO.getAllBorclar();
    }

    public List<Map<String, Object>> getAllMusteriKartBorclari() {
        return krediKartiBorclariDAO.getAllMusteriKartBorclari();
    }

    public List<Map<String, Object>> getKartBorclariByMusteriId(Long musteriId) {
        return krediKartiBorclariDAO.getKartBorclariByMusteriId(musteriId);
    }

    public KrediKartiBorclari getBorcById(Long borcId) {
        return krediKartiBorclariDAO.getBorcById(borcId);
    }

    public void updateBorc(KrediKartiBorclari borc) {
        krediKartiBorclariDAO.updateBorc(borc);
    }

    public void deleteBorc(Long borcId) {
        krediKartiBorclariDAO.deleteBorc(borcId);
    }
}
