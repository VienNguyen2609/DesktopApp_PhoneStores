
package Forms;

import Forms.Components.SetThemFlatLaf;
import Forms.Components.ThemeFlatLaf;
import Model.Phone;


public class TestHome {
     public static void main(String[] args) {
        SetThemFlatLaf.setThem(ThemeFlatLaf.Dark);
        //Account account = new Account("admin", "admin", "admin@gmail.com");
        new HomePage().setVisible(true);
    }
}
