package SHPION;

public class Spy {
    private String realName;
    public String name;
    private int squad;
    private String getSpyInfo() {
        return String.format("His name is %s(but his real name is %s) and his squad is: %d", getSpyName(),
                getSpyRealName(), getSpySquad());
    }
    public void print() {
        System.out.println(getSpyInfo());
    }
    public void setSpyName(String name) {
        this.name = name;
    }
    public void setSpyRealName(String realName) {
        this.realName = realName;
    }
    public void setSpySquad(int squad) {
        this.squad = squad;
    }
    public String getSpyName() { return name; }
    public String getSpyRealName() { return realName; }
    public int getSpySquad() { return squad; }
}
