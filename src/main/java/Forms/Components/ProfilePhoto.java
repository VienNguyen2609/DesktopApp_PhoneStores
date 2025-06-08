
package Forms.Components;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author VIEN
 */

public class ProfilePhoto extends JComponent {

    private Icon icon;
    private int borderSize;

    public Icon getIcon() {
        return icon;
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }

    public ProfilePhoto() {
        setPreferredSize(new Dimension(50, 50));
        setBorderSize(3);
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Tạo clip tròn
        Ellipse2D circle = new Ellipse2D.Double(x, y, diameter, diameter);

        // Nếu có ảnh thì vẽ ảnh trong clip tròn
        if (icon != null && icon instanceof ImageIcon) {
            g2d.setClip(circle);
            g2d.drawImage(((ImageIcon) icon).getImage(), x, y, diameter, diameter, this);
            g2d.setClip(null); // reset clip để vẽ viền bên ngoài
        }

        // Vẽ border màu vàng
        g2d.setColor(Color.YELLOW);
        g2d.setStroke(new java.awt.BasicStroke(borderSize));
        g2d.draw(circle);
        
        g2d.dispose();
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
       repaint();  // Thêm dòng này để cập nhật lại giao diện khi gán ảnh
    }
}

