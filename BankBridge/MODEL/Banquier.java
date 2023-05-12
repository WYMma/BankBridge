package MODEL;

/**
 * 
 */
public class Banquier extends User {
    public Banquier(int ID, String login, String MDP, String nom, String prenom, String adr, long tel, String email, String type) {
        super(ID, login, MDP, nom, prenom, adr, tel, email, type);
    }
    public Banquier() {
        super();
    }
}