package MODEL;

import java.util.ArrayList;

public class Client extends User {
    protected ArrayList<CompteBanquaire> Compte = new ArrayList<>();

    public Client(int ID, String login, String MDP, String nom, String prenom, String adr, long tel, String email, String type, ArrayList<CompteBanquaire> compte) {
        super(ID, login, MDP, nom, prenom, adr, tel, email, type);
        Compte = compte;
    }

    public Client() {
        super();
    }

    public ArrayList<CompteBanquaire> getCompte() {
        return Compte;
    }

    public void setCompte(ArrayList<CompteBanquaire> compte) {
        Compte = compte;
    }
}