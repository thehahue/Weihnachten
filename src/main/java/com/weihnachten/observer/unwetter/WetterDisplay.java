package com.weihnachten.observer.unwetter;

import javax.swing.*;
import java.awt.*;

public class WetterDisplay extends JFrame implements WetterObserver {
    private Unwetterstatus currentStatus;
    private WetterPanel panel;

    public WetterDisplay() {
        setTitle("Wetter Station Observer");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new WetterPanel();
        add(panel);

        setVisible(true);
    }

    @Override
    public void update(Unwetterstatus status) {
        this.currentStatus = status;
        panel.repaint();
    }

    private class WetterPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (currentStatus == null)
                return;

            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();
            int barHeight = 40;
            int gap = 20;
            int startY = 30;

            // Hintergrund
            g2.setColor(currentStatus.isUnwetter() ? new Color(50, 0, 0) : Color.DARK_GRAY);
            g2.fillRect(0, 0, width, height);

            // Titel
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 18));
            String title = currentStatus.isUnwetter() ? "ACHTUNG: UNWETTERWARNUNG!" : "Wetterlage Normal";
            g2.drawString(title, 20, startY);

            // Werte zeichnen
            startY += 40;
            drawBar(g2, "Temperatur (°C)", currentStatus.getTemperatur(), -20, 50, Color.ORANGE, 20, startY, width - 40,
                    barHeight);

            startY += barHeight + gap;
            drawBar(g2, "Wind (km/h)", currentStatus.getWindgeschwindigkeit(), 0, 150, Color.CYAN, 20, startY,
                    width - 40, barHeight);

            startY += barHeight + gap;
            drawBar(g2, "Niederschlag (mm)", currentStatus.getNiederschlag(), 0, 100, Color.BLUE, 20, startY,
                    width - 40, barHeight);

            startY += barHeight + gap;
            // Luftdruck ist meist zwischen 950 und 1050
            drawBar(g2, "Luftdruck (hPa)", currentStatus.getLuftdruck(), 950, 1050, Color.GREEN, 20, startY, width - 40,
                    barHeight);
        }

        private void drawBar(Graphics2D g2, String label, double value, double min, double max, Color c, int x, int y,
                int w, int h) {
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 12));
            g2.drawString(String.format("%-20s: %.1f", label, value), x, y - 5);

            // Rahmen
            g2.setColor(Color.LIGHT_GRAY);
            g2.drawRect(x, y, w, h);

            // Füllung berechnen
            double range = max - min;
            double normalized = (value - min) / range;
            if (normalized < 0)
                normalized = 0;
            if (normalized > 1)
                normalized = 1;

            int filledWidth = (int) (w * normalized);
            g2.setColor(c);
            g2.fillRect(x + 1, y + 1, filledWidth, h - 1);
        }
    }
}
