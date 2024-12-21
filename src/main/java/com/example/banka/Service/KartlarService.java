package com.example.banka.Service;

import com.example.banka.DAO.KartlarDAO;
import com.example.banka.Entity.Kartlar;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KartlarService {

    private final KartlarDAO kartlarDAO;

    public KartlarService(KartlarDAO kartlarDAO) {
        this.kartlarDAO = kartlarDAO;
    }

    public void addKart(Kartlar kart) {
        kartlarDAO.addKart(kart);
    }

    public List<Kartlar> getAllKartlar() {
        return kartlarDAO.getAllKartlar();
    }

    public List<Map<String, Object>> getKartlarByHesapId(Long hesapId) {
        return kartlarDAO.getKartlarByHesapId(hesapId);
    }

    public Kartlar getKartById(Long kartId) {
        return kartlarDAO.getKartById(kartId);
    }

    public void deleteKart(Long kartId) {
        kartlarDAO.deleteKart(kartId);
    }
}
