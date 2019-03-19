package com.chrono.model.waluty;

import com.chrono.model.waluty.WalutaZBazyKantor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matiaw47 on 2016-12-08.
 */
public class MapaWalutKursow {
    private Map<String,WalutaZBazyKantor> mapaWalut;
    private BigDecimal zyskCalkowity;

    public MapaWalutKursow()
    {
        mapaWalut = new HashMap<>(9);
        zyskCalkowity = new BigDecimal(0.00).setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    public Map<String,WalutaZBazyKantor> dodajWalute(WalutaZBazyKantor waluta)
    {
        mapaWalut.put(waluta.getSkrotWaluty(),waluta);
        return  mapaWalut;
    }


    public WalutaZBazyKantor getWaluta(String skrotWaluty)
    {
        return mapaWalut.get(skrotWaluty.toUpperCase());
    }

    public BigDecimal getZyskCalkowity() {
        return zyskCalkowity;
    }

    public void setZyskCalkowity(BigDecimal zysk) {
        this.zyskCalkowity = zysk;
    }


    @Override
    public String toString() {
        String opis = "";
        for (Map.Entry<String,WalutaZBazyKantor> entry : mapaWalut.entrySet()) {

            opis +="Key: " + entry.getKey();
            opis +="Value: { " + entry.getValue()+ " } ";
            opis +="\n";
        }
        return opis;
    }

}
