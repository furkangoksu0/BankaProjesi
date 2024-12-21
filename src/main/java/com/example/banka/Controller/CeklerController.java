package com.example.banka.Controller;

import com.example.banka.Entity.Cekler;
import com.example.banka.Service.CeklerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cekler")
public class CeklerController {

    private final CeklerService ceklerService;

    public CeklerController(CeklerService ceklerService) {
        this.ceklerService = ceklerService;
    }

    @PostMapping
    public void addCek(@RequestBody Cekler cek) {
        ceklerService.addCek(cek);
    }

    @GetMapping
    public List<Cekler> getAllCekler() {
        return ceklerService.getAllCekler();
    }

    @GetMapping("/{id}")
    public Cekler getCekById(@PathVariable("id") Long cekId) {
        return ceklerService.getCekById(cekId);
    }

    @PutMapping
    public void updateCek(@RequestBody Cekler cek) {
        ceklerService.updateCek(cek);
    }

    @DeleteMapping("/{id}")
    public void deleteCek(@PathVariable("id") Long cekId) {
        ceklerService.deleteCek(cekId);
    }
}
