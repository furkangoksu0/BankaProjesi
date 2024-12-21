package com.example.banka.Service;

import com.example.banka.DAO.YatirimHesaplariDAO;
import com.example.banka.Entity.YatirimHesaplari;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YatirimHesaplariService {

    private final YatirimHesaplariDAO yatirimHesaplariDAO;

    public YatirimHesaplariService(YatirimHesaplariDAO yatirimHesaplariDAO) {
        this.yatirimHesaplariDAO = yatirimHesaplariDAO;
    }

    public void addYatirimHesabi(YatirimHesaplari yatirimHesabi) {
        yatirimHesaplariDAO.addYatirimHesabi(yatirimHesabi);
    }

    public List<YatirimHesaplari> getAllYatirimHesaplari() {
        return yatirimHesaplariDAO.getAllYatirimHesaplari();
    }

    public YatirimHesaplari getYatirimHesabiById(Long yatirimId) {
        return yatirimHesaplariDAO.getYatirimHesabiById(yatirimId);
    }

    public void updateYatirimHesabi(YatirimHesaplari yatirimHesabi) {
        yatirimHesaplariDAO.updateYatirimHesabi(yatirimHesabi);
    }

    public void deleteYatirimHesabi(Long yatirimId) {
        yatirimHesaplariDAO.deleteYatirimHesabi(yatirimId);
    }
}
