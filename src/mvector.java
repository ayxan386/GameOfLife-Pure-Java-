import java.util.Random;

public class mvector {
    public double x;
    public double y;
    public double angle;

    public mvector()
    {

    }
    public mvector(double x,double y)
    {
        this.x = x;
        this.y = y;
    }
    public void norm()
    {
        angle = Math.atan2(x,y);
        this.x = Math.cos(angle);
        this.y = Math.sin(angle);
    }
    public static mvector randomVector()
    {
        Random rd = new Random();
        mvector res = new mvector();
        res.angle = rd.nextDouble() * Math.PI * 2;
        res.x = Math.cos(res.angle);
        res.y = Math.sin(res.angle);
        return  res;
    }
    public static mvector vectorFromAngle(double angle)
    {
        mvector res = new mvector();
        res.angle = angle;
        res.x = Math.cos(res.angle);
        res.y = Math.sin(res.angle);
        return  res;
    }
    public void mult(double l)
    {
        this.x = l * this.x;//Math.cos(this.angle);
        this.y = l * this.y;//Math.sin(this.angle);
    }
    public static double dist(mvector a, mvector b)
    {
        return (a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y);
    }
    public double Theta(mvector b)
    {
        double res = (b.x*x + y*b.y)/(this.len() * b.len());
        res = Math.acos(res);
        return  res;
    }
    public double len()
    {
        return Math.sqrt(x*x + y*y);
    }
    public static mvector vectorFromPoints(mvector p1,mvector p2)
    {
        mvector res = new mvector();
        res.x = p2.x - p1.x;
        res.y = p2.y - p1.y;
        return  res;
    }
    public String toString()
    {
        return String.format("x:%.3f y:%.3f",this.x,this.y);
    }
}
