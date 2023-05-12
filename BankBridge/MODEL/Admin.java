package MODEL;

public class Admin extends User {
    public Admin(int ID, String login, String MDP, String nom, String prenom, String adr, long tel, String email, String type) {
        super(ID, login, MDP, nom, prenom, adr, tel, email, type);
    }

    public Admin() {
        super();
    }
}