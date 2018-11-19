package ship;

public class Ship {
    private String title, CaptainName;
    private int port;
    char type;
    public void updateShipInfo(String title) {
        this.title = title;
        System.out.format("\nНазвание судна: %s\nКапитан: Не назначен\nПорт: Не задан\nТип: 'Неопределён'\n" , this.title);
    }
    public void updateShipInfo(String title, String CaptainName) {
        this.title = title;
        this.CaptainName = CaptainName;
        System.out.format("\nНазвание судна: %s\nКапитан: %s\nПорт: Не задан\nТип: 'Неопределён'\n" , this.title,
                this.CaptainName);
    }
    public void updateShipInfo(String title, String CaptainName, int port) {
        this.title = title;
        this.CaptainName = CaptainName;
        this.port = port;
        System.out.format("\nНазвание судна: %s\nКапитан: %s\nПорт: %d\nТип: 'Неопределён'\n" , this.title,
                this.CaptainName, this.port);
    }
    public void updateShipInfo(String title, String CaptainName, int port, char type) {
        this.title = title;
        this.CaptainName = CaptainName;
        this.port = port;
        this.type = type;
        System.out.format("\nНазвание судна: %s\nКапитан: %s\nПорт: %d\nТип: '%s'\n" , this.title,
                this.CaptainName, this.port, this.type);
    }
}
