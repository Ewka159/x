package CGlab;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    String version = "0.02";

    public static void main(String[] args) {
        int x, y;
        String sciezka;
        System.out.println(args.length);
        if (args.length < 4) {
            System.out.println("Za mało argumentów");
            return;

        }
        x = Integer.parseInt(args[1]);
        y = Integer.parseInt(args[2]);
      //  sciezka = args[0];
        sciezka="D:\\github\\CGlab\\img\\render.jpg";
Renderer.LineAlgo line=null;
if(args[3].equalsIgnoreCase("LINE_NAIVE"))
    line=Renderer.LineAlgo.NAIVE;

        Renderer mainRenderer = new Renderer(sciezka, x, y);
        mainRenderer.clear();
       mainRenderer.drawLine(100,100,200,200,line);
        mainRenderer.drawLine(200,200,400,400,Renderer.LineAlgo.BRESENHAM_INT);
        mainRenderer.drawLine(200,200,400,200,Renderer.LineAlgo.BRESENHAM_INT);
        mainRenderer.drawLine(200,200,400,0,Renderer.LineAlgo.BRESENHAM_INT);
        mainRenderer.drawLine(200,200,200,0,Renderer.LineAlgo.BRESENHAM_INT);
        mainRenderer.drawLine(200 , 200,0,0,Renderer.LineAlgo.BRESENHAM_INT);
        mainRenderer.drawLine(200,200,0,200,Renderer.LineAlgo.BRESENHAM_INT);
        mainRenderer.drawLine(200,200,0,400,Renderer.LineAlgo.BRESENHAM_INT);
        mainRenderer.drawLine(200,200,200,0,Renderer.LineAlgo.BRESENHAM_INT);

        Renderer.Vec2f A=mainRenderer.new Vec2f(200,50);
        Renderer.Vec2f B=mainRenderer.new Vec2f(120,50);
        Renderer.Vec2f C=mainRenderer.new Vec2f(75,150);
        Renderer.Vec3i Color=mainRenderer.new Vec3i(255,70,70);

        mainRenderer.drawTriangle(A,B,C,Color);

        try {
            mainRenderer.save();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getVersion() {
        return this.version;

    }
}
