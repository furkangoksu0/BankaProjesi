package com.example.banka.Controller;

import com.example.banka.Entity.Talepler;
import com.example.banka.Service.TaleplerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/talepler")
public class TaleplerController {

    private final TaleplerService taleplerService;

    public TaleplerController(TaleplerService taleplerService) {
        this.taleplerService = taleplerService;
    }

    @PostMapping
    public void addTalep(@RequestBody Talepler talep) {
        taleplerService.addTalep(talep);
    }

    @GetMapping
    public List<Talepler> getAllTalepler() {
        return taleplerService.getAllTalepler();
    }
    @GetMapping("/by-musteri")
    public List<Map<String, Object>> getAllTaleplerByMusteri() {
        return taleplerService.getAllTaleplerByMusteri();
    }

    @GetMapping("/musteri/{musteriId}")
    public List<Map<String, Object>> getTaleplerByMusteriId(@PathVariable Long musteriId) {
        return taleplerService.getTaleplerByMusteriId(musteriId);
    }

    @GetMapping("/{id}")
    public Talepler getTalepById(@PathVariable("id") Long talepId) {
        return taleplerService.getTalepById(talepId);
    }

    @PutMapping
    public void updateTalep(@RequestBody Talepler talep) {
        taleplerService.updateTalep(talep);
    }

    @DeleteMapping("/{id}")
    public void deleteTalep(@PathVariable("id") Long talepId) {
        taleplerService.deleteTalep(talepId);
    }
}
