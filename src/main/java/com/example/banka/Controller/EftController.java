package com.example.banka.Controller;

import com.example.banka.Entity.Eft;
import com.example.banka.Service.EftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eft")
public class EftController {

    private final EftService eftService;

    public EftController(EftService eftService) {
        this.eftService = eftService;
    }

    @PostMapping
    public void addEft(@RequestBody Eft eft) {
        eftService.addEft(eft);
    }

    @GetMapping
    public List<Eft> getAllEft() {
        return eftService.getAllEft();
    }

    @GetMapping("/{id}")
    public Eft getEftById(@PathVariable("id") Long eftId) {
        return eftService.getEftById(eftId);
    }
    @GetMapping("/by-musteri")
    public List<Map<String, Object>> getAllEftByMusteri() {
        return eftService.getAllEftByMusteri();
    }


    @GetMapping("/musteri/{musteriId}")
    public List<Map<String, Object>> getEftByMusteriId(@PathVariable Long musteriId) {
        return eftService.getEftByMusteriId(musteriId);
    }


    @GetMapping("/hesap/{hesapId}")
    public List<Map<String, Object>> getEftByHesapId(@PathVariable Long hesapId) {
        return eftService.getEftByHesapId(hesapId);
    }

    @PutMapping
    public void updateEft(@RequestBody Eft eft) {
        eftService.updateEft(eft);
    }

    @DeleteMapping("/{id}")
    public void deleteEft(@PathVariable("id") Long eftId) {
        eftService.deleteEft(eftId);
    }
}
