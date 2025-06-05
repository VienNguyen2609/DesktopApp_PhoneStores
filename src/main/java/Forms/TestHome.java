
package Forms;

import Forms.Components.SetThemFlatLaf;
import Forms.Components.ThemeFlatLaf;
import Model.Staff;



public class TestHome {
     public static void main(String[] args) {
        SetThemFlatLaf.setThem(ThemeFlatLaf.Dark);
        Staff account = new Staff("admin", "admin", "admin.gmail.com");
        new HomePage(account).setVisible(true);
    }
}
