package com.chrono.model.waluty;

import java.math.BigDecimal;

/**
 * Created by Matiaw47 on 2016-12-09.
 */
public class WalutaModel {
    private String skrotWaluty;
    private BigDecimal iloscWaluty;
    private BigDecimal iloscNaZlotowki;

    public  WalutaModel()
    {
        skrotWaluty = "";
        iloscWaluty = new BigDecimal(0.00).setScale(3,BigDecimal.ROUND_HALF_UP);
        iloscNaZlotowki = new BigDecimal(0.00).setScale(3,BigDecimal.ROUND_HALF_UP);
    }

    public WalutaModel(String SkrotWalutowy, BigDecimal iloscWaluty, BigDecimal iloscNaZlotowki) {
        this.skrotWaluty = SkrotWalutowy;
        this.iloscWaluty = iloscWaluty;
        this.iloscNaZlotowki = iloscNaZlotowki;
    }

    public String getSkrotWaluty() {
        return skrotWaluty;
    }

    public void setSkrotWaluty(String skrotWaluty) {
        this.skrotWaluty = skrotWaluty;
    }

    public BigDecimal getIloscWaluty() {
        return iloscWaluty;
    }

    public void setIloscWaluty(BigDecimal iloscWaluty) {
        this.iloscWaluty = iloscWaluty;
    }

    public BigDecimal getIloscNaZlotowki() {
        return iloscNaZlotowki;
    }

    public void setIloscNaZlotowki(BigDecimal iloscNaZlotowki) {
        this.iloscNaZlotowki = iloscNaZlotowki;
    }

    @Override
    public String toString() {
        return "WalutaModel{" +
                "skrotWaluty='" + skrotWaluty + '\'' +
                ", iloscWaluty=" + iloscWaluty +
                ", iloscNaZlotowki=" + iloscNaZlotowki +
                '}';
    }
}
