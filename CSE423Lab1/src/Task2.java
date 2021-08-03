import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import java.io.*;
import java.util.*;
import javax.swing.*;


public class Task2 implements GLEventListener {
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
       //getting the capabilities object of GL2 profile
       
       
       Task2 l = new Task2();
       //creating frame
       glcanvas.addGLEventListener(l);
       glcanvas.setSize(800, 600);
       
       final JFrame frame = new JFrame ("Lab 1Task 2");
       //adding canvas to frame
       frame.getContentPane().add(glcanvas);
       frame.setSize(frame.getContentPane().getPreferredSize());
       frame.setVisible(true);
       
    }
   public void display(GLAutoDrawable drawable) {
	   try {
	   File f=new File("D:\\Users\\User\\eclipse-workspace\\CSE423Lab1\\src\\input.txt");
	   Scanner scr=new Scanner(f);
	   
	   final GL2 gl = drawable.getGL().getGL2();
          gl.glBegin (GL2.GL_POINTS);//static field
          while(scr.hasNextFloat()) {
        	  float x=scr.nextFloat();
        	  float y=scr.nextFloat();
        	  gl.glVertex2d(x,y);
        	  //System.out.println("X: "+ x +" y:"+y );
          }
          
	   
          gl.glEnd();
	   }catch(Exception e) {
		   System.err.println(e);
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
