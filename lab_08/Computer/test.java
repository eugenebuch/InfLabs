package Computer;

public class test {
    public static void main(String[] args) {
        Shina shina = new Shina();
        CP cp = new CP();
        MainMemory mainmem= new MainMemory();
        HardDisk hard = new HardDisk();
        Mouse mouse = new Mouse();
        Keyboard klava = new Keyboard();
        Monitor monik = new Monitor();
        Printer print = new Printer();
        klava.change();
        klava.setInput("Hello World!");
        mouse.setInput("ABC");
        mouse.Ops();
        print.color();
        print.output("Back to WORK!");
        monik.TurnOn();
        monik.output("Best example of interfaces");
        mainmem.remind("I don't know what to say");
        mainmem.clear();
        hard.remind("Безымянный.png");
        hard.Defrag();
        shina.got(54, 324);
        shina.got();
        cp.got(54, 324);
        cp.count();
    }
}
