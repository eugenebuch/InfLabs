package ship;

public class ShipTest {
    public static void main(String[] args) {
        Ship ship = new Ship();
        ship.updateShipInfo("Ordinary ship");
        ship.updateShipInfo("More then ordinary ship", "Vasyan");
        ship.updateShipInfo("One of the best ships", "neVasyan", 282);
        ship.updateShipInfo("The best ship ever", "MoreThanVasyan", 3137, 'A');
    }
}
