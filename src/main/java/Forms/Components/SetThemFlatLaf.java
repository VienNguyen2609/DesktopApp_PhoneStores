
package Forms.Components;

import static Forms.Components.ThemeFlatLaf.Dark;
import static Forms.Components.ThemeFlatLaf.Light;
import static Forms.Components.ThemeFlatLaf.MacDark;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author VIEN
 */

public final class SetThemFlatLaf {

    public static void setThem(ThemeFlatLaf themeFlatLaf) {
        try {

            LookAndFeel lookAndFeel;
            lookAndFeel = switch (themeFlatLaf) {
                case Light ->
                    new FlatLightLaf();
                case Dark ->
                    new FlatDarkLaf();
                case INTELLIJ ->
                    new FlatIntelliJLaf();
                case MacDark ->
                    new FlatMacDarkLaf();
                case MacLight ->
                    new FlatMacLightLaf();
                case DarkCula ->
                    new FlatDarculaLaf();
            };
            
            UIManager.setLookAndFeel(lookAndFeel);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

