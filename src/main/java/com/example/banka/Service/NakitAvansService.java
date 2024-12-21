package com.example.banka.Service;

import com.example.banka.DAO.NakitAvansDAO;
import com.example.banka.Entity.NakitAvans;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NakitAvansService {

    private final NakitAvansDAO nakitAvansDAO;

    public NakitAvansService(NakitAvansDAO nakitAvansDAO) {
        this.nakitAvansDAO = nakitAvansDAO;
    }

    public void addNakitAvans(NakitAvans avans) {
        nakitAvansDAO.addNakitAvans(avans);
    }

    public List<NakitAvans> getAllNakitAvans() {
        return nakitAvansDAO.getAllNakitAvans();
    }

    public NakitAvans getNakitAvansById(Long avansId) {
        return nakitAvansDAO.getNakitAvansById(avansId);
    }

    public void updateNakitAvans(NakitAvans avans) {
        nakitAvansDAO.updateNakitAvans(avans);
    }

    public void deleteNakitAvans(Long avansId) {
        nakitAvansDAO.deleteNakitAvans(avansId);
    }
}
