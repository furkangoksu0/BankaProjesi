package com.example.banka.Controller;

import com.example.banka.Entity.Kartlar;
import com.example.banka.Service.KartlarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kartlar")
public class KartlarController {

    private final KartlarService kartlarService;

    public KartlarController(KartlarService kartlarService) {
        this.kartlarService = kartlarService;
    }

    @PostMapping
    public void addKart(@RequestBody Kartlar kart) {
        kartlarService.addKart(kart);
    }

    @GetMapping
    public List<Kartlar> getAllKartlar() {
        return kartlarService.getAllKartlar();
    }

    @GetMapping("/hesaplar/{hesapId}")
    public List<Map<String, Object>> getKartlarByHesapId(@PathVariable Long hesapId) {
        return kartlarService.getKartlarByHesapId(hesapId);
    }

    @GetMapping("/{id}")
    public Kartlar getKartById(@PathVariable("id") Long kartId) {
        return kartlarService.getKartById(kartId);
    }

    @DeleteMapping("/{id}")
    public void deleteKart(@PathVariable("id") Long kartId) {
        kartlarService.deleteKart(kartId);
    }
}
