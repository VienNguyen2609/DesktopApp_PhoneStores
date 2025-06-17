package Forms.Components;

import Forms.CreateAccount;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author VIEN
 */
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

    public void removePlaceHolderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN | Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.WHITE);
    }

    public void addPlaceHolderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.WHITE);
    }

    public void focusPointer(JTextField textField, JComponent componentToColor,
            JLabel animationLabel, Color colorFirst, Color colorLast) {
        
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
