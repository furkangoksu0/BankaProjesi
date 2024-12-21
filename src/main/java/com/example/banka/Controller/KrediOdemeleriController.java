package com.example.banka.Controller;

import com.example.banka.Entity.KrediOdemeleri;
import com.example.banka.Service.KrediOdemeleriService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kredi-odemeleri")
public class KrediOdemeleriController {

    private final KrediOdemeleriService krediOdemeleriService;

    public KrediOdemeleriController(KrediOdemeleriService krediOdemeleriService) {
        this.krediOdemeleriService = krediOdemeleriService;
    }

    @PostMapping
    public void addOdeme(@RequestBody KrediOdemeleri odeme) {
        krediOdemeleriService.addOdeme(odeme);
    }

    @GetMapping
    public List<KrediOdemeleri> getAllOdemeler() {
        return krediOdemeleriService.getAllOdemeler();
    }

    @GetMapping("/{id}")
    public KrediOdemeleri getOdemeById(@PathVariable("id") Long odemeId) {
        return krediOdemeleriService.getOdemeById(odemeId);
    }

    @DeleteMapping("/{id}")
    public void deleteOdeme(@PathVariable("id") Long odemeId) {
        krediOdemeleriService.deleteOdeme(odemeId);
    }
}
