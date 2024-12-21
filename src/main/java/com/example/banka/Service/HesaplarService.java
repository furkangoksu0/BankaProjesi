package com.example.banka.Service;

import com.example.banka.DAO.HesaplarDAO;
import com.example.banka.Entity.Hesaplar;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HesaplarService {

    private final HesaplarDAO hesaplarDAO;

    public HesaplarService(HesaplarDAO hesaplarDAO) {
        this.hesaplarDAO = hesaplarDAO;
    }

    public void addHesap(Hesaplar hesap) {
        hesaplarDAO.addHesap(hesap);
    }

    public List<Hesaplar> getAllHesaplar() {
        return hesaplarDAO.getAllHesaplar();
    }

    public List<Map<String, Object>> getHesaplarByMusteriId(Long musteriId) {
        return hesaplarDAO.getHesaplarByMusteriId(musteriId);
    }

    public List<Map<String, Object>> getHesapKartlari(Long hesapId) {
        return hesaplarDAO.getHesapKartlari(hesapId);
    }

    public List<Map<String, Object>> getHesapIslemleri(Long hesapId) {
        return hesaplarDAO.getHesapIslemleri(hesapId);
    }

    public Hesaplar getHesapById(Long hesapId) {
        return hesaplarDAO.getHesapById(hesapId);
    }

    public void deleteHesap(Long hesapId) {
        hesaplarDAO.deleteHesap(hesapId);
    }
}

