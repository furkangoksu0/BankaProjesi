package com.example.banka.Entity;

public class Krediler {
    private Long krediId;
    private Double kalanBorc;
    private Double alinanBorc;
    private Double odenenMiktar;
    private Integer vade;
    private Long musteriId;

    // Getter ve Setter Metotları
    public Long getKrediId() {
        return krediId;
    }

    public void setKrediId(Long krediId) {
        this.krediId = krediId;
    }

    public Double getKalanBorc() {
        return kalanBorc;
    }

    public void setKalanBorc(Double kalanBorc) {
        this.kalanBorc = kalanBorc;
    }

    public Double getAlinanBorc() {
        return alinanBorc;
    }

    public void setAlinanBorc(Double alinanBorc) {
        this.alinanBorc = alinanBorc;
    }

    public Double getOdenenMiktar() {
        return odenenMiktar;
    }

    public void setOdenenMiktar(Double odenenMiktar) {
        this.odenenMiktar = odenenMiktar;
    }

    public Integer getVade() {
        return vade;
    }

    public void setVade(Integer vade) {
        this.vade = vade;
    }

    public Long getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(Long musteriId) {
        this.musteriId = musteriId;
    }
}

