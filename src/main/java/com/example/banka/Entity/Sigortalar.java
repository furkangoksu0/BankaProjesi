package com.example.banka.Entity;

import java.time.LocalDateTime;

public class Sigortalar {
    private Long sigortaId;
    private String sigortaTuru;
    private LocalDateTime baslangicTarihi;
    private LocalDateTime bitisTarihi;
    private Double primTutari;
    private Long musteriId;

    // Getter ve Setter Metotları
    public Long getSigortaId() {
        return sigortaId;
    }

    public void setSigortaId(Long sigortaId) {
        this.sigortaId = sigortaId;
    }

    public String getSigortaTuru() {
        return sigortaTuru;
    }

    public void setSigortaTuru(String sigortaTuru) {
        this.sigortaTuru = sigortaTuru;
    }

    public LocalDateTime getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(LocalDateTime baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public LocalDateTime getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(LocalDateTime bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public Double getPrimTutari() {
        return primTutari;
    }

    public void setPrimTutari(Double primTutari) {
        this.primTutari = primTutari;
    }

    public Long getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(Long musteriId) {
        this.musteriId = musteriId;
    }
}
