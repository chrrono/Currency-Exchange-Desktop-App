package com.chrono.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Created by Matiaw47 on 2016-12-13.
 */
public class WalutaZbiorJTextArea {
    private JTextArea iloscArea;
    private JTextArea zlotowkiArea;
    private JTextArea kursArea;
    private JTextArea zyskArea;

    public WalutaZbiorJTextArea()
    {
        iloscArea = new JTextArea("0.0",1,20);
        zlotowkiArea = new JTextArea("0.0",1,20);
        kursArea = new JTextArea("0.0",1,20);
        zyskArea = new JTextArea("0.0",1,20);;
    }

    public void dodajWalutaDoPanelu(JPanel panel)
    {
        panel.add(iloscArea);
        panel.add(zlotowkiArea);
        panel.add(kursArea);
        panel.add(zyskArea);
    }

    public void setTextWszystkieArea(String iloscWaluta, String zlotowkiWaluta, String kursWaluta, String zyskWaluta)
    {
        this.iloscArea.setText(iloscWaluta);
        this.zlotowkiArea.setText(zlotowkiWaluta);
        this.kursArea.setText(kursWaluta);
        this.zyskArea.setText(zyskWaluta);
    }

}
