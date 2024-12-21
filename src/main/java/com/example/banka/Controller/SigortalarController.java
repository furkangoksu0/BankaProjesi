package com.example.banka.Controller;

import com.example.banka.Entity.Sigortalar;
import com.example.banka.Service.SigortalarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sigortalar")
public class SigortalarController {

    private final SigortalarService sigortalarService;

    public SigortalarController(SigortalarService sigortalarService) {
        this.sigortalarService = sigortalarService;
    }

    @PostMapping
    public void addSigorta(@RequestBody Sigortalar sigorta) {
        sigortalarService.addSigorta(sigorta);
    }

    @GetMapping
    public List<Sigortalar> getAllSigortalar() {
        return sigortalarService.getAllSigortalar();
    }

    @GetMapping("/{id}")
    public Sigortalar getSigortaById(@PathVariable("id") Long sigortaId) {
        return sigortalarService.getSigortaById(sigortaId);
    }

    @PutMapping
    public void updateSigorta(@RequestBody Sigortalar sigorta) {
        sigortalarService.updateSigorta(sigorta);
    }

    @DeleteMapping("/{id}")
    public void deleteSigorta(@PathVariable("id") Long sigortaId) {
        sigortalarService.deleteSigorta(sigortaId);
    }
}
