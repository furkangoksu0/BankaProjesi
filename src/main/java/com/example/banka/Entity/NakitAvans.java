package com.example.banka.Entity;

import java.time.LocalDateTime;

public class NakitAvans {
    private Long avansId;
    private Long kartId;
    private Double avansTutari;
    private LocalDateTime avansTarihi;
    private Double odenenTutar;

    // Getter ve Setter Metotları
    public Long getAvansId() {
        return avansId;
    }

    public void setAvansId(Long avansId) {
        this.avansId = avansId;
    }

    public Long getKartId() {
        return kartId;
    }

    public void setKartId(Long kartId) {
        this.kartId = kartId;
    }

    public Double getAvansTutari() {
        return avansTutari;
    }

    public void setAvansTutari(Double avansTutari) {
        this.avansTutari = avansTutari;
    }

    public LocalDateTime getAvansTarihi() {
        return avansTarihi;
    }

    public void setAvansTarihi(LocalDateTime avansTarihi) {
        this.avansTarihi = avansTarihi;
    }

    public Double getOdenenTutar() {
        return odenenTutar;
    }

    public void setOdenenTutar(Double odenenTutar) {
        this.odenenTutar = odenenTutar;
    }
}
