package graph;

import java.awt.*;

public class MyPanel extends Panel{

    private final int zoom;
    private final int endX;
    private final int endY;
    private final double incX;
    private final double minX;
    private final double maxX;



    public MyPanel(){
        zoom = 10;
        endX = 700;
        endY = 700;
        minX = -35;
        maxX = 35;
        incX = 0.001;



        this.setSize(endX,endY);
    }

    public void paint(Graphics g){
        //draw edge line
        g.drawLine(0, 0, 0, endY);
        g.drawLine(0, 0, endX, 0);
        g.drawLine(0, endY, endX, endY);
        g.drawLine(endX, 0, endX, endY);
        //x line y line
        g.drawLine(0, endY/2, endX, endY/2);
        g.drawLine(endX/2, 0, endX/2, endY);
        //x,y arrow
        g.drawLine(endX - 5, (endY/2) - 5, endX, endY/2);
        g.drawLine(endX - 5, (endY/2) + 5, endX, endY/2);
        g.drawLine(endX/2 - 5, 5, endX/2, 0);
        g.drawLine(endX/2 + 5, 5, endX/2, 0);
        //0,x,y
        g.drawString("0", endX/2 + 2, endY/2 + 12);
        g.drawString("X", endX - 14, endY/2 + 12);
        g.drawString("Y", endX/2 + 10, 13);
        // marking
        for(int k=1;k<36;k=k+1){
            g.drawLine(endX/2 + zoom*k, endY/2 - 3, endX/2 + zoom*k, endY/2 + 3);
            g.drawLine(endX/2 - zoom*k, endY/2 - 3, endX/2 - zoom*k, endY/2 + 3);
        }
        for(int k=1;k<36;k=k+1){
            g.drawLine(endX/2 - 3, endY/2 + zoom*k, endX/2 + 3, endY/2 + zoom*k);
            g.drawLine(endX/2 - 3, endY/2 - zoom*k, endX/2 + 3, endY/2 - zoom*k);
        }


        double x1 = minX;
        double y1 = Math.sin(x1);
        for(double x= minX + incX; x < maxX; x = x + incX){
            double x2 = x;
            double y2 = Math.sin(x2);
            g.setColor(Color.BLUE);
            g.drawLine((int) (x1*zoom+endX/2), (int) (endY/2-y1*zoom),
                    (int) (x2*zoom+endX/2), (int) (endY/2-y2*zoom));
            x1 = x2;
            y1 = y2;
        }
    }


}