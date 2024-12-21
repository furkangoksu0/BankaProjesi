package com.example.banka.Entity;

import java.time.LocalDateTime;

public class Islemler {
    private Long islemId;
    private Long hesapId;
    private LocalDateTime islemTarihi;
    private String islemTuru;
    private Double tutar;
    private String aciklama;
    private Long subeId;

    // Getter ve Setter Metotları
    public Long getIslemId() {
        return islemId;
    }

    public void setIslemId(Long islemId) {
        this.islemId = islemId;
    }

    public Long getHesapId() {
        return hesapId;
    }

    public void setHesapId(Long hesapId) {
        this.hesapId = hesapId;
    }

    public LocalDateTime getIslemTarihi() {
        return islemTarihi;
    }

    public void setIslemTarihi(LocalDateTime islemTarihi) {
        this.islemTarihi = islemTarihi;
    }

    public String getIslemTuru() {
        return islemTuru;
    }

    public void setIslemTuru(String islemTuru) {
        this.islemTuru = islemTuru;
    }

    public Double getTutar() {
        return tutar;
    }

    public void setTutar(Double tutar) {
        this.tutar = tutar;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Long getSubeId() {
        return subeId;
    }

    public void setSubeId(Long subeId) {
        this.subeId = subeId;
    }
}
