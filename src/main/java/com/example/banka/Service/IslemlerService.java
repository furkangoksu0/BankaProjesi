package com.example.banka.Service;

import com.example.banka.DAO.IslemlerDAO;
import com.example.banka.Entity.Islemler;
import org.springframework.stereotype.Service;

import java.util.List;

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
