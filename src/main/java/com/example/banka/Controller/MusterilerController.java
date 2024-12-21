package com.example.banka.Controller;

import com.example.banka.Entity.Musteriler;
import com.example.banka.Service.MusterilerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musteriler")
public class MusterilerController {
    private final MusterilerService musteriService;

    public MusterilerController(MusterilerService musteriService) {
        this.musteriService = musteriService;
    }

    @PostMapping
    public void addMusteri(@RequestBody Musteriler musteri) {
        musteriService.addMusteri(musteri);
    }

    @GetMapping
    public List<Musteriler> getAllMusteriler() {
        return musteriService.getAllMusteriler();
    }

    @GetMapping("/{id}")
    public Musteriler getMusteriById(@PathVariable Long id) {
        return musteriService.getMusteriById(id);
    }

    @PutMapping("/{id}")
    public void updateMusteri(@PathVariable Long id, @RequestBody Musteriler musteri) {
        musteri.setMusteriId(id);
        musteriService.updateMusteri(musteri);
    }

    @DeleteMapping("/{id}")
    public void deleteMusteri(@PathVariable Long id) {
        musteriService.deleteMusteri(id);
    }
}

