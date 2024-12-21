package com.example.banka.Entity;

import java.time.LocalDateTime;

public class Eft {
    private Long eftId;
    private Long gondericiHesapId;
    private Long aliciHesapId;
    private Double tutar;
    private LocalDateTime eftTarihi;
    private String durum;

    // Getter ve Setter Metotları
    public Long getEftId() {
        return eftId;
    }

    public void setEftId(Long eftId) {
        this.eftId = eftId;
    }

    public Long getGondericiHesapId() {
        return gondericiHesapId;
    }

    public void setGondericiHesapId(Long gondericiHesapId) {
        this.gondericiHesapId = gondericiHesapId;
    }

    public Long getAliciHesapId() {
        return aliciHesapId;
    }

    public void setAliciHesapId(Long aliciHesapId) {
        this.aliciHesapId = aliciHesapId;
    }

    public Double getTutar() {
        return tutar;
    }

    public void setTutar(Double tutar) {
        this.tutar = tutar;
    }

    public LocalDateTime getEftTarihi() {
        return eftTarihi;
    }

    public void setEftTarihi(LocalDateTime eftTarihi) {
        this.eftTarihi = eftTarihi;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
}
