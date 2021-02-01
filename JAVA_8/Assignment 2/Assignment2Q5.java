class Rectangle5 extends Shape5 {
    @Override
    public String draw() {
        System.out.println("drawing rectangle5");
        return null;
    }
}
class Line5 extends Shape5{
    @Override
    public String draw() {
        System.out.println("drawing line5");
        return null;
    }
}
class Cube5 extends Shape5 {
    @Override
    public String draw() {
        System.out.println("drawing cube5");
        return null;
    }
}
abstract class Shape5 {
    abstract public String draw();
}
public class Assignment2Q5{
    public static void main(String[] args) {
        Shape5 rec = new Rectangle5();
        rec.draw();
        Shape5 line = new Line5();
        line.draw();
        Shape5 cube = new Cube5();
        cube.draw();
    }
}