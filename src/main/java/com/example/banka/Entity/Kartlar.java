package com.example.banka.Entity;

import java.time.LocalDateTime;

public class Kartlar {
    private Long kartId;
    private String kartNumarasi;
    private String kartTuru;
    private Long hesapId;
    private LocalDateTime vadeTarihi;
    private Double kartLimit;

    // Getter ve Setter Metotları
    public Long getKartId() {
        return kartId;
    }

    public void setKartId(Long kartId) {
        this.kartId = kartId;
    }

    public String getKartNumarasi() {
        return kartNumarasi;
    }

    public void setKartNumarasi(String kartNumarasi) {
        this.kartNumarasi = kartNumarasi;
    }

    public String getKartTuru() {
        return kartTuru;
    }

    public void setKartTuru(String kartTuru) {
        this.kartTuru = kartTuru;
    }

    public Long getHesapId() {
        return hesapId;
    }

    public void setHesapId(Long hesapId) {
        this.hesapId = hesapId;
    }

    public LocalDateTime getVadeTarihi() {
        return vadeTarihi;
    }

    public void setVadeTarihi(LocalDateTime vadeTarihi) {
        this.vadeTarihi = vadeTarihi;
    }

    public Double getKartLimit() {
        return kartLimit;
    }

    public void setKartLimit(Double kartLimit) {
        this.kartLimit = kartLimit;
    }
}

