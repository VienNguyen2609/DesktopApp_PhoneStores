
package Forms.Components;


import com.formdev.flatlaf.util.Animator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VIEN
 */

public class RippleEffect {

    private final Component component; //Thành phần Swing như button, panel, muốn gắn hiệu ứng ripple vào.
    private Color rippleColor = new Color(0, 0, 0); // màu hiệu ứng sóng là đen 
    private List<Effect> effects;// là danh sách nhiều hiệu ứng khi nhấn nhiều lần 
     
    public Color getBackgroundColor() {
        return rippleColor;
    }

    public void setBackgroundColor(Color rippleColor) {
        this.rippleColor = rippleColor;
       
    } 
    
    public RippleEffect(Component component) {
        this.component = component;
        init();
    }

    private void init() {
        effects = new ArrayList<>();
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    addEffect(e.getPoint()); //Khởi tạo danh sách hiệu ứng và thêm MouseListener.
                }
            }
        });
    }

    public void addEffect(Point location) {
        effects.add(new Effect(component, location)); // Tạo một đối tượng Effect mới rồi thêm vào danh sách để được vẽ.
    }

    public void reder(Graphics g, Shape contain) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < effects.size(); i++) {
            Effect effect = effects.get(i);
            if (effect != null) {
                effect.render(g2, contain);
            }
        }
    }

    private class Effect { // lớp nội Effect , Class này mô phỏng một lần sóng ripple duy nhất.

        private final Component component;
        private final Point location;
        private Animator animator;
        private float animate;

        public Effect(Component component, Point location) {
            this.component = component;
            this.location = location;
            init();
        }

        private void init() {
            animator = new Animator(500, new Animator.TimingTarget() {
                @Override
                public void timingEvent(float fraction) {
                    animate = fraction;
                    component.repaint(); // cập nhật animate theo thời gian gọi repaint() để vẽ lại.
                }

                @Override
                public void end() {
                    effects.remove(Effect.this); // xóa bỏ ripple khỏi danh sách 
                }
            });
            animator.start();
        }

        public void render(Graphics2D g2, Shape contain) {
            Area area = new Area(contain);
            area.intersect(new Area(getShape(getSize(contain.getBounds2D()))));
             //Vẽ hình tròn mờ dần theo thời gian. 
            g2.setColor(rippleColor);
            float alpha = 0.3f; 
            // độ mờ giãm dần khi dần tới 1 
            if (animate >= 0.7f) {
                double t = animate - 0.7f;
                alpha = (float) (alpha - (alpha * (t / 0.3f)));
            }
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha * 0.5f));
            g2.fill(area);
        }

        private Shape getShape(double size) {
            double s = size * animate;
            double x = location.getX();
            double y = location.getY();
            Shape shape = new Ellipse2D.Double(x - s, y - s, s * 2, s * 2);
            return shape;
        }

        private double getSize(Rectangle2D rec) {
            double size;
            if (rec.getWidth() > rec.getHeight()) {
                if (location.getX() < rec.getWidth() / 2) {
                    size = rec.getWidth() - location.getX();
                } else {
                    size = location.getX();
                }
            } else {
                if (location.getY() < rec.getHeight() / 2) {
                    size = rec.getHeight() - location.getY();
                } else {
                    size = location.getY();
                }
            }
            return size + (size * 0.1f);
        }
    }

    public void setRippleColor(Color rippleColor) {
        this.rippleColor = rippleColor;
    }

    public Color getRippleColor() {
        return rippleColor;
    }
}
