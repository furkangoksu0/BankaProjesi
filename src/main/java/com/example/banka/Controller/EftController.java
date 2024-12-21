package com.example.banka.Controller;

import com.example.banka.Entity.Eft;
import com.example.banka.Service.EftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    public void updateEft(@RequestBody Eft eft) {
        eftService.updateEft(eft);
    }

    @DeleteMapping("/{id}")
    public void deleteEft(@PathVariable("id") Long eftId) {
        eftService.deleteEft(eftId);
    }
}
