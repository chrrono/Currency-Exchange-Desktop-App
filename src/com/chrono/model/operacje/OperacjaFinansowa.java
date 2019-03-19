package com.chrono.model.operacje;

import com.chrono.model.waluty.MapaWalutKursow;
import com.chrono.model.waluty.WalutaPrzetwarzanaZDialogu;
import com.chrono.model.waluty.WalutaZBazyKantor;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by Matiaw47 on 2016-12-08.
 */
public class OperacjaFinansowa
{

    public static boolean Operacja(MapaWalutKursow mapa, WalutaPrzetwarzanaZDialogu walutyDialog,
                                   String typOperacji)
    {
        if(typOperacji.toLowerCase().equals("zakup"))
        {
            if(zakup(mapa,walutyDialog) == true )
                return true;
        }
        else if(typOperacji.toLowerCase().equals("sprzedaż")) {
            if(sprzedaz(mapa,walutyDialog)== true)
                return true;
        }
        return false;
    }

    private static boolean zakup(MapaWalutKursow mapa, WalutaPrzetwarzanaZDialogu walutyDialog)
    {
        WalutaZBazyKantor waluta = mapa.getWaluta(walutyDialog.getSkrotWaluty());

        BigDecimal tempIlosc = waluta.getIloscWaluty().setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal tempZlotowki = waluta.getIloscNaZlotowki().setScale(3, BigDecimal.ROUND_HALF_UP);
        BigDecimal tempSredniKurs;


        tempIlosc = tempIlosc.add(walutyDialog.getIloscWaluty());
        waluta.setIloscWaluty(tempIlosc);

        tempZlotowki = tempZlotowki.add(walutyDialog.getIloscNaZlotowki());
        waluta.setIloscNaZlotowki(tempZlotowki);

        tempSredniKurs = tempZlotowki.divide(tempIlosc,new MathContext(12, RoundingMode.HALF_UP));
        waluta.setSredniKurs(tempSredniKurs);

        return true;

    }

    private static boolean sprzedaz(MapaWalutKursow mapa, WalutaPrzetwarzanaZDialogu walutyDialog)
    {
        WalutaZBazyKantor waluta = mapa.getWaluta(walutyDialog.getSkrotWaluty());


        if(waluta.getIloscWaluty().doubleValue() >= walutyDialog.getIloscWaluty().doubleValue()) {
            waluta.setIloscWaluty(waluta.getIloscWaluty().setScale(3, BigDecimal.ROUND_HALF_UP)
                    .subtract(walutyDialog.getIloscWaluty()));

            waluta.setIloscNaZlotowki((waluta.getIloscNaZlotowki()
                    .subtract(walutyDialog.getIloscWaluty().multiply(waluta.getSredniKurs()))).setScale(3, BigDecimal.ROUND_HALF_UP));

            waluta.setZyskNaWalucie(waluta.getZyskNaWalucie().add((walutyDialog.getKursOperacji().subtract((waluta.getSredniKurs()))
                    .multiply(walutyDialog.getIloscWaluty())).setScale(3, BigDecimal.ROUND_HALF_UP)));

            mapa.setZyskCalkowity(mapa.getZyskCalkowity().add((walutyDialog.getKursOperacji().subtract(waluta.getSredniKurs()))
                            .multiply(walutyDialog.getIloscWaluty())).setScale(3, BigDecimal.ROUND_HALF_UP));

            return true;
        }
        return false;
    }

    public static String przeliczWaluteNaZlotowki(String walutaString, String kursString)
    {
        BigDecimal waluta = new BigDecimal(walutaString).setScale(3,BigDecimal.ROUND_HALF_UP);
        BigDecimal kurs = new BigDecimal(kursString).setScale(3,BigDecimal.ROUND_HALF_UP);
        BigDecimal Zlotowki = waluta.multiply(kurs).setScale(3,BigDecimal.ROUND_HALF_UP);
        return Zlotowki.toString();
    }


}

