package com.example.banka.Entity;


import java.time.LocalDateTime;

public class Hesaplar {
    private Long hesapId;
    private LocalDateTime acilisTarih;
    private String hesapTuru;
    private Double bakiye;
    private String hesapAdi;
    private Long musteriId;

    // Getter ve Setter Metotları
    public Long getHesapId() {
        return hesapId;
    }

    public void setHesapId(Long hesapId) {
        this.hesapId = hesapId;
    }

    public LocalDateTime getAcilisTarih() {
        return acilisTarih;
    }

    public void setAcilisTarih(LocalDateTime acilisTarih) {
        this.acilisTarih = acilisTarih;
    }

    public String getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(String hesapTuru) {
        this.hesapTuru = hesapTuru;
    }

    public Double getBakiye() {
        return bakiye;
    }

    public void setBakiye(Double bakiye) {
        this.bakiye = bakiye;
    }

    public String getHesapAdi() {
        return hesapAdi;
    }

    public void setHesapAdi(String hesapAdi) {
        this.hesapAdi = hesapAdi;
    }

    public Long getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(Long musteriId) {
        this.musteriId = musteriId;
    }
}

