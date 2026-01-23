package com.weihnachten.decorator.burger;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BurgerShop extends JFrame {
    private Burger currentBurger;
    private JLabel descriptionLabel;
    private JLabel priceLabel;
    private JLabel allergenLabel;
    private JPanel ingredientPanel;

    public BurgerShop() {
        setTitle("Premium Burger Shop");
        setSize(500, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        currentBurger = new BasicBurger();

        // Header
        JLabel title = new JLabel("Konfiguriere deinen Burger", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(title, BorderLayout.NORTH);

        // Center Panel for Ingredients
        ingredientPanel = new JPanel();
        ingredientPanel.setLayout(new GridLayout(0, 1));
        ingredientPanel.setBorder(BorderFactory.createTitledBorder("Zutaten Hinzufügen"));

        addIngredientButton("Fleisch Patty", () -> currentBurger = new MeatPatty(currentBurger));
        addIngredientButton("Veggie Patty", () -> currentBurger = new VeggiePatty(currentBurger));
        addIngredientButton("Käse", () -> currentBurger = new Cheese(currentBurger));
        addIngredientButton("Gurkerl", () -> currentBurger = new Pickles(currentBurger));
        addIngredientButton("Mayo", () -> currentBurger = new Mayo(currentBurger));
        addIngredientButton("Bacon", () -> currentBurger = new Bacon(currentBurger));

        JButton resetBtn = new JButton("Reset (Nur Brötchen)");
        resetBtn.setBackground(new Color(255, 200, 200));
        resetBtn.addActionListener(e -> {
            currentBurger = new BasicBurger();
            updateDisplay();
        });
        ingredientPanel.add(resetBtn);

        add(new JScrollPane(ingredientPanel), BorderLayout.CENTER);

        // Footer for Status
        JPanel footer = new JPanel();
        footer.setLayout(new GridLayout(4, 1));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        footer.setBackground(new Color(240, 240, 240));

        descriptionLabel = new JLabel("<html><b>Dein Burger:</b> " + currentBurger.getDescription() + "</html>");
        allergenLabel = new JLabel("<html><b>Allergene:</b> " + currentBurger.getAllergens() + "</html>");
        allergenLabel.setForeground(Color.RED);
        priceLabel = new JLabel(
                "<html><b>Gesamtpreis:</b> " + String.format("%.2f", currentBurger.getPrice()) + " €</html>");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton orderBtn = new JButton("Bestellung Abschließen");
        orderBtn.setFont(new Font("Arial", Font.BOLD, 14));
        orderBtn.setBackground(new Color(200, 255, 200));
        orderBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Vielen Dank für deine Bestellung!\n\n" +
                            currentBurger.getDescription() + "\n" +
                            "Allergene: " + currentBurger.getAllergens() + "\n" +
                            "Preis: " + String.format("%.2f", currentBurger.getPrice()) + " €",
                    "Bestellung OK", JOptionPane.INFORMATION_MESSAGE);
            currentBurger = new BasicBurger();
            updateDisplay();
        });

        footer.add(descriptionLabel);
        footer.add(allergenLabel);
        footer.add(priceLabel);
        footer.add(orderBtn);

        add(footer, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addIngredientButton(String text, Runnable action) {
        JButton btn = new JButton(text);
        btn.addActionListener(e -> {
            action.run();
            updateDisplay();
        });
        ingredientPanel.add(btn);
    }

    private void updateDisplay() {
        descriptionLabel.setText("<html><b>Dein Burger:</b> " + currentBurger.getDescription() + "</html>");
        allergenLabel.setText("<html><b>Allergene:</b> " + currentBurger.getAllergens() + "</html>");
        priceLabel
                .setText("<html><b>Gesamtpreis:</b> " + String.format("%.2f", currentBurger.getPrice()) + " €</html>");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        SwingUtilities.invokeLater(BurgerShop::new);
    }
}
