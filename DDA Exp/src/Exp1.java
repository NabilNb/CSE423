import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.*;

public class Exp1 implements GLEventListener {
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas
    static GLCanvas glcanvas = new GLCanvas(capabilities);

    public static void main(String[] args) {
        //getting the capabilities object of GL2 profile


        Exp1 l = new Exp1();
        //creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(800, 600);

        final JFrame frame = new JFrame ("Lab 2");
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
        DDA(gl,-1,0.5,-0.8,0.5);
        DDA(gl,-1,-0.5,-0.8,-0.5);
        DDA(gl,-0.9,-0.5,-0.9,0.5); // I end

        DDA(gl,-0.7,-0.5,-0.7,0.5);
        DDA(gl,-0.7,-0.5,-0.5,-0.5); // L end

        DDA(gl,-0.4,0.5,-0.2,0.5);
        DDA(gl,-0.4,-0.5,-0.2,-0.5);
        DDA(gl,-0.4,-0.5,-0.4,0.5);
        DDA(gl,-0.2,-0.5,-0.2,0.5); // O end

        DDA(gl,0.005,-0.5,-0.1,0.5);
        DDA(gl,0.005,-0.5,0.15,0.5);// V end

        DDA(gl,0.25,0.5,0.5,0.5);
        DDA(gl,0.25,0,0.5,0);
        DDA(gl,0.25,-0.5,0.5,-0.5);
        DDA(gl,0.25,-0.5,0.25,0.5); // E end

        DDA(gl,0.6,-0.5,0.6,0.5);
        DDA(gl,0.9,-0.5,0.9,0.5);
        DDA(gl,0.6,-0.5,0.9,-0.5);

        gl.glEnd();


    }

    public void DDA(GL2 gl, double x1, double y1, double x2, double y2){
        double m=(y2-y1)/(x2-x1);
        //System.out.println(m+" "+x1 );
        double x=x1;
        double y=y1;
        gl.glVertex2d(x1,y1);
        if(m>-1 && m<1){
            while(x<x2){
                x=x+0.001;
                y=y+m*0.001;
                 //System.out.println("x: "+ x+ " y:"+ y);
                gl.glVertex2d(x,y);
                //System.out.println("if" );
            }
            gl.glVertex2d(x2,y2);
            //System.out.println("if end" );
        } else{
            while(y<y2){
                y=y+0.001;
                x=x+((1/m)*0.001);
                //System.out.println("x: "+ x+ " y:"+ y);
                //System.out.println("else" );
                gl.glVertex2d(x,y);
            }
            gl.glVertex2d(x2,y2);
            //System.out.println("else end" );


        }




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
