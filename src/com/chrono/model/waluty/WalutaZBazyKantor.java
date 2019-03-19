package com.chrono.model.waluty;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by Matiaw47 on 2016-12-08.
 */

public class WalutaZBazyKantor extends WalutaModel
{
    private String nazwaWaluty;
    private BigDecimal sredniKurs;
    private BigDecimal zyskNaWalucie;


    public WalutaZBazyKantor(String nazwaWaluty, String skrotWaluty, BigDecimal iloscWaluty,
                             BigDecimal iloscNaZlotowki, BigDecimal sredniKurs, BigDecimal zyskNaWalucie)
    {
        super(skrotWaluty,iloscWaluty,iloscNaZlotowki);
        this.nazwaWaluty = nazwaWaluty;
        this.sredniKurs = sredniKurs;
        this.zyskNaWalucie = zyskNaWalucie;
    }

    public WalutaZBazyKantor(String nazwaWaluty, String skrotWaluty)
    {
        this(nazwaWaluty, skrotWaluty, new BigDecimal(0.00).setScale(3, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(0.00).setScale(3, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(0.00).setScale(12, BigDecimal.ROUND_HALF_UP),
                new BigDecimal(0.00).setScale(3, BigDecimal.ROUND_HALF_UP));
    }


    public BigDecimal getSredniKurs() {
        return sredniKurs;
    }

    public void setSredniKurs(BigDecimal sredniKurs) {
        this.sredniKurs = sredniKurs;
    }

    public BigDecimal getZyskNaWalucie() {
        return zyskNaWalucie;
    }

    public void setZyskNaWalucie(BigDecimal zyskNaWalucie) {
        this.zyskNaWalucie = zyskNaWalucie;
    }

    @Override
    public String toString() {
        return "Waluta{" +
                "nazwaWaluty='" + nazwaWaluty + '\'' +
                ", skrotWaluty='" + super.getSkrotWaluty() + '\'' +
                ", iloscWaluty=" + super.getIloscWaluty() +
                ", iloscNaZlotowki=" + super.getIloscNaZlotowki() +
                ", sredniKurs=" + sredniKurs +
                '}';
    }
}

