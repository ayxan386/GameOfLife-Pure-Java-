import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static int width = 1000,height = 1000;
    JFrame frame;
    public static void main(String[] args) {
        Main m = new Main();
        m.init();
        double fps = 30;
        long per = (long)(1e+9/fps);
        long curr = System.nanoTime();
        while(true)
        {
            if(curr + per <= System.nanoTime())
            {
                curr+=per;
                m.draw();
            }
        }
    }
    public Main()
    {
        frame = new JFrame("JFrame");
        frame.setSize(width,height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        myPanel mp = new myPanel();
        frame.add(mp);
        frame.setVisible(true);
    }
    public static int[][] grid;
    public static int w;
    public static int rows,cols;
    public void init()
    {
        w = 10;
        rows = height / w;
        cols = width / w;
        Random r = new Random();
        grid = new int[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                grid[i][j] = 1 - Math.abs(r.nextInt()) % 2;
    }
    public void draw()
    {
        drawGrid(grid);
        grid = newGrid(grid);
        frame.repaint();
    }
    public int[][] newGrid(int[][] grid)
    {
        int[][] newGrid = new int[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++) {
                int t = 0;
                    for (int x = -1; x <= 1; x++)
                        for (int y = -1; y <= 1; y++)
                                t += grid[(i + x + rows) % rows][(j + y + cols) % cols];
                        t-= grid[i][j];
                        if(t < 2 || t > 3)newGrid[i][j] = 0;
                            else if(t == 3)newGrid[i][j] = 1;
                                else newGrid[i][j] = grid[i][j];
            }
            return newGrid;
    }
    public void drawGrid(int[][] grid)
    {
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++) {
                Color c = grid[i][j] == 1 ? Color.black : Color.white;
                myPanel.drawRect(i * w, j * w, w-1, w-1, c,true);
            }
    }

}
