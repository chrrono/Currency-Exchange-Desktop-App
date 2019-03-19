package com.chrono.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

import com.chrono.model.waluty.*;


public class KantorPodstawowyPanel extends JPanel
{
    private JPanel panelGorny;
    private JPanel panelDolny;
    private Map<String,WalutaZbiorJTextArea> textAreaMap ;
    private MapaWalutKursow mapa;
    private HandlowyDialogPanel dialog;
    private WalutaPrzetwarzanaZDialogu walutaWczytana;

    public KantorPodstawowyPanel()
    {

        mapa = new MapaWalutKursow();
        mapa.dodajWalute(new WalutaZBazyKantor("euro","EUR"));
        mapa.dodajWalute(new WalutaZBazyKantor("dolar amerykański","USD"));
        mapa.dodajWalute(new WalutaZBazyKantor("funt brytyjski","GBP"));
        mapa.dodajWalute(new WalutaZBazyKantor("dolar kanadyjski","CAD"));
        mapa.dodajWalute(new WalutaZBazyKantor("dolar australijski","AUD"));
        mapa.dodajWalute(new WalutaZBazyKantor("korona norweska","NOK"));
        mapa.dodajWalute(new WalutaZBazyKantor("korona szwedzka","SEK"));
        mapa.dodajWalute(new WalutaZBazyKantor("korona dunska","DKK"));
        mapa.dodajWalute(new WalutaZBazyKantor("korona czeska","CZK"));
        mapa.dodajWalute(new WalutaZBazyKantor("forint wegierski","HUF"));
        mapa.dodajWalute(new WalutaZBazyKantor("frank szwajcarski","CHF"));

        walutaWczytana = new WalutaPrzetwarzanaZDialogu();
        dialog = new HandlowyDialogPanel(walutaWczytana,mapa);

        setLayout(new BorderLayout());
        panelGorny = new JPanel();
        panelGorny.setLayout(new GridLayout(11,3));

        String path="";
        try {
            path = new File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        addLabel("EUR",  new ImageIcon(path+"\\Images\\EUR.gif"), panelGorny);
        addButton("Zakup", new ActionChooser("EUR","Zakup"), panelGorny);
        addButton("Sprzedaż", new ActionChooser("EUR","Sprzedaż"), panelGorny);

        addLabel("GBP",  new ImageIcon(path+"\\Images\\GBP.gif"), panelGorny);
        addButton("Zakup", new ActionChooser("GBP","Zakup"), panelGorny);
        addButton("Sprzedaż", new ActionChooser("GBP","Sprzedaż"), panelGorny);

        addLabel("USD",  new ImageIcon(path+"\\Images\\USD.gif"), panelGorny);
        addButton("Zakup", new ActionChooser("USD","Zakup"), panelGorny);
        addButton("Sprzedaż", new ActionChooser("USD","Sprzedaż"), panelGorny);

        addLabel("CAD",  new ImageIcon(path+"\\Images\\CAD.gif"), panelGorny);
        addButton("Zakup", new ActionChooser("CAD","Zakup"), panelGorny);
        addButton("Sprzedaż", new ActionChooser("CAD","Sprzedaż"), panelGorny);

        addLabel("AUD",  new ImageIcon(path+"\\Images\\AUD.gif"), panelGorny);
        addButton("Zakup", new ActionChooser("AUD","Zakup"), panelGorny);
        addButton("Sprzedaż", new ActionChooser("AUD","Sprzedaż"), panelGorny);

        addLabel("SEK",  new ImageIcon(path+"\\Images\\SEK.gif"), panelGorny);
        addButton("Zakup", new ActionChooser("SEK","Zakup"), panelGorny);
        addButton("Sprzedaż", new ActionChooser("SEK","Sprzedaż"), panelGorny);

        addLabel("NOK",  new ImageIcon(path+"\\Images\\NOK.gif"), panelGorny);
        addButton("Zakup", new ActionChooser("NOK","Zakup"), panelGorny);
        addButton("Sprzedaż", new ActionChooser("NOK","Sprzedaż"), panelGorny);

        addLabel("DKK",  new ImageIcon(path+"\\Images\\DKK.gif"), panelGorny);
        addButton("Zakup", new ActionChooser("DKK","Zakup"), panelGorny);
        addButton("Sprzedaż", new ActionChooser("DKK","Sprzedaż"), panelGorny);

        addLabel("CHF",  new ImageIcon(path+"\\Images\\CHF.gif"), panelGorny);
        addButton("Zakup", new ActionChooser("CHF","Zakup"), panelGorny);
        addButton("Sprzedaż", new ActionChooser("CHF","Sprzedaż"), panelGorny);

        addLabel("CZK",  new ImageIcon(path+"\\Images\\CZK.gif"), panelGorny);
        addButton("Zakup", new ActionChooser("CZK","Zakup"), panelGorny);
        addButton("Sprzedaż", new ActionChooser("CZK","Sprzedaż"), panelGorny);

        addLabel("HUF",  new ImageIcon(path+"\\Images\\HUF.gif"), panelGorny);
        addButton("Zakup", new ActionChooser("HUF","Zakup"), panelGorny);
        addButton("Sprzedaż", new ActionChooser("HUF","Sprzedaż"), panelGorny);

        add(panelGorny, BorderLayout.NORTH);


        panelDolny = new JPanel();
        panelDolny.setLayout(new GridLayout(12,5));

        addLabel(" ", null, panelDolny);
        addLabel("Ilosc waluty: ",  null, panelDolny);
        addLabel("Przeliczenie na złotówki:", null, panelDolny);
        addLabel("Uśredniony kurs:", null, panelDolny);
        addLabel("Zysk:", null, panelDolny);

        textAreaMap = new HashMap<>(11);
        textAreaMap.put("EUR",new WalutaZbiorJTextArea());
        textAreaMap.put("GBP",new WalutaZbiorJTextArea());
        textAreaMap.put("USD",new WalutaZbiorJTextArea());
        textAreaMap.put("CAD",new WalutaZbiorJTextArea());
        textAreaMap.put("AUD",new WalutaZbiorJTextArea());
        textAreaMap.put("SEK",new WalutaZbiorJTextArea());
        textAreaMap.put("NOK",new WalutaZbiorJTextArea());
        textAreaMap.put("DKK",new WalutaZbiorJTextArea());
        textAreaMap.put("CHF",new WalutaZbiorJTextArea());
        textAreaMap.put("CZK",new WalutaZbiorJTextArea());
        textAreaMap.put("HUF",new WalutaZbiorJTextArea());



        addLabel("EUR",  new ImageIcon(path+"\\Images\\EUR.gif"), panelDolny);
        textAreaMap.get("EUR").dodajWalutaDoPanelu(panelDolny);

        addLabel("GBP",  new ImageIcon(path+"\\Images\\GBP.gif"), panelDolny);
        textAreaMap.get("GBP").dodajWalutaDoPanelu(panelDolny);

        addLabel("USD",  new ImageIcon(path+"\\Images\\USD.gif"), panelDolny);
        textAreaMap.get("USD").dodajWalutaDoPanelu(panelDolny);

        addLabel("CAD",  new ImageIcon(path+"\\Images\\CAD.gif"), panelDolny);
        textAreaMap.get("CAD").dodajWalutaDoPanelu(panelDolny);

        addLabel("AUD",  new ImageIcon(path+"\\Images\\AUD.gif"), panelDolny);
        textAreaMap.get("AUD").dodajWalutaDoPanelu(panelDolny);

        addLabel("SEK",  new ImageIcon(path+"\\Images\\SEK.gif"), panelDolny);
        textAreaMap.get("SEK").dodajWalutaDoPanelu(panelDolny);

        addLabel("NOK",  new ImageIcon(path+"\\Images\\NOK.gif"), panelDolny);
        textAreaMap.get("NOK").dodajWalutaDoPanelu(panelDolny);

        addLabel("DKK",  new ImageIcon(path+"\\Images\\DKK.gif"), panelDolny);
        textAreaMap.get("DKK").dodajWalutaDoPanelu(panelDolny);

        addLabel("CHF",  new ImageIcon(path+"\\Images\\CHF.gif"), panelDolny);
        textAreaMap.get("CHF").dodajWalutaDoPanelu(panelDolny);

        addLabel("CZK",  new ImageIcon(path+"\\Images\\CZK.gif"), panelDolny);
        textAreaMap.get("CZK").dodajWalutaDoPanelu(panelDolny);

        addLabel("HUF",  new ImageIcon(path+"\\Images\\HUF.gif"), panelDolny);
        textAreaMap.get("HUF").dodajWalutaDoPanelu(panelDolny);

        add(panelDolny, BorderLayout.CENTER);

    }

    public static void addButton(String name, ActionListener listener, JPanel panel)
    {
        JButton button = new JButton(name);
        button.addActionListener(listener);
        panel.add(button);
    }

    public static void addLabel(String name, Icon icon, JPanel panel)
    {
        JLabel label = new JLabel(name, icon, SwingConstants.CENTER);
        panel.add(label);
    }

    private class ActionChooser implements ActionListener
    {
        private String skrotWaluty;
        private String typTranzakcji;

        public ActionChooser(String c, String t)
        {
            skrotWaluty = c;
            typTranzakcji = t;
        }

        @Override
        public void actionPerformed(ActionEvent event)
        {
            if(dialog == null)
                dialog = new HandlowyDialogPanel(walutaWczytana,mapa);
            dialog.setWaluta(skrotWaluty);
            dialog.setTransactionType(typTranzakcji);


            if(dialog.showDialog(KantorPodstawowyPanel.this, "Tranzakcja"))
            {
                String skrot = dialog.getSelectedWaluta();
                textAreaMap.get(skrot).setTextWszystkieArea(String.valueOf(mapa.getWaluta(skrot).getIloscWaluty()),
                        String.valueOf(mapa.getWaluta(skrot).getIloscNaZlotowki()),
                        String.valueOf(mapa.getWaluta(skrot).getSredniKurs()),
                        String.valueOf(mapa.getWaluta(skrot).getZyskNaWalucie()));
            }
        }

    }





}

