package com.chrono.model.waluty;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by Matiaw47 on 2016-12-09.
 */
public class WalutaPrzetwarzanaZDialogu extends WalutaModel
{
    private BigDecimal kursOperacji;

    public WalutaPrzetwarzanaZDialogu()
    {
        super("",new BigDecimal(0.00).setScale(3, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(0.00).setScale(3, BigDecimal.ROUND_HALF_UP));
        this.kursOperacji = new BigDecimal(0.00).setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    public WalutaPrzetwarzanaZDialogu(String skrotWaluty, BigDecimal iloscWaluty,
                                      BigDecimal kursOperacji)
    {
        super(skrotWaluty,iloscWaluty, new BigDecimal(0.00));
        this.kursOperacji = kursOperacji;
        this.setIloscNaZlotowki();
    }

    public BigDecimal getKursOperacji() {
        return kursOperacji;
    }

    public void setKursOperacji(BigDecimal kursOperacji) {
        this.kursOperacji = kursOperacji;
    }

    @Override
    public BigDecimal getIloscNaZlotowki() {
        return super.getIloscNaZlotowki();
    }


    public void setIloscNaZlotowki() {
        super.setIloscNaZlotowki((super.getIloscWaluty()).multiply(kursOperacji,new MathContext(10, RoundingMode.HALF_UP)));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
