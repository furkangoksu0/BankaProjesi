package com.example.banka.Service;

import com.example.banka.DAO.TaleplerDAO;
import com.example.banka.Entity.Talepler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TaleplerService {

    private final TaleplerDAO taleplerDAO;

    public TaleplerService(TaleplerDAO taleplerDAO) {
        this.taleplerDAO = taleplerDAO;
    }

    public void addTalep(Talepler talep) {
        taleplerDAO.addTalep(talep);
    }

    public List<Talepler> getAllTalepler() {
        return taleplerDAO.getAllTalepler();
    }

    public List<Map<String, Object>> getAllTaleplerByMusteri() {
        return taleplerDAO.getAllTaleplerByMusteri();
    }

    public List<Map<String, Object>> getTaleplerByMusteriId(Long musteriId) {
        return taleplerDAO.getTaleplerByMusteriId(musteriId);
    }


    public Talepler getTalepById(Long talepId) {
        return taleplerDAO.getTalepById(talepId);
    }

    public void updateTalep(Talepler talep) {
        taleplerDAO.updateTalep(talep);
    }

    public void deleteTalep(Long talepId) {
        taleplerDAO.deleteTalep(talepId);
    }
}
