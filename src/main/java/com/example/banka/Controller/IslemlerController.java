package com.example.banka.Controller;

import com.example.banka.Entity.Islemler;
import com.example.banka.Service.IslemlerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/islemler")
public class IslemlerController {

    private final IslemlerService islemlerService;

    public IslemlerController(IslemlerService islemlerService) {
        this.islemlerService = islemlerService;
    }

    @PostMapping
    public void addIslem(@RequestBody Islemler islem) {
        islemlerService.addIslem(islem);
    }

    @GetMapping
    public List<Islemler> getAllIslemler() {
        return islemlerService.getAllIslemler();
    }

    @GetMapping("/{id}")
    public Islemler getIslemById(@PathVariable("id") Long islemId) {
        return islemlerService.getIslemById(islemId);
    }

    @PutMapping
    public void updateIslem(@RequestBody Islemler islem) {
        islemlerService.updateIslem(islem);
    }

    @DeleteMapping("/{id}")
    public void deleteIslem(@PathVariable("id") Long islemId) {
        islemlerService.deleteIslem(islemId);
    }
}
