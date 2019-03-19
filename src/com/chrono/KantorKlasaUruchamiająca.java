package com.chrono;

import com.chrono.gui.KantorPodstawowaRamka;

import javax.swing.*;

/**
 * Created by Matiaw47 on 2017-01-06.
 */
public class KantorKlasaUruchamiająca {
    public static void main(String[] args) {

        KantorPodstawowaRamka frame = new KantorPodstawowaRamka();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setVisible(true);

    }
}
