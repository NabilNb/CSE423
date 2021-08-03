import java.util.Scanner;

public class MidpointLine {
    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);
        System.out.println("Input x1, y1");
        int x1=scr.nextInt();
        int y1=scr.nextInt();
        System.out.println("Input x2, y2");
        int x2=scr.nextInt();
        int y2=scr.nextInt();
        MidPointAlgo(x1,y1,x2,y2);

    }

    public static void MidPointAlgo(double x1, double y1, double x2, double y2) {
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

        double[] zone0coords = convertToZone0(x1, y1, zone);
        x1 = zone0coords[0];
        y1 = zone0coords[1];

        zone0coords = convertToZone0(x2, y2, zone);
        x2 = zone0coords[0];
        y2 = zone0coords[1];

        dx = x2 - x1;
        dy = y2 - y1;

        //zone=findZone(dx,dy);

        //System.out.println("Converted Zone: " + zone);

        double d = (2 * dy - dx);
        double dNE = (2 * (dy - dx));
        double dE = (2 * dy);

        double x = x1;
        double y = y1;

        double[] originalCoords =new double[2] ;//convertToOriginal(x, y, zone);

        //gl.glVertex2d(originalCoords[0], originalCoords[1]);
        //System.out.println(originalCoords[0]+" "+ originalCoords[1]);
        System.out.println("Zone0 Coords - D - Original Coords - E/NE");

        while (x < x2) {
            originalCoords = convertToOriginal(x, y, zone);
            System.out.print(x+" "+y+" "+d+" "+originalCoords[0]+"  "+originalCoords[1]);
            if (d > 0) {
                //NE next pixel
                System.out.println(" NE");
                x = x + 1;
                y = y + 1;
                d = d + dNE;
            } else {
                //E as next pixel
                System.out.println(" E");
                x = x + 1;
                d = d + dE;
            }


            //gl.glVertex2d(originalCoords[0], originalCoords[1]);

        }


    }

    public static int findZone(double dx, double dy) {
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

    public static double[] convertToZone0(double x, double y, int zone) {
        double[] convertion = new double[2];
        if (zone == 0) {
            convertion[0] = x;
            convertion[1] = y;
        } else if (zone == 1) {
            convertion[0] = y;
            convertion[1] = x;
        } else if (zone == 2) {
            convertion[0] = y;
            convertion[1] = -x;
        } else if (zone == 3) {
            convertion[0] = -x;
            convertion[1] = y;
        } else if (zone == 4) {
            convertion[0] = -x;
            convertion[1] = -y;
        } else if (zone == 5) {
            convertion[0] = -y;
            convertion[1] = -x;
        } else if (zone == 6) {
            convertion[0] = -y;
            convertion[1] = x;
        } else if (zone == 7) {
            convertion[0] = x;
            convertion[1] = -y;
        }

        return convertion;
    }

    public static double[] convertToOriginal(double x, double y, int zone) {
        double[] original = new double[2];
        if (zone == 0) {
            original[0] = x;
            original[1] = y;
        } else if (zone == 1) {
            original[0] = y;
            original[1] = x;
        } else if (zone == 2) {
            original[0] = -y;
            original[1] = x;
        } else if (zone == 3) {
            original[0] = -x;
            original[1] = y;
        } else if (zone == 4) {
            original[0] = -x;
            original[1] = -y;
        } else if (zone == 5) {
            original[0] = -y;
            original[1] = -x;
        } else if (zone == 6) {
            original[0] = y;
            original[1] = -x;
        } else if (zone == 7) {
            original[0] = x;
            original[1] = -y;
        }

        return original;
    }
}
