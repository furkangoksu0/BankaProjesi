package com.example.banka.Controller;

import com.example.banka.Entity.KrediPlanlari;
import com.example.banka.Service.KrediPlanlariService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kredi-planlari")
public class KrediPlanlariController {

    private final KrediPlanlariService krediPlanlariService;

    public KrediPlanlariController(KrediPlanlariService krediPlanlariService) {
        this.krediPlanlariService = krediPlanlariService;
    }

    @PostMapping
    public void addPlan(@RequestBody KrediPlanlari plan) {
        krediPlanlariService.addPlan(plan);
    }

    @GetMapping
    public List<KrediPlanlari> getAllPlans() {
        return krediPlanlariService.getAllPlans();
    }

    @GetMapping("/{id}")
    public KrediPlanlari getPlanById(@PathVariable("id") Long planId) {
        return krediPlanlariService.getPlanById(planId);
    }

    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable("id") Long planId) {
        krediPlanlariService.deletePlan(planId);
    }
}
