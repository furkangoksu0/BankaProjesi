package com.example.banka.Controller;

import com.example.banka.Entity.Havale;
import com.example.banka.Service.HavaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/havale")
public class HavaleController {

    private final HavaleService havaleService;

    public HavaleController(HavaleService havaleService) {
        this.havaleService = havaleService;
    }

    @PostMapping
    public void addHavale(@RequestBody Havale havale) {
        havaleService.addHavale(havale);
    }

    @GetMapping
    public List<Havale> getAllHavale() {
        return havaleService.getAllHavale();
    }

    @GetMapping("/by-musteri")
    public List<Map<String, Object>> getAllHavaleByMusteri() {
        return havaleService.getAllHavaleByMusteri();
    }


    @GetMapping("/musteri/{musteriId}")
    public List<Map<String, Object>> getHavaleByMusteriId(@PathVariable Long musteriId) {
        return havaleService.getHavaleByMusteriId(musteriId);
    }


    @GetMapping("/hesap/{hesapId}")
    public List<Map<String, Object>> getHavaleByHesapId(@PathVariable Long hesapId) {
        return havaleService.getHavaleByHesapId(hesapId);
    }

    @GetMapping("/{id}")
    public Havale getHavaleById(@PathVariable("id") Long havaleId) {
        return havaleService.getHavaleById(havaleId);
    }

    @PutMapping
    public void updateHavale(@RequestBody Havale havale) {
        havaleService.updateHavale(havale);
    }

    @DeleteMapping("/{id}")
    public void deleteHavale(@PathVariable("id") Long havaleId) {
        havaleService.deleteHavale(havaleId);
    }
}
