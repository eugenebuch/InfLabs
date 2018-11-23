package Computer;

class Mouse implements Input {
    @Override
    public void setInput(String input) {
        System.out.println("С помощью мыши было введено следующее значение: " + input);
    }
    public void Ops() {
        System.out.println("Случайно дёрнув мышью вы почти закрываете вашу курсовую работу без сохранения! Благо, обошлось...\n");
    }
}

class Keyboard implements Input {
    @Override
    public void setInput(String input) {
        System.out.println("С помощью клавиатуры было введено следующее значение: " + input);
    }
    public void change() {System.out.println("Меняем раскладку...\n");}
}

class Printer implements Output {
    @Override
    public void output(String input) {
        System.out.println("Вы распечатали на листе А4 следующее: " + input);
    }
    public void color() {
        System.out.println("Включён чёрно-белый режим печати\n");
    }
}

class Monitor implements Output {
    @Override
    public void output(String input) {
        System.out.println("На мониторе появилось сообщение: " + input);
    }
    public void TurnOn() {
        System.out.println("Вы включили монитор\n");
    }
}

class MainMemory implements memory {
    @Override
    public void remind(String input) {
        System.out.println("Вы скопировали следующее сообщение: " + input + ". Оно попало в оперативную память компьютера");
    }
    public void clear() { System.out.println("Оперативная память компьютера успешно очищена!\n");}
}

class HardDisk implements memory {
    @Override
    public void remind(String input) {
        System.out.println("На винчестере сохранена следующая информация: " + input);
    }
    public void Defrag() { System.out.println("Экстренная дефрагментация диска произойдет через 1 час\n");}
}

class CP implements core {
    private int chisl1, chisl2;
    @Override
    public void got(int chisl1, int chisl2) {
        this.chisl1 = chisl1;
        this.chisl2 = chisl2;
        System.out.println("В ЦП поступили следующие данные: " + chisl1 + " " + chisl2);
    }
    public void count() {
        System.out.println("Недолго думая, ЦП быстро суммировал эти данные: " + (chisl1 + chisl2));
    }
}

class Shina implements core {
    @Override
    public void got(int chisl1, int chisl2) {
        System.out.println("В связывающую шину попало следующее: " + chisl1 + " " + chisl2);
    }
    public void got() {
        System.out.println("Данная информация передаётся в ЦП...\n" );
    }
}