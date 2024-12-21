package com.example.banka.Service;

import com.example.banka.DAO.HavaleDAO;
import com.example.banka.Entity.Havale;
import org.springframework.stereotype.Service;

import java.util.List;

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
