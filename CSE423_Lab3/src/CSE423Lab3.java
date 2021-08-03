import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;

public class CSE423Lab3 implements GLEventListener {

    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas
    static GLCanvas glcanvas = new GLCanvas(capabilities);

    public static void main(String[] args) {
        //getting the capabilities object of GL2 profile


        CSE423Lab3 l = new CSE423Lab3();
        //creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(800, 600);

        final JFrame frame = new JFrame("Lab 2. ID: 19101659");
        //adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void display(GLAutoDrawable drawable) {
        //ID=19101659
        final GL2 gl = drawable.getGL().getGL2();
        gl.glBegin(GL2.GL_POINTS);//static field

        /*
        //zone checking values from practice
        //MidPointAlgo(gl, -0.1, -0.2, -0.2, 0.7);
        MidPointAlgo(gl, -5, -100, 95, -35);
        MidPointAlgo(gl, -5, 100, 20, 135);
        MidPointAlgo(gl, 25, 25, -12, 48);
        MidPointAlgo(gl, 5, 52, -18, 89);
        MidPointAlgo(gl, 11, 9, 34, -9);
        MidPointAlgo(gl, -49, -29, -107, -68);

         */




        MidPointAlgo(gl, 0, 0.5, -0.5, 0.5); //Starting 5
        MidPointAlgo(gl, -0.5, 0.5, -0.5, 0);
        MidPointAlgo(gl, 0, 0, -0.5, 0);
        MidPointAlgo(gl, 0, 0, 0, -0.5);
        MidPointAlgo(gl, 0, -0.5, -0.5, -0.5); //ending 5
        MidPointAlgo(gl, 0.1, 0, 0.6, 0); //Starting 9
        MidPointAlgo(gl, 0.1, 0, 0.1, 0.5);
        MidPointAlgo(gl, 0.1, 0.5, 0.6, 0.5);
        MidPointAlgo(gl, 0.6, -0.5, 0.6, 0.5);// Ending 9




        gl.glEnd();


    }

    public void MidPointAlgo(GL2 gl, double x1, double y1, double x2, double y2) {
        /*
        x1=x1*0.01;
        x2=x2*0.01;
        y1=y1*0.01;
        y2=y2*0.01;

         */




        double dx = x2 - x1;
        double dy = y2 - y1;
        int zone = findZone(dx, dy);

        //System.out.println("dx: " + dx + " dy: " + dy);
        System.out.println("Original Zone: " + zone);

        double[] zone0coords=convertToZone0(x1, y1, zone);
        x1=zone0coords[0];
        y1=zone0coords[1];

        zone0coords=convertToZone0(x2,y2,zone);
        x2=zone0coords[0];
        y2=zone0coords[1];

        dx=x2-x1;
        dy=y2-y1;

        //zone=findZone(dx,dy);

        //System.out.println("Converted Zone: " + zone);

        double d=(2*dy-dx)*0.001;
        double dNE=(2*(dy-dx)*0.001);
        double dE=(2*dy)*0.001;

        double x=x1;
        double y=y1;

        double [] originalCoords=convertToOriginal(x,y,zone);

        gl.glVertex2d(originalCoords[0],originalCoords[1]);

        while(x<x2){
            if(d>0){
                //NE next pixel
                x=x+0.001;
                y=y+0.001;
                d=d+dNE;
            }else{
                //E as next pixel
                x=x+0.001;
                d=d+dE;
            }

            originalCoords=convertToOriginal(x,y,zone);
            //System.out.println(originalCoords[0]+"  "+originalCoords[1]);
            gl.glVertex2d(originalCoords[0], originalCoords[1]);

        }




    }

    public int findZone(double dx, double dy) {
        //int zone=0;
        // System.out.println(Math.abs(dx)>Math.abs(dy));

        if (Math.abs(dx) > Math.abs(dy)) {
           /* System.out.println( dx>0.0 && dy>0.0 );
            System.out.println( dx>0.0 && dy<0.0 );
            System.out.println( dx<0.0 && dy>0.0 );
            System.out.println( dx<0.0 && dy<0.0 );

            */
            if (dx >= 0.0 && dy >= 0.0) {
                return 0;
            } else if (dx >= 0.0 && dy <= 0.0) {
                return 7;
            } else if (dx <= 0.0 && dy >= 0.0) {
                return 3;
            } else if (dx <= 0.0 && dy <= 0.0) {
                return 4;
            }
        } else {
            if (dx >= 0.0 && dy >= 0.0) {
                return 1;
            } else if (dx >= 0.0 && dy <= 0.0) {
                return 6;
            } else if (dx <= 0.0 && dy >= 0.0) {
                return 2;
            } else if (dx <= 0.0 && dy <= 0.0) {
                return 5;
            }

        }
        return -1;
    }

    public double[] convertToZone0(double x, double y, int zone){
        double[] convertion=new double[2];
        if(zone==0){
            convertion[0]=x;
            convertion[1]=y;
        }else if(zone==1){
            convertion[0]=y;
            convertion[1]=x;
        }else if(zone==2){
            convertion[0]=y;
            convertion[1]=-x;
        }else if(zone==3){
            convertion[0]=-x;
            convertion[1]=y;
        }else if(zone==4){
            convertion[0]=-x;
            convertion[1]=-y;
        }else if(zone==5){
            convertion[0]=-y;
            convertion[1]=-x;
        }else if(zone==6){
            convertion[0]=-y;
            convertion[1]=x;
        }else if(zone==7){
            convertion[0]=x;
            convertion[1]=-y;
        }

        return convertion;
    }

    public double[] convertToOriginal(double x, double y, int zone){
        double[] original=new double[2];
        if(zone==0){
            original[0]=x;
            original[1]=y;
        } else if(zone==1){
            original[0]=y;
            original[1]=x;
        }else if(zone==2){
            original[0]=-y;
            original[1]=x;
        }else if(zone==3){
            original[0]=-x;
            original[1]=y;
        }else if(zone==4){
            original[0]=-x;
            original[1]=-y;
        }else if(zone==5){
            original[0]=-y;
            original[1]=-x;
        }else if(zone==6){
            original[0]=y;
            original[1]=-x;
        }else if(zone==7){
            original[0]=x;
            original[1]=-y;
        }

        return original;
    }



    public void dispose(GLAutoDrawable arg0) {
        //method body
    }


    public void init(GLAutoDrawable drawable) {
        // method body
        //4. drive the display() in a loop
    }

    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // method body
    }
    //end of main


}
