package util;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtils {

    public static byte[] iconToBytes(ImageIcon icon) {
        try {
            BufferedImage bufferedImage = new BufferedImage(
                    icon.getIconWidth(),
                    icon.getIconHeight(),
                    BufferedImage.TYPE_INT_ARGB);

            Graphics g = bufferedImage.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Có thể thêm hàm bytesToIcon nếu cần chuyển ngược
    public static ImageIcon bytesToIcon(byte[] data) {
        return new ImageIcon(data);
    }
}
