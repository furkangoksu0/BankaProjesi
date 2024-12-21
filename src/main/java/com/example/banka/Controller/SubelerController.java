package com.example.banka.Controller;

import com.example.banka.Entity.Subeler;
import com.example.banka.Service.SubelerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subeler")
public class SubelerController {

    private final SubelerService subelerService;

    public SubelerController(SubelerService subelerService) {
        this.subelerService = subelerService;
    }

    @PostMapping
    public void addSube(@RequestBody Subeler sube) {
        subelerService.addSube(sube);
    }

    @GetMapping
    public List<Subeler> getAllSubeler() {
        return subelerService.getAllSubeler();
    }
    @GetMapping("/{subeId}/islemler")

    public List<Map<String, Object>> getSubeIslemleri(@PathVariable Long subeId) {
        return subelerService.getSubeIslemleri(subeId);
    }
    @GetMapping("/{id}")
    public Subeler getSubeById(@PathVariable("id") Long subeId) {
        return subelerService.getSubeById(subeId);
    }

    @PutMapping
    public void updateSube(@RequestBody Subeler sube) {
        subelerService.updateSube(sube);
    }

    @DeleteMapping("/{id}")
    public void deleteSube(@PathVariable("id") Long subeId) {
        subelerService.deleteSube(subeId);
    }
}
