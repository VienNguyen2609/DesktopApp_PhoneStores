package Forms.Components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author VIEN
 */

public class TextFieldController extends JTextField {

    private Icon prefixIcon;
    private Icon suffixIcon;
    private Border customBorder;

    public Icon getPrefixIcon() {
        return prefixIcon;
    }

    public void setPrefixIcon(Icon prefixIcon) {
        this.prefixIcon = prefixIcon;
        initBorder();

    }

    @Override
    public void addNotify() {
        super.addNotify();
        applyDefaults();
    }

    private void applyDefaults() {
        setOpaque(false);
        setBackground(new java.awt.Color(0, 0, 0, 0));
    }

    public Icon getSuffixIcon() {
        return suffixIcon;
    }

    public void setSuffixIcon(Icon suffixIcon) {
        this.suffixIcon = suffixIcon;
        initBorder();
    }

    public TextFieldController() {
        super();
        applyDefaults();
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintIcon(g);
    }

    private void paintIcon(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (prefixIcon != null) {
            Image prefix = ((ImageIcon) prefixIcon).getImage();
            int y = (getHeight() - prefixIcon.getIconHeight()) / 2;
            g2.drawImage(prefix, 0, y, this);

        }
        if (suffixIcon != null) {
            Image suffix = ((ImageIcon) suffixIcon).getImage();
            int y = (getHeight() - suffixIcon.getIconHeight()) / 2;
            g2.drawImage(suffix, getWidth() - suffixIcon.getIconWidth(), y, this);
        }
    }

    private void initBorder() {
        int left = 5;
        int right = 5;

        if (prefixIcon != null) {
            left += prefixIcon.getIconWidth() + 4;  // +5 padding giữa icon và text
        }
        if (suffixIcon != null) {
            right += suffixIcon.getIconWidth() + 4;
        }

        Border iconPadding = BorderFactory.createEmptyBorder(4, left, 4, right);

        if (customBorder != null) {
            // Gộp custom border + padding icon
            setBorder(BorderFactory.createCompoundBorder(customBorder, iconPadding));
        } else {
            // Không có custom => chỉ padding icon
            setBorder(iconPadding);
        }
    }

    public Border getCustomBorder() {
        return customBorder;
    }

    public void setCustomBorder(Border customBorder) {
        this.customBorder = customBorder;
        initBorder(); // cập nhật lại border
    }

}
