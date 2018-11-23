package gift;

abstract class Gift {
    public abstract void buy();
    public abstract void give(String name);
}

class Postcard extends Gift {
    private String wish;
    public void writeWish(String wish) {
        this.wish = wish;
    }
    public String getWish() {
        return wish;
    }
    @Override
    public void buy() {
        System.out.println("Подарок " + getWish() + " был куплен");
    }
    @Override
    public void give(String name){
        System.out.println(getWish() + " подарен " + name);
    }
}

class Painting extends Gift {
    private String title, author;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    @Override
    public void buy() {
        System.out.println("\nКартина "+getTitle()+" автора " + getAuthor() + " была куплена");
    }
    @Override
    public void give(String name) {
        System.out.println("Картина "+getTitle()+" автора " + getAuthor() + " была подарена " + name);
    }
}