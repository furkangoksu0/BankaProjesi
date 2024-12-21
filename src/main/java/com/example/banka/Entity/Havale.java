package com.example.banka.Entity;

import java.time.LocalDateTime;

public class Havale {
    private Long havaleId;
    private Long gondericiHesapId;
    private Long aliciHesapId;
    private Double tutar;
    private LocalDateTime havaleTarihi;
    private String durum;

    // Getter ve Setter Metotları
    public Long getHavaleId() {
        return havaleId;
    }

    public void setHavaleId(Long havaleId) {
        this.havaleId = havaleId;
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

    public LocalDateTime getHavaleTarihi() {
        return havaleTarihi;
    }

    public void setHavaleTarihi(LocalDateTime havaleTarihi) {
        this.havaleTarihi = havaleTarihi;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
}
