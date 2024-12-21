package com.example.banka.Service;

import com.example.banka.DAO.MusterilerDAO;
import com.example.banka.Entity.Musteriler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusterilerService {
    private final MusterilerDAO musteriDAO;

    public MusterilerService(MusterilerDAO musteriDAO) {
        this.musteriDAO = musteriDAO;
    }

    public void addMusteri(Musteriler musteri) {
        musteriDAO.addMusteri(musteri);
    }

    public List<Musteriler> getAllMusteriler() {
        return musteriDAO.getAllMusteriler();
    }

    public Musteriler getMusteriById(Long id) {
        return musteriDAO.getMusteriById(id);
    }

    public void updateMusteri(Musteriler musteri) {
        musteriDAO.updateMusteri(musteri);
    }

    public void deleteMusteri(Long id) {
        musteriDAO.deleteMusteri(id);
    }
}

