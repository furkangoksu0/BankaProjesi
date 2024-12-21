package com.example.banka.Controller;

import com.example.banka.Entity.KrediKartiBorclari;
import com.example.banka.Service.KrediKartiBorclariService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/krediKartiBorclari")
public class KrediKartiBorclariController {

    private final KrediKartiBorclariService krediKartiBorclariService;

    public KrediKartiBorclariController(KrediKartiBorclariService krediKartiBorclariService) {
        this.krediKartiBorclariService = krediKartiBorclariService;
    }

    @PostMapping
    public void addBorc(@RequestBody KrediKartiBorclari borc) {
        krediKartiBorclariService.addBorc(borc);
    }

    @GetMapping
    public List<KrediKartiBorclari> getAllBorclar() {
        return krediKartiBorclariService.getAllBorclar();
    }

    @GetMapping("/{id}")
    public KrediKartiBorclari getBorcById(@PathVariable("id") Long borcId) {
        return krediKartiBorclariService.getBorcById(borcId);
    }

    @PutMapping
    public void updateBorc(@RequestBody KrediKartiBorclari borc) {
        krediKartiBorclariService.updateBorc(borc);
    }

    @DeleteMapping("/{id}")
    public void deleteBorc(@PathVariable("id") Long borcId) {
        krediKartiBorclariService.deleteBorc(borcId);
    }
}
