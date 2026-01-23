package com.weihnachten.decorator.burger;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BurgerShop extends JFrame {
    private Burger currentBurger;
    private JLabel descriptionLabel;
    private JLabel priceLabel;
    private JLabel allergenLabel;
    private JPanel ingredientPanel;
    private BurgerVisualizer visualizer;

    public BurgerShop() {
        setTitle("Premium Burger Shop - Design your own");
        setSize(900, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        currentBurger = new BasicBurger();

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(44, 62, 80));
        JLabel title = new JLabel("Burger Konfigurator", SwingConstants.CENTER);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        header.add(title, BorderLayout.CENTER);
        add(header, BorderLayout.NORTH);

        // Visualizer (West)
        visualizer = new BurgerVisualizer();
        add(visualizer, BorderLayout.WEST);

        // Center Panel for Ingredients
        ingredientPanel = new JPanel();
        ingredientPanel.setLayout(new GridLayout(0, 1, 10, 10));
        ingredientPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        ingredientPanel.setBackground(Color.WHITE);

        JPanel scrollContent = new JPanel(new BorderLayout());
        scrollContent.add(ingredientPanel, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(scrollContent);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Zutaten Wählen"));
        add(scrollPane, BorderLayout.CENTER);

        addIngredientButton("Beef Patty (+2,50€)", () -> currentBurger = new MeatPatty(currentBurger));
        addIngredientButton("Veggie Patty (+2,20€)", () -> currentBurger = new VeggiePatty(currentBurger));
        addIngredientButton("Extra Käse (+0,80€)", () -> currentBurger = new Cheese(currentBurger));
        addIngredientButton("Gurkerl (+0,40€)", () -> currentBurger = new Pickles(currentBurger));
        addIngredientButton("Mayo (+0,30€)", () -> currentBurger = new Mayo(currentBurger));
        addIngredientButton("Knusper Speck (+1,20€)", () -> currentBurger = new Bacon(currentBurger));

        JButton resetBtn = new JButton("Reset (Nur Brötchen)");
        resetBtn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        resetBtn.setBackground(new Color(231, 76, 60));
        resetBtn.setForeground(Color.WHITE);
        resetBtn.setFocusPainted(false);
        resetBtn.addActionListener(e -> {
            currentBurger = new BasicBurger();
            updateDisplay();
        });
        ingredientPanel.add(resetBtn);

        // Footer for Status
        JPanel footer = new JPanel();
        footer.setLayout(new GridLayout(4, 1, 5, 5));
        footer.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        footer.setBackground(new Color(236, 240, 241));

        descriptionLabel = new JLabel("<html><b>Zusammensetzung:</b> " + currentBurger.getDescription() + "</html>");
        descriptionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        allergenLabel = new JLabel("<html><b>Allergene:</b> " + currentBurger.getAllergens() + "</html>");
        allergenLabel.setForeground(new Color(192, 57, 43));
        allergenLabel.setFont(new Font("Segoe UI", Font.ITALIC, 13));

        priceLabel = new JLabel(
                "<html><b>Summe:</b> " + String.format("%.2f", currentBurger.getPrice()) + " €</html>");
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        priceLabel.setForeground(new Color(39, 174, 96));

        JButton orderBtn = new JButton("JETZT BESTELLEN");
        orderBtn.setFont(new Font("Segoe UI", Font.BOLD, 18));
        orderBtn.setBackground(new Color(46, 204, 113));
        orderBtn.setForeground(Color.WHITE);
        orderBtn.setFocusPainted(false);
        orderBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Bestellung erhalten!\n\n" +
                            currentBurger.getDescription() + "\n" +
                            "Preis: " + String.format("%.2f", currentBurger.getPrice()) + " €",
                    "Küche informiert", JOptionPane.INFORMATION_MESSAGE);
            currentBurger = new BasicBurger();
            updateDisplay();
        });

        footer.add(descriptionLabel);
        footer.add(allergenLabel);
        footer.add(priceLabel);
        footer.add(orderBtn);

        add(footer, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addIngredientButton(String text, Runnable action) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn.setBackground(new Color(52, 152, 219));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.addActionListener(e -> {
            action.run();
            updateDisplay();
        });
        ingredientPanel.add(btn);
    }

    private void updateDisplay() {
        descriptionLabel.setText("<html><b>Zusammensetzung:</b> " + currentBurger.getDescription() + "</html>");
        allergenLabel.setText("<html><b>Allergene:</b> " + currentBurger.getAllergens() + "</html>");
        priceLabel.setText("<html><b>Summe:</b> " + String.format("%.2f", currentBurger.getPrice()) + " €</html>");
        visualizer.repaint();
    }

    private class BurgerVisualizer extends JPanel {
        private Map<String, Image> imageCache = new HashMap<>();

        public BurgerVisualizer() {
            setPreferredSize(new Dimension(450, 500));
            setBackground(new Color(245, 245, 245));
            loadImages();
        }

        private void loadImages() {
            String[] components = { "bun_top", "bun_bottom", "meat_patty", "veggie_patty", "cheese", "pickles", "bacon",
                    "mayo" };
            for (String comp : components) {
                try {
                    // Try resources first
                    java.net.URL url = getClass().getResource("/images/burger/" + comp + ".png");
                    if (url != null) {
                        imageCache.put(comp, ImageIO.read(url));
                    } else {
                        // Hardcoded path for dev environment
                        File file = new File(
                                "/home/hahue/git/Weihnachten/src/main/resources/images/burger/" + comp + ".png");
                        if (file.exists()) {
                            imageCache.put(comp, ImageIO.read(file));
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Error loading image: " + comp);
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            java.util.List<String> layers = currentBurger.getImageLayers();

            int width = 300;
            int height = 150;
            int x = (getWidth() - width) / 2;
            int yStart = getHeight() - 200;
            int overlap = 60; // How much they overlap vertically

            for (int i = 0; i < layers.size(); i++) {
                String layer = layers.get(i);
                Image img = imageCache.get(layer);
                if (img != null) {
                    int drawY = yStart - (i * (height - overlap));

                    // Special offset for bun_top to make it look nicer
                    if (layer.equals("bun_top")) {
                        drawY -= 50;
                    }

                    g2d.drawImage(img, x, drawY, width, height, null);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // ignore
        }
        SwingUtilities.invokeLater(BurgerShop::new);
    }
}
