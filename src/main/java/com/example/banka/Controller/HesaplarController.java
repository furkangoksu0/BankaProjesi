package com.example.banka.Controller;

import com.example.banka.Entity.Hesaplar;
import com.example.banka.Service.HesaplarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hesaplar")
public class HesaplarController {

    private final HesaplarService hesaplarService;

    public HesaplarController(HesaplarService hesaplarService) {
        this.hesaplarService = hesaplarService;
    }

    @PostMapping
    public void addHesap(@RequestBody Hesaplar hesap) {
        hesaplarService.addHesap(hesap);
    }

    @GetMapping
    public List<Hesaplar> getAllHesaplar() {
        return hesaplarService.getAllHesaplar();
    }

    @GetMapping("/musteriler/{musteriId}")
    public List<Map<String, Object>> getHesaplarByMusteriId(@PathVariable Long musteriId) {
        return hesaplarService.getHesaplarByMusteriId(musteriId);
    }

    @GetMapping("/{hesapId}/kartlar")
    public List<Map<String, Object>> getHesapKartlari(@PathVariable Long hesapId) {
        return hesaplarService.getHesapKartlari(hesapId);
    }

    @GetMapping("/{hesapId}/islemler")
    public List<Map<String, Object>> getHesapIslemleri(@PathVariable Long hesapId) {
        return hesaplarService.getHesapIslemleri(hesapId);
    }

    @GetMapping("/{id}")
    public Hesaplar getHesapById(@PathVariable("id") Long hesapId) {
        return hesaplarService.getHesapById(hesapId);
    }

    @DeleteMapping("/{id}")
    public void deleteHesap(@PathVariable("id") Long hesapId) {
        hesaplarService.deleteHesap(hesapId);
    }
}
