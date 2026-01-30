package com.weihnachten.strategy.demo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class StrategyDemoUI extends JFrame {

    private JTextField priceField;
    private JLabel resultLabel;
    private JTextArea descriptionArea;
    private ShopContext shopContext;
    private DecimalFormat df = new DecimalFormat("#.00 €");

    public StrategyDemoUI() {
        // Initialisierung des Contexts mit Standard-Strategie
        shopContext = new ShopContext(new StandardDiscount());

        setTitle("Weihnachts-Rabatt-Simulator (Strategy Pattern)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 450);
        setLocationRelativeTo(null);

        // Haupt-Panel mit Weihnachtsfarben
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(20, 60, 20)); // Dunkelgrün
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Header
        JLabel header = new JLabel("Weihnachts-Shop Strategien", SwingConstants.CENTER);
        header.setFont(new Font("Serif", Font.BOLD, 24));
        header.setForeground(new Color(212, 175, 55)); // Gold
        mainPanel.add(header, BorderLayout.NORTH);

        // Input und Auswahl Bereich
        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        centerPanel.setOpaque(false);

        // Preis-Eingabe
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.setOpaque(false);
        JLabel priceLabel = new JLabel("Basis Preis: ");
        priceLabel.setForeground(Color.WHITE);
        priceField = new JTextField("100.00", 10);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        centerPanel.add(inputPanel);

        // Strategie-Auswahl
        JPanel strategyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        strategyPanel.setOpaque(false);

        String[] strategies = { "Standard", "Advent", "Frühbucher", "Last Minute" };
        JComboBox<String> strategyBox = new JComboBox<>(strategies);
        strategyBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) strategyBox.getSelectedItem();
                switch (selected) {
                    case "Standard":
                        shopContext.setStrategy(new StandardDiscount());
                        break;
                    case "Advent":
                        shopContext.setStrategy(new AdventDiscount());
                        break;
                    case "Frühbucher":
                        shopContext.setStrategy(new EarlyBirdDiscount());
                        break;
                    case "Last Minute":
                        shopContext.setStrategy(new LastMinuteSurcharge());
                        break;
                }
                updateUIContent();
            }
        });
        strategyPanel.add(new JLabel("Aktion wählen: "));
        strategyPanel.add(strategyBox);
        centerPanel.add(strategyPanel);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Ergebnis Bereich
        JPanel footerPanel = new JPanel(new BorderLayout(10, 10));
        footerPanel.setBackground(new Color(150, 0, 0)); // Weihnachtsrot
        footerPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        descriptionArea = new JTextArea(2, 20);
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setBackground(new Color(150, 0, 0));
        descriptionArea.setForeground(Color.WHITE);
        descriptionArea.setFont(new Font("SansSerif", Font.ITALIC, 14));

        resultLabel = new JLabel("Endpreis: - ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        resultLabel.setForeground(Color.WHITE);

        footerPanel.add(descriptionArea, BorderLayout.NORTH);
        footerPanel.add(resultLabel, BorderLayout.SOUTH);

        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        // Berechnen Button (optional, da wir bei Auswahl aktualisieren, aber gut für
        // den Preis-Input)
        JButton calcButton = new JButton("Berechnen");
        calcButton.addActionListener(e -> updateUIContent());
        inputPanel.add(calcButton);

        add(mainPanel);
        updateUIContent();
    }

    private void updateUIContent() {
        try {
            double basePrice = Double.parseDouble(priceField.getText().replace(",", "."));
            double finalPrice = shopContext.calculateFinalPrice(basePrice);
            resultLabel.setText("Endpreis: " + df.format(finalPrice));
            descriptionArea.setText(shopContext.getStrategyDescription());
        } catch (NumberFormatException ex) {
            resultLabel.setText("Ungültiger Preis!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StrategyDemoUI().setVisible(true);
        });
    }
}
