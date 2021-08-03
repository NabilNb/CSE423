import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;

public class Assignment3_18101505_FariyaZakirFarhin implements GLEventListener {
    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas
    static GLCanvas glcanvas = new GLCanvas(capabilities);

    public static void main(String[] args) {
        //getting the capabilities object of GL2 profile


        Assignment3_18101505_FariyaZakirFarhin l = new Assignment3_18101505_FariyaZakirFarhin();
        //creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(600, 400);

        final JFrame frame = new JFrame("ID: 18101505");
        //adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glBegin(GL2.GL_POINTS);//static field
        MidPointLine(gl, 0.1, 0.5, 0.6, 0.5);
        MidPointLine(gl, 0.1, 0, 0.1, 0.5);
        MidPointLine(gl, 0.1, 0, 0.6, 0);
        MidPointLine(gl, 0.6, -0.5, 0.6, 0);
        MidPointLine(gl, 0.1, -0.5, 0.6, -0.5);

        MidPointLine(gl, -0.6, 0.5, -0.1, 0.5);
        MidPointLine(gl, -0.6, -0.5, -0.6, 0.5);
        MidPointLine(gl, -0.6, -0.5, -0.1, -0.5);
        MidPointLine(gl, -0.1, -0.5, -0.1, 0.5);

        gl.glEnd();


    }

    public void MidPointLine(GL2 gl, double x1, double y1, double x2, double y2) {
        int zone = findZone(x1, y1, x2, y2);

        double[] newCoords = ConvertToZone0(x1, y1, zone);
        x1 = newCoords[0];
        y1 = newCoords[1];

        newCoords = ConvertToZone0(x2, y2, zone);
        x2 = newCoords[0];
        y2 = newCoords[1];

        double dx = x2 - x1;
        double dy = y2 - y1;

        double x = x1;
        double y = y1;

        double d = (2 * dy - dx) * 0.0001;
        double dNE = (2 * (dy - dx) * 0.0001);
        double dE = (2 * dy) * 0.0001;


        double[] originalCoords = convertToOriginalZone(x, y, zone);

        gl.glVertex2d(originalCoords[0], originalCoords[1]);

        while (x < x2) {
            if (d > 0) {
                x = x + 0.0001;
                y = y + 0.0001;
                d = d + dNE;
            } else {
                x = x + 0.0001;
                d = d + dE;
            }

            originalCoords = convertToOriginalZone(x, y, zone);
            gl.glVertex2d(originalCoords[0], originalCoords[1]);

        }


    }

    public int findZone(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;

        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx >= 0 && dy >= 0) {
                return 0;
            } else if (dx >= 0 && dy <= 0) {
                return 7;
            } else if (dx <= 0 && dy >= 0) {
                return 3;
            } else if (dx <= 0 && dy <= 0) {
                return 4;
            }
        } else {
            if (dx >= 0 && dy >= 0) {
                return 1;
            } else if (dx >= 0 && dy <= 0) {
                return 6;
            } else if (dx <= 0 && dy >= 0) {
                return 2;
            } else if (dx <= 0 && dy <= 0) {
                return 5;
            }

        }
        return -100;
    }

    public double[] ConvertToZone0(double x, double y, int zone) {
        double[] newCoords = new double[2];
        if (zone == 0) {
            newCoords[0] = x;
            newCoords[1] = y;
        } else if (zone == 1) {
            newCoords[0] = y;
            newCoords[1] = x;
        } else if (zone == 2) {
            newCoords[0] = y;
            newCoords[1] = -x;
        } else if (zone == 3) {
            newCoords[0] = -x;
            newCoords[1] = y;
        } else if (zone == 4) {
            newCoords[0] = -x;
            newCoords[1] = -y;
        } else if (zone == 5) {
            newCoords[0] = -y;
            newCoords[1] = -x;
        } else if (zone == 6) {
            newCoords[0] = -y;
            newCoords[1] = x;
        } else if (zone == 7) {
            newCoords[0] = x;
            newCoords[1] = -y;
        }

        return newCoords;
    }

    public double[] convertToOriginalZone(double x, double y, int zone) {
        double[] originalCoords = new double[2];
        if (zone == 0) {
            originalCoords[0] = x;
            originalCoords[1] = y;
        } else if (zone == 1) {
            originalCoords[0] = y;
            originalCoords[1] = x;
        } else if (zone == 2) {
            originalCoords[0] = -y;
            originalCoords[1] = x;
        } else if (zone == 3) {
            originalCoords[0] = -x;
            originalCoords[1] = y;
        } else if (zone == 4) {
            originalCoords[0] = -x;
            originalCoords[1] = -y;
        } else if (zone == 5) {
            originalCoords[0] = -y;
            originalCoords[1] = -x;
        } else if (zone == 6) {
            originalCoords[0] = y;
            originalCoords[1] = -x;
        } else if (zone == 7) {
            originalCoords[0] = x;
            originalCoords[1] = -y;
        }

        return originalCoords;
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
