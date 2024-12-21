package com.example.banka.Controller;

import com.example.banka.Entity.NakitAvans;
import com.example.banka.Service.NakitAvansService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    public void updateNakitAvans(@RequestBody NakitAvans avans) {
        nakitAvansService.updateNakitAvans(avans);
    }

    @DeleteMapping("/{id}")
    public void deleteNakitAvans(@PathVariable("id") Long avansId) {
        nakitAvansService.deleteNakitAvans(avansId);
    }
}
