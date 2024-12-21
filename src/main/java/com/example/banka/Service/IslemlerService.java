package com.example.banka.Service;

import com.example.banka.DAO.IslemlerDAO;
import com.example.banka.Entity.Islemler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IslemlerService {

    private final IslemlerDAO islemlerDAO;

    public IslemlerService(IslemlerDAO islemlerDAO) {
        this.islemlerDAO = islemlerDAO;
    }

    public void addIslem(Islemler islem) {
        islemlerDAO.addIslem(islem);
    }

    public List<Islemler> getAllIslemler() {
        return islemlerDAO.getAllIslemler();
    }

    public List<Map<String, Object>> getAllIslemlerByMusteri() {
        return islemlerDAO.getAllIslemlerByMusteri();
    }

    public List<Map<String, Object>> getIslemlerByMusteriId(Long musteriId) {
        return islemlerDAO.getIslemlerByMusteriId(musteriId);
    }

    public List<Map<String, Object>> getIslemlerByHesapId(Long hesapId) {
        return islemlerDAO.getIslemlerByHesapId(hesapId);
    }

    public List<Map<String, Object>> getIslemlerBySubeId(Long subeId) {
        return islemlerDAO.getIslemlerBySubeId(subeId);
    }

    public Islemler getIslemById(Long islemId) {
        return islemlerDAO.getIslemById(islemId);
    }

    public void updateIslem(Islemler islem) {
        islemlerDAO.updateIslem(islem);
    }

    public void deleteIslem(Long islemId) {
        islemlerDAO.deleteIslem(islemId);
    }
}
