package com.example.banka.Entity;

import java.time.LocalDateTime;

public class Talepler {
    private Long talepId;
    private String talepTuru;
    private LocalDateTime talepTarihi;
    private Long musteriId;

    // Getter ve Setter Metotları
    public Long getTalepId() {
        return talepId;
    }

    public void setTalepId(Long talepId) {
        this.talepId = talepId;
    }

    public String getTalepTuru() {
        return talepTuru;
    }

    public void setTalepTuru(String talepTuru) {
        this.talepTuru = talepTuru;
    }

    public LocalDateTime getTalepTarihi() {
        return talepTarihi;
    }

    public void setTalepTarihi(LocalDateTime talepTarihi) {
        this.talepTarihi = talepTarihi;
    }

    public Long getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(Long musteriId) {
        this.musteriId = musteriId;
    }
}
