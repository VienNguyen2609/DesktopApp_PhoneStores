
package Forms.Components;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.Border;

// class chưa sử dụng , có thể xóa bỏ 
public class RoundedBorder implements Border {

    private int radius; //độ cong của góc

    public RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius +2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(x, y, width - 1, height - 1, radius, radius);
        g2d.draw(roundedRectangle);
        
    }
}

