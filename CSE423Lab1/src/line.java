import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import java.util.Random;

import javax.swing.JFrame;

public class line implements GLEventListener {
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
       //getting the capabilities object of GL2 profile
       
       
       line l = new line();
       //creating frame
       glcanvas.addGLEventListener(l);
       glcanvas.setSize(800, 600);
       
       final JFrame frame = new JFrame ("Lab 1Task 1");
       //adding canvas to frame
       frame.getContentPane().add(glcanvas);
       frame.setSize(frame.getContentPane().getPreferredSize());
       frame.setVisible(true);
       
    }
   public void display(GLAutoDrawable drawable) {
	   Random r= new Random();
      final GL2 gl = drawable.getGL().getGL2();
          gl.glBegin (GL2.GL_POINTS);//static field
          for(int i=0;i<100;i++) {
        	  float x= -1.0f+(r.nextFloat()*(1.0f-(-1.0f)));
        	  float y= -1.0f+(r.nextFloat()*(1.0f-(-1.0f)));
        	  gl.glVertex2d(x,y);
        	  //System.out.println("X: "+ x +" y:"+y );
          }
          
          
          gl.glEnd();
          
      
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
