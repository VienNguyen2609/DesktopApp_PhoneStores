package Forms.Components;

/**
 *
 * @author VIEN
 */
import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {

    private int radius;
    private Color color;

    public RoundedPanel(int radius, Color color) {
        this.radius = radius;
        this.color = color;
        setOpaque(false); // Không vẽ nền vuông
        setBorder(new RoundedBorder(radius, color)); // Thêm viền đã bo tròn
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        g2.dispose();
        super.paintComponent(g);
    }
}
