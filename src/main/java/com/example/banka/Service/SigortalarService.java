package com.example.banka.Service;

import com.example.banka.DAO.SigortalarDAO;
import com.example.banka.Entity.Sigortalar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SigortalarService {

    private final SigortalarDAO sigortalarDAO;

    public SigortalarService(SigortalarDAO sigortalarDAO) {
        this.sigortalarDAO = sigortalarDAO;
    }

    public void addSigorta(Sigortalar sigorta) {
        sigortalarDAO.addSigorta(sigorta);
    }

    public List<Sigortalar> getAllSigortalar() {
        return sigortalarDAO.getAllSigortalar();
    }

    public Sigortalar getSigortaById(Long sigortaId) {
        return sigortalarDAO.getSigortaById(sigortaId);
    }

    public void updateSigorta(Sigortalar sigorta) {
        sigortalarDAO.updateSigorta(sigorta);
    }

    public void deleteSigorta(Long sigortaId) {
        sigortalarDAO.deleteSigorta(sigortaId);
    }
}
