package MODEL;

public class User {
    protected int ID;
    protected String Login;
    protected String MDP;
    protected String Nom;
    protected String Prenom;
    protected String Adr;
    protected long Tel;
    protected String Email;

    protected String Type;

    public User(int ID, String login, String MDP, String nom, String prenom, String adr, long tel, String email, String type) {
        this.ID = ID;
        Login = login;
        this.MDP = MDP;
        Nom = nom;
        Prenom = prenom;
        Adr = adr;
        Tel = tel;
        Email = email;
        Type = type;
    }

    public User() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getMDP() {
        return MDP;
    }

    public void setMDP(String MDP) {
        this.MDP = MDP;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getAdr() {
        return Adr;
    }

    public void setAdr(String adr) {
        Adr = adr;
    }

    public long getTel() {
        return Tel;
    }

    public void setTel(long tel) {
        Tel = tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}