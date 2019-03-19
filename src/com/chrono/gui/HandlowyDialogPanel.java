package com.chrono.gui;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import javax.swing.*;

import com.chrono.model.operacje.OperacjaFinansowa;
import com.chrono.model.waluty.*;


public class HandlowyDialogPanel extends JPanel
{

    private JComboBox<String> waluta;
    private JComboBox<String> transactionType;
    private String selectedWaluta;
    private JButton AcceptButton;
    private boolean ok;
    private JDialog dialog;
    private WalutaPrzetwarzanaZDialogu walutaWczytana;
    private MapaWalutKursow mapa;

    public HandlowyDialogPanel(WalutaPrzetwarzanaZDialogu walutaWczy, MapaWalutKursow map)
    {

        JPanel panel;
        JPanel northPanel;
        JPanel southPanel;
        JLabel amoutLabel;
        JTextField amoutField;
        JLabel kursLabel;
        JTextField kursField;
        JLabel zlLabel;
        JTextArea zlTextArea;
        JButton RejectButton;

        ButtonGroup ButtonBox;
        JLabel label;
        JButton button;

        this.walutaWczytana = walutaWczy;
        this.mapa = map;

        setLayout(new BorderLayout());

        panel = new JPanel();
        northPanel = new JPanel();
        southPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1,2));
        southPanel.setLayout(new GridLayout(1,2));

        waluta = new JComboBox<>();
        waluta.addItem("EUR");
        waluta.addItem("GBP");
        waluta.addItem("USD");
        waluta.addItem("CAD");
        waluta.addItem("AUD");
        waluta.addItem("SEK");
        waluta.addItem("NOK");
        waluta.addItem("DKK");
        waluta.addItem("CHF");
        waluta.addItem("CZK");
        waluta.addItem("HUF");

        transactionType = new JComboBox<>();
        transactionType.addItem("Zakup");
        transactionType.addItem("Sprzedaż");

        amoutLabel = new JLabel("Ilość waluty: ");
        amoutField = new JTextField("0.0", 20);
        kursLabel = new JLabel("Kurs transakcji: ");
        kursField = new JTextField("0.0", 10);
        zlLabel = new JLabel("Ilość złotówek: ");
        zlTextArea = new JTextArea("0.0",1,20);
        label = new JLabel();

        ButtonBox = new ButtonGroup();
        button = new JButton("Przelicz");
        ButtonBox.add(button);

        ActionListener calculate = new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent event)
            {
                zlTextArea.setText(OperacjaFinansowa.przeliczWaluteNaZlotowki(amoutField.getText(),kursField.getText()));
            }

        };

        button.addActionListener(calculate);


        AcceptButton = new JButton("Zatwierdź");
        RejectButton = new JButton("Odrzuć");


        northPanel.add(waluta);
        northPanel.add(transactionType);

        panel.setLayout(new GridLayout(4,2));
        panel.add(amoutLabel);
        panel.add(amoutField);
        panel.add(kursLabel);
        panel.add(kursField);
        panel.add(zlLabel);
        panel.add(zlTextArea);
        panel.add(label);
        panel.add(button);

        add(panel, BorderLayout.CENTER);
        southPanel.add(AcceptButton);
        southPanel.add(RejectButton);

        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);


        AcceptButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                walutaWczytana.setIloscWaluty(new BigDecimal(amoutField.getText()));
                walutaWczytana.setSkrotWaluty((String) waluta.getSelectedItem());
                walutaWczytana.setKursOperacji(new BigDecimal(kursField.getText()));
                walutaWczytana.setIloscNaZlotowki(new BigDecimal(zlTextArea.getText()));

                amoutField.setText("0.0");
                kursField.setText("0.0");
                zlTextArea.setText("0.0");


                boolean op = OperacjaFinansowa.Operacja(mapa, walutaWczytana, (String) transactionType.getSelectedItem());
                selectedWaluta = (String) waluta.getSelectedItem();
                ok = true;

                dialog.setVisible(false);
            }
        });

        RejectButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                dialog.setVisible(false);
            }
        });

    }


    public boolean showDialog(Component parent, String title)
    {
        ok = false;
        Frame owner = null;

        if(parent instanceof Frame)
            owner = (Frame) parent;
        else
            owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);

        if(dialog == null || dialog.getOwner() != owner)
        {
            dialog = new JDialog(owner, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(AcceptButton);
            dialog.setSize(400,400);
        }

        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }


    public void setWaluta (String w)
    {
        waluta.setSelectedItem(w);
    }

    public void setTransactionType (String t)
    {
        transactionType.setSelectedItem(t);
    }

    public String getSelectedWaluta() {
        return selectedWaluta;
    }
}