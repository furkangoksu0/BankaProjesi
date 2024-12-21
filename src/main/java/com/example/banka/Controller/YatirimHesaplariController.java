package com.example.banka.Controller;

import com.example.banka.Entity.YatirimHesaplari;
import com.example.banka.Service.YatirimHesaplariService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yatirim-hesaplari")
public class YatirimHesaplariController {

    private final YatirimHesaplariService yatirimHesaplariService;

    public YatirimHesaplariController(YatirimHesaplariService yatirimHesaplariService) {
        this.yatirimHesaplariService = yatirimHesaplariService;
    }

    @PostMapping
    public void addYatirimHesabi(@RequestBody YatirimHesaplari yatirimHesabi) {
        yatirimHesaplariService.addYatirimHesabi(yatirimHesabi);
    }

    @GetMapping
    public List<YatirimHesaplari> getAllYatirimHesaplari() {
        return yatirimHesaplariService.getAllYatirimHesaplari();
    }

    @GetMapping("/{id}")
    public YatirimHesaplari getYatirimHesabiById(@PathVariable("id") Long yatirimId) {
        return yatirimHesaplariService.getYatirimHesabiById(yatirimId);
    }

    @PutMapping
    public void updateYatirimHesabi(@RequestBody YatirimHesaplari yatirimHesabi) {
        yatirimHesaplariService.updateYatirimHesabi(yatirimHesabi);
    }

    @DeleteMapping("/{id}")
    public void deleteYatirimHesabi(@PathVariable("id") Long yatirimId) {
        yatirimHesaplariService.deleteYatirimHesabi(yatirimId);
    }
}
