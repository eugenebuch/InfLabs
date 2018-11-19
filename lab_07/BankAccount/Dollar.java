package BankAccount;

public class Dollar extends AccHolder {
    private int number, limit=1000, forNow;
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
        System.out.format("\nФИО владельца: %s\nВалюта счёта: доллар\nНомер счёта: %s\nСейчас на счету: %d$/%d$\n",
            getFullname(), getNumber(), getForNow(), limit);
    }
}
