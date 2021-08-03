import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;

public class Nabil_19101659_Lab2 implements GLEventListener{
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas
    static GLCanvas glcanvas = new GLCanvas(capabilities);

    public static void main(String[] args) {
        //getting the capabilities object of GL2 profile


        Nabil_19101659_Lab2 l = new Nabil_19101659_Lab2();
        //creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(800, 600);

        final JFrame frame = new JFrame ("Lab 2. ID: 19101659");
        //adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public void display(GLAutoDrawable drawable) {
        //ID=19101659
        final GL2 gl = drawable.getGL().getGL2();
        gl.glBegin (GL2.GL_POINTS);//static field
        DDA(gl,-0.5,0.5,0,0.5); //Starting 5
        DDA(gl,-0.5,0,-0.5,0.5);
        DDA(gl,-0.5,0,0,0);
        DDA(gl,0,-0.5,0,0);
        DDA(gl,-0.5,-0.5,0,-0.5); //ending 5
        DDA(gl,0.1,0,0.6,0); //Starting 9
        DDA(gl,0.1,0,0.1,0.5);
        DDA(gl,0.1,0.5,0.6,0.5);
        DDA(gl,0.6,-0.5,0.6,0.5);// Ending 9

        gl.glEnd();


    }

    public void DDA(GL2 gl, double x1, double y1, double x2, double y2){

            gl.glVertex2d(x2,y2);
            //System.out.println("else end" );







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
