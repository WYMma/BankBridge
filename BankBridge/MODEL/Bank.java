package MODEL;

public class Bank {
    protected int IDBank;
    protected int LenRIB;

    protected String nomBank;

    public int getIDBank() {
        return IDBank;
    }

    public void setIDBank(int IDBank) {
        this.IDBank = IDBank;
    }

    public int getLenRIB() {
        return LenRIB;
    }

    public void setLenRIB(int lenRIB) {
        LenRIB = lenRIB;
    }

    public String getNomBank() {
        return nomBank;
    }

    public void setNomBank(String nomBank) {
        this.nomBank = nomBank;
    }

    public Bank(int IDBank, int lenRIB, String nomBank) {
        this.IDBank = IDBank;
        LenRIB = lenRIB;
        this.nomBank = nomBank;
    }

    public Bank() {
    }
}