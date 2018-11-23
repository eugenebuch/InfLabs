package gift;

public class GiftTest {
    public static void main(String[] args) {
        Postcard post = new Postcard();
        post.writeWish("Audi A8");
        post.buy();
        post.give("Anna");
        Painting paint = new Painting();
        paint.setAuthor("Michelangelo");
        paint.setTitle("Horrible court");
        paint.buy();
        paint.give("Anastasia");
    }
}
