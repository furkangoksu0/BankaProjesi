package com.example.banka.Controller;

import com.example.banka.Entity.Islemler;
import com.example.banka.Service.IslemlerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/islemler")
public class IslemlerController {

    private final IslemlerService islemlerService;

    public IslemlerController(IslemlerService islemlerService) {
        this.islemlerService = islemlerService;
    }

    @PostMapping
    public void addIslem(@RequestBody Islemler islem) {
        islemlerService.addIslem(islem);
    }

    @GetMapping
    public List<Islemler> getAllIslemler() {
        return islemlerService.getAllIslemler();
    }

    @GetMapping("/by-musteri")
    public List<Map<String, Object>> getAllIslemlerByMusteri() {
        return islemlerService.getAllIslemlerByMusteri();
    }

    @GetMapping("/musteri/{musteriId}")
    public List<Map<String, Object>> getIslemlerByMusteriId(@PathVariable Long musteriId) {
        return islemlerService.getIslemlerByMusteriId(musteriId);
    }

    @GetMapping("/hesap/{hesapId}")
    public List<Map<String, Object>> getIslemlerByHesapId(@PathVariable Long hesapId) {
        return islemlerService.getIslemlerByHesapId(hesapId);
    }

    @GetMapping("/sube/{subeId}")
    public List<Map<String, Object>> getIslemlerBySubeId(@PathVariable Long subeId) {
        return islemlerService.getIslemlerBySubeId(subeId);
    }

    @GetMapping("/{id}")
    public Islemler getIslemById(@PathVariable("id") Long islemId) {
        return islemlerService.getIslemById(islemId);
    }

    @PutMapping
    public void updateIslem(@RequestBody Islemler islem) {
        islemlerService.updateIslem(islem);
    }

    @DeleteMapping("/{id}")
    public void deleteIslem(@PathVariable("id") Long islemId) {
        islemlerService.deleteIslem(islemId);
    }
}
