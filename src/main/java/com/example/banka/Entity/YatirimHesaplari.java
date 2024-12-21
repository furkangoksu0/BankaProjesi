package com.example.banka.Entity;

import java.time.LocalDateTime;

public class YatirimHesaplari {
    private Long yatirimId;
    private Double bakiye;
    private LocalDateTime alisTarihi;
    private LocalDateTime satisTarihi;
    private String yatirimTuru;
    private Long musteriId;

    // Getter ve Setter Metotları
    public Long getYatirimId() {
        return yatirimId;
    }

    public void setYatirimId(Long yatirimId) {
        this.yatirimId = yatirimId;
    }

    public Double getBakiye() {
        return bakiye;
    }

    public void setBakiye(Double bakiye) {
        this.bakiye = bakiye;
    }

    public LocalDateTime getAlisTarihi() {
        return alisTarihi;
    }

    public void setAlisTarihi(LocalDateTime alisTarihi) {
        this.alisTarihi = alisTarihi;
    }

    public LocalDateTime getSatisTarihi() {
        return satisTarihi;
    }

    public void setSatisTarihi(LocalDateTime satisTarihi) {
        this.satisTarihi = satisTarihi;
    }

    public String getYatirimTuru() {
        return yatirimTuru;
    }

    public void setYatirimTuru(String yatirimTuru) {
        this.yatirimTuru = yatirimTuru;
    }

    public Long getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(Long musteriId) {
        this.musteriId = musteriId;
    }
}
