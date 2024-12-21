package com.example.banka.Service;

import com.example.banka.DAO.EftDAO;
import com.example.banka.Entity.Eft;
import org.springframework.stereotype.Service;

import java.util.List;

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
