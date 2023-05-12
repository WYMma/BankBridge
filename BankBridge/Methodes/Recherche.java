package Methodes;

import CONTROLLER.BanquierController;
import Methodes.textfield.TextFieldSearchOption;
import CONTROLLER.AdminController;

public class Recherche {
    public static void RechercheBanquaireKeyReleased(TextFieldSearchOption txt) {//GEN-FIRST:event_txtKeyReleased
        if (txt.isSelected()) {
            int option = txt.getSelectedIndex();
            String text = "%" + txt.getText().trim() + "%";
            if (option == 0) {
                AdminController.loadBank("WHERE RIB LIKE ?", text);
            }
            if (option == 1) {
                AdminController.loadBank("WHERE CONCAT(user.Nom, ' ' ,user.Prenom) LIKE ?", text);
            }
            if (option == 2) {
                AdminController.loadBank("WHERE comptebanquaire.Type LIKE ?", text);
            }
        }
    }
    public static void RechercheBanquierKeyReleased(TextFieldSearchOption txt) {//GEN-FIRST:event_txtKeyReleased
        if (txt.isSelected()) {
            int option = txt.getSelectedIndex();
            String text = "%" + txt.getText().trim() + "%";
            if (option == 0) {
                BanquierController.loadData("WHERE RIB LIKE ?", text);
            }
            if (option == 1) {
                BanquierController.loadData("WHERE CONCAT(user.Nom, ' ' ,user.Prenom) LIKE ?", text);
            }
            if (option == 2) {
                BanquierController.loadData("WHERE comptebanquaire.Type LIKE ?", text);
            }
        }
    }
    public static void RechercheUserKeyReleased(TextFieldSearchOption txt) {//GEN-FIRST:event_txtKeyReleased
        if (txt.isSelected()) {
            int option = txt.getSelectedIndex();
            String text = "%" + txt.getText().trim() + "%";
            if (option == 0) {
                AdminController.loadUser("WHERE Login LIKE ?", text);
            }
            if (option == 1) {
                AdminController.loadUser("WHERE CONCAT(Nom, ' ' ,Prenom) LIKE ?", text);
            }
            if (option == 2) {
                AdminController.loadUser("WHERE Adr LIKE ?", text);
            }
            if (option == 3) {
                AdminController.loadUser("WHERE Tel LIKE ?", text);
            }
            if (option == 4) {
                AdminController.loadUser("WHERE Email LIKE ?", text);
            }
            if (option == 5) {
                AdminController.loadUser("WHERE Type LIKE ?", text);
            }
        }
    }
}
