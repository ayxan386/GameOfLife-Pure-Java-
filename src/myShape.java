import java.awt.*;

public class myShape {
    Shape shape;
    Color color;
    boolean fill;
    double angle;
    public myShape(Shape s,Color c,boolean f)
    {
        angle = 0;
        shape = s;
        color = c;
        fill = f;
    }
}

class textGraph
{
    String s;
    int x,y;
    public textGraph(String s, int x, int y) {
        this.s = s;
        this.x = x;
        this.y = y;
    }
}