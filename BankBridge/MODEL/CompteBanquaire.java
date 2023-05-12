package MODEL;

import java.util.Random;

public class CompteBanquaire {
    protected String RIB;
    protected String TypeCompte;
    protected double Solde;
    protected int Prop;
    protected int idBank;

    public CompteBanquaire(String RIB, double solde, int prop, String Type, int idBank) {
        this.TypeCompte = Type;
        this.RIB = RIB;
        this.Solde = solde;
        this.Prop = prop;
        this.idBank = idBank;
    }
    public CompteBanquaire(Bank ban, int prop, String Type) {
        this.TypeCompte = Type;
        this.RIB = generateRIB(ban);
        this.idBank = ban.getIDBank();
        this.Solde = 0;
        this.Prop = prop;
    }

    public CompteBanquaire() {}

    public String getRIB() {
        return RIB;
    }

    public String getTypeCompte() {
        return TypeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        TypeCompte = typeCompte;
    }

    public void setRIB(String RIB) {
        this.RIB = RIB;
    }

    public double getSolde() {
        return Solde;
    }

    public void setSolde(double solde) {
        Solde = solde;
    }

    public int getProp() {
        return Prop;
    }

    public void setProp(int prop) {
        Prop = prop;
    }

    public int getIdBank() {
        return idBank;
    }

    public void setIdBank(int idBank) {
        this.idBank = idBank;
    }

    public String generateRIB(Bank ban) {
        String bin = String.valueOf(ban.getIDBank());
        int length = ban.getLenRIB();
        Random random = new Random(System.currentTimeMillis());
        int randomNumberLength = length - (bin.length() + 1);

        StringBuilder builder = new StringBuilder(bin);
        for (int i = 0; i < randomNumberLength; i++) {
            int digit = random.nextInt(10);
            builder.append(digit);
        }
        int checkDigit = this.getCheckDigit(builder.toString());
        builder.append(checkDigit);
        return builder.toString();
    }
    private int getCheckDigit(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {

            // Get the digit at the current position.
            int digit = Integer.parseInt(number.substring(i, (i + 1)));

            if ((i % 2) == 0) {
                digit = digit * 2;
                if (digit > 9) {
                    digit = (digit / 10) + (digit % 10);
                }
            }
            sum += digit;
        }
        int mod = sum % 10;
        return ((mod == 0) ? 0 : 10 - mod);
    }
}