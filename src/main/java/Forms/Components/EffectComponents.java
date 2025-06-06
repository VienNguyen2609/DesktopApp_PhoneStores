package Forms.Components;

import Forms.CreateAccount;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EffectComponents {

    private JTextField textField;
    private JLabel label;

    public static EffectComponents instance;
    private static boolean isInitiallized = false;

    public static void init() {
        if (isInitiallized == true) {
            return;
        }
        instance = new EffectComponents();
        isInitiallized = true;

    }

    public static BufferedImage makeTransparent(BufferedImage img, float alpha, JLabel label) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage transparentImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = transparentImage.createGraphics();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();
        label.setIcon(new ImageIcon(transparentImage));
        return transparentImage;
    }

    public void bufferedImage(String c, JLabel label, float alpha) throws IOException {
        BufferedImage image = ImageIO.read(new File(c));
        EffectComponents.instance.makeTransparent(image, alpha, label);
    }

    public void focusPointer(JTextField textField, JComponent componentToColor, JLabel animationLabel, Color colorFirst, Color colorLast) {
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                componentToColor.setForeground(colorFirst);
                if (animationLabel != null) {
                    animationComponents(animationLabel);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().length() != 0) {
                    componentToColor.setForeground(colorFirst);
                } else {
                    componentToColor.setForeground(colorLast);
                }
            }
        });
    }

    //animation components 
    public void animationComponents(JLabel label) {
        int targetWidth = label.getWidth();
        int height = label.getHeight();
        // Tính điểm trung tâm ban đầu
        int centerX = label.getX() + label.getWidth() / 2;
        int centerY = label.getY();

        new Thread(() -> {
            for (int i = 0; i <= targetWidth / 2; i++) {
                int newWidth = i * 2;
                int newX = centerX - i;

                label.setBounds(newX, centerY, newWidth, height);

                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CreateAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    public void scaleImage(JLabel LabelLogo, String c) {
        ImageIcon icon = new ImageIcon(getClass().getResource(c));
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(LabelLogo.getWidth(), LabelLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon acalledIcon = new ImageIcon(imgScale);
        LabelLogo.setIcon(acalledIcon);
    }

    //bắt lổi tiếng việt 
    public static boolean containsVietnameseCharacters(String text) {
        String vietnamesePattern = ".*[àáảãạăắằẳẵặâấầẩẫậèéẻẽẹêếềểễệìíỉĩịòóỏõọôốồổỗộơớờởỡợùúủũụưứừửữựỳýỷỹỵđ].*";
        return text.matches(vietnamesePattern);
    }
}
