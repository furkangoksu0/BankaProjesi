package com.example.banka.Controller;

import com.example.banka.Entity.NakitAvans;
import com.example.banka.Service.NakitAvansService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/nakitAvans")
public class NakitAvansController {

    private final NakitAvansService nakitAvansService;

    public NakitAvansController(NakitAvansService nakitAvansService) {
        this.nakitAvansService = nakitAvansService;
    }

    @PostMapping
    public void addNakitAvans(@RequestBody NakitAvans avans) {
        nakitAvansService.addNakitAvans(avans);
    }

    @GetMapping
    public List<NakitAvans> getAllNakitAvans() {
        return nakitAvansService.getAllNakitAvans();
    }

    @GetMapping("/{id}")
    public NakitAvans getNakitAvansById(@PathVariable("id") Long avansId) {
        return nakitAvansService.getNakitAvansById(avansId);
    }
    @GetMapping("/by-musteri")
    public List<Map<String, Object>> getAllNakitAvansbyMusteri() {
        return nakitAvansService.getAllNakitAvansbyMusteri();
    }


    @GetMapping("/musteri/{musteriId}")
    public List<Map<String, Object>> getNakitAvansByMusteriId(@PathVariable Long musteriId) {
        return nakitAvansService.getNakitAvansByMusteriId(musteriId);
    }


    @GetMapping("/kart/{kartNumarasi}")
    public List<Map<String, Object>> getNakitAvansByKartNumarasi(@PathVariable String kartNumarasi) {
        return nakitAvansService.getNakitAvansByKartNumarasi(kartNumarasi);
    }

    @PutMapping
    public void updateNakitAvans(@RequestBody NakitAvans avans) {
        nakitAvansService.updateNakitAvans(avans);
    }

    @DeleteMapping("/{id}")
    public void deleteNakitAvans(@PathVariable("id") Long avansId) {
        nakitAvansService.deleteNakitAvans(avansId);
    }
}
