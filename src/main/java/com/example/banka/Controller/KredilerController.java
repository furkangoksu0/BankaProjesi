package com.example.banka.Controller;

import com.example.banka.Entity.Krediler;
import com.example.banka.Service.KredilerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/krediler")
public class KredilerController {

    private final KredilerService kredilerService;

    public KredilerController(KredilerService kredilerService) {
        this.kredilerService = kredilerService;
    }

    @PostMapping
    public void addKredi(@RequestBody Krediler kredi) {
        kredilerService.addKredi(kredi);
    }

    @GetMapping
    public List<Krediler> getAllKrediler() {
        return kredilerService.getAllKrediler();
    }

    @GetMapping("/musteriler/{musteriId}")
    public List<Map<String, Object>> getKredilerByMusteriId(@PathVariable Long musteriId) {
        return kredilerService.getKredilerByMusteriId(musteriId);
    }

    @GetMapping("/{id}")
    public Krediler getKrediById(@PathVariable("id") Long krediId) {
        return kredilerService.getKrediById(krediId);
    }

    @DeleteMapping("/{id}")
    public void deleteKredi(@PathVariable("id") Long krediId) {
        kredilerService.deleteKredi(krediId);
    }
}
