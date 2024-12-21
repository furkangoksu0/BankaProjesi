package com.example.banka.Service;

import com.example.banka.DAO.CeklerDAO;
import com.example.banka.Entity.Cekler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CeklerService {

    private final CeklerDAO ceklerDAO;

    public CeklerService(CeklerDAO ceklerDAO) {
        this.ceklerDAO = ceklerDAO;
    }

    public void addCek(Cekler cek) {
        ceklerDAO.addCek(cek);
    }

    public List<Cekler> getAllCekler() {
        return ceklerDAO.getAllCekler();
    }

    public Cekler getCekById(Long cekId) {
        return ceklerDAO.getCekById(cekId);
    }

    public void updateCek(Cekler cek) {
        ceklerDAO.updateCek(cek);
    }

    public void deleteCek(Long cekId) {
        ceklerDAO.deleteCek(cekId);
    }
}
