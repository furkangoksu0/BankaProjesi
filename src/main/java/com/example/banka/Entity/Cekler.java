package com.example.banka.Entity;

import java.time.LocalDateTime;

public class Cekler {
    private Long cekId;
    private String cekNumarasi;
    private LocalDateTime kesilmeTarihi;
    private LocalDateTime vadeTarihi;
    private Double tutar;
    private Long hesapId;

    // Getter ve Setter Metotları
    public Long getCekId() {
        return cekId;
    }

    public void setCekId(Long cekId) {
        this.cekId = cekId;
    }

    public String getCekNumarasi() {
        return cekNumarasi;
    }

    public void setCekNumarasi(String cekNumarasi) {
        this.cekNumarasi = cekNumarasi;
    }

    public LocalDateTime getKesilmeTarihi() {
        return kesilmeTarihi;
    }

    public void setKesilmeTarihi(LocalDateTime kesilmeTarihi) {
        this.kesilmeTarihi = kesilmeTarihi;
    }

    public LocalDateTime getVadeTarihi() {
        return vadeTarihi;
    }

    public void setVadeTarihi(LocalDateTime vadeTarihi) {
        this.vadeTarihi = vadeTarihi;
    }

    public Double getTutar() {
        return tutar;
    }

    public void setTutar(Double tutar) {
        this.tutar = tutar;
    }

    public Long getHesapId() {
        return hesapId;
    }

    public void setHesapId(Long hesapId) {
        this.hesapId = hesapId;
    }
}
