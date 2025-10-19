package Main;

import Forms.Components.SetThemFlatLaf;
import Forms.Components.ThemeFlatLaf;
import Forms.Login;

import java.net.http.HttpClient;

/**
 *
 * @author VIEN
 */

public class Run {

    public static void main(String[] args) {
        runApp();
    }

    public static void runApp() {
        SetThemFlatLaf.setThem(ThemeFlatLaf.Light);
        new Login().setVisible(true);
    }
}
    