
package Forms;

import Forms.Components.SetThemFlatLaf;
import Forms.Components.ThemeFlatLaf;
import Model.Staff;


public class TestHome {
     public static void main(String[] args) {
        SetThemFlatLaf.setThem(ThemeFlatLaf.Dark);
        Staff staff = new Staff("admin", "admin", "admin.gmail.com" , "admin" , null);
        new HomePage(staff).setVisible(true);
    }
}
