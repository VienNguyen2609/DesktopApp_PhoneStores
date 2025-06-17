
package Forms.Components;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author VIEN
 */


public class HeaderButton extends JButton {

    private Color backgroundColor = new Color(204, 255, 204); // Màu mặc định

    private RippleEffect rippleEffect;  // Đối tượng tạo hiệu ứng sóng khi click 

    public HeaderButton(String text) {
        super(text); // gọi constructor của JButton với text 
        init();
    }

    public HeaderButton() {
        init();
    }

    private void init() {
        rippleEffect = new RippleEffect(this);
        setContentAreaFilled(false);   // Tắt vẽ nền mặc định của JButton 
        setCursor(new Cursor(Cursor.HAND_CURSOR)); // đổi chuột thành bàn tay 
        putClientProperty(FlatClientProperties.STYLE, "" + "font:bold +3"); // to hơn 3 cở 
        setFocusPainted(false); // Tắt viền focus khi button được chọn 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create(); // tạo 1 bản lưu graphics để tránh hưởng đến các thao tác khác 
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ nền với bo góc
        int arc = UIScale.scale(20);
        g2.setColor(backgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);

        // Vẽ hiệu ứng ripple
        rippleEffect.reder(g2, new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));

        g2.dispose();// Giải phóng Graphics2
        
        // Gọi super để vẽ text & icon
        super.paintComponent(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int arc = UIScale.scale(20);
        // Vẽ lại ripple effect lên trên cùng
        rippleEffect.reder(g, new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint(); // cập nhật lại giao diện khi đổi màu
    }
}

