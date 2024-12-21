package com.example.banka.Entity;

import java.time.LocalDateTime;

public class KrediPlanlari {
    private Long planId;
    private Long krediId;
    private LocalDateTime odemeTarihi;
    private Double odenenTutar;
    private Double kalanBorc;

    // Getter ve Setter Metotları
    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getKrediId() {
        return krediId;
    }

    public void setKrediId(Long krediId) {
        this.krediId = krediId;
    }

    public LocalDateTime getOdemeTarihi() {
        return odemeTarihi;
    }

    public void setOdemeTarihi(LocalDateTime odemeTarihi) {
        this.odemeTarihi = odemeTarihi;
    }

    public Double getOdenenTutar() {
        return odenenTutar;
    }

    public void setOdenenTutar(Double odenenTutar) {
        this.odenenTutar = odenenTutar;
    }

    public Double getKalanBorc() {
        return kalanBorc;
    }

    public void setKalanBorc(Double kalanBorc) {
        this.kalanBorc = kalanBorc;
    }
}
