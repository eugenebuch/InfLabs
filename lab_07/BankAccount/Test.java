package BankAccount;

public class Test {
    public static void main(String[] args) {
        Rouble score1 = new Rouble();
        score1.setForNow(51243);
        score1.setNumber(1112356432);
        score1.getFullAccInfo();
        Dollar score2 = new Dollar();
        score2.setForNow(322);
        score2.setNumber(1324154536);
        score2.getFullAccInfo();
    }
}
