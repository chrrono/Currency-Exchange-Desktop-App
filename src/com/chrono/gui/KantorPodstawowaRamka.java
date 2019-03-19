package com.chrono.gui;

import com.chrono.model.waluty.MapaWalutKursow;

import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;

public class KantorPodstawowaRamka extends JFrame
{
    public KantorPodstawowaRamka()
    {
        setTitle("Money Exchange");
        KantorPodstawowyPanel panel = new KantorPodstawowyPanel();
        add(panel);
        String path="";
        try {
            path = new File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(path);
        pack();
    }

}