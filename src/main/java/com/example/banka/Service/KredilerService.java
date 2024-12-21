package com.example.banka.Service;

import com.example.banka.DAO.KredilerDAO;
import com.example.banka.Entity.Krediler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KredilerService {

    private final KredilerDAO kredilerDAO;

    public KredilerService(KredilerDAO kredilerDAO) {
        this.kredilerDAO = kredilerDAO;
    }

    public void addKredi(Krediler kredi) {
        kredilerDAO.addKredi(kredi);
    }

    public List<Krediler> getAllKrediler() {
        return kredilerDAO.getAllKrediler();
    }

    public List<Map<String, Object>> getKredilerByMusteriId(Long musteriId) {
        return kredilerDAO.getKredilerByMusteriId(musteriId);
    }

    public Krediler getKrediById(Long krediId) {
        return kredilerDAO.getKrediById(krediId);
    }

    public void deleteKredi(Long krediId) {
        kredilerDAO.deleteKredi(krediId);
    }
}
