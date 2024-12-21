package com.example.banka.Entity;

import java.time.LocalDateTime;

public class KrediOdemeleri {
    private Long odemeId;
    private Long krediId;
    private LocalDateTime odemeTarihi;
    private Double odenenTutar;
    private String odemeTuru;

    // Getter ve Setter Metotları
    public Long getOdemeId() {
        return odemeId;
    }

    public void setOdemeId(Long odemeId) {
        this.odemeId = odemeId;
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

    public String getOdemeTuru() {
        return odemeTuru;
    }

    public void setOdemeTuru(String odemeTuru) {
        this.odemeTuru = odemeTuru;
    }
}

