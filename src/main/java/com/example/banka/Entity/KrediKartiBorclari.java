package com.example.banka.Entity;

import java.time.LocalDateTime;

public class KrediKartiBorclari {
    private Long borcId;
    private Long kartId;
    private Double borcTutari;
    private LocalDateTime sonOdemeTarihi;
    private Double odenenTutar;

    // Getter ve Setter Metotları
    public Long getBorcId() {
        return borcId;
    }

    public void setBorcId(Long borcId) {
        this.borcId = borcId;
    }

    public Long getKartId() {
        return kartId;
    }

    public void setKartId(Long kartId) {
        this.kartId = kartId;
    }

    public Double getBorcTutari() {
        return borcTutari;
    }

    public void setBorcTutari(Double borcTutari) {
        this.borcTutari = borcTutari;
    }

    public LocalDateTime getSonOdemeTarihi() {
        return sonOdemeTarihi;
    }

    public void setSonOdemeTarihi(LocalDateTime sonOdemeTarihi) {
        this.sonOdemeTarihi = sonOdemeTarihi;
    }

    public Double getOdenenTutar() {
        return odenenTutar;
    }

    public void setOdenenTutar(Double odenenTutar) {
        this.odenenTutar = odenenTutar;
    }
}
