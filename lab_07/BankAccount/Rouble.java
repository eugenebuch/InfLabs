package BankAccount;

public class Rouble extends AccHolder {
    private int number, limit=70000, forNow;
    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public void setForNow(int forNow) {
        this.forNow = forNow;
    }
    public int getForNow() {
        return forNow;
    }
    public void getFullAccInfo(){
        System.out.format("\nФИО владельца: %s\nВалюта счёта: рубль\nНомер счёта: %s\nСейчас на счету: %drub/%drub\n",
                getFullname(), getNumber(), getForNow(), limit);
    }
}
