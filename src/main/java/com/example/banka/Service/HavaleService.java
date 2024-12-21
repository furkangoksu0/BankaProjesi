package com.example.banka.Service;

import com.example.banka.DAO.HavaleDAO;
import com.example.banka.Entity.Havale;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HavaleService {

    private final HavaleDAO havaleDAO;

    public HavaleService(HavaleDAO havaleDAO) {
        this.havaleDAO = havaleDAO;
    }

    public void addHavale(Havale havale) {
        havaleDAO.addHavale(havale);
    }

    public List<Havale> getAllHavale() {
        return havaleDAO.getAllHavale();
    }

    public List<Map<String, Object>> getAllHavaleByMusteri() {
        return havaleDAO.getAllHavaleByMusteri();
    }

    public List<Map<String, Object>> getHavaleByMusteriId(Long musteriId) {
        return havaleDAO.getHavaleByMusteriId(musteriId);
    }

    public List<Map<String, Object>> getHavaleByHesapId(Long hesapId) {
        return havaleDAO.getHavaleByHesapId(hesapId);
    }

    public Havale getHavaleById(Long havaleId) {
        return havaleDAO.getHavaleById(havaleId);
    }

    public void updateHavale(Havale havale) {
        havaleDAO.updateHavale(havale);
    }

    public void deleteHavale(Long havaleId) {
        havaleDAO.deleteHavale(havaleId);
    }
}
