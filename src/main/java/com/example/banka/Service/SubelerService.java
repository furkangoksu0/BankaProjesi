package com.example.banka.Service;

import com.example.banka.DAO.SubelerDAO;
import com.example.banka.Entity.Subeler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SubelerService {

    private final SubelerDAO subelerDAO;

    public SubelerService(SubelerDAO subelerDAO) {
        this.subelerDAO = subelerDAO;
    }

    public void addSube(Subeler sube) {
        subelerDAO.addSube(sube);
    }

    public List<Subeler> getAllSubeler() {
        return subelerDAO.getAllSubeler();
    }

    public List<Map<String, Object>> getSubeIslemleri(Long subeId) {
        return subelerDAO.getSubeIslemleri(subeId);
    }

    public Subeler getSubeById(Long subeId) {
        return subelerDAO.getSubeById(subeId);
    }

    public void updateSube(Subeler sube) {
        subelerDAO.updateSube(sube);
    }

    public void deleteSube(Long subeId) {
        subelerDAO.deleteSube(subeId);
    }
}
