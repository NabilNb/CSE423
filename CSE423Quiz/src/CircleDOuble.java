import java.util.Scanner;

public class CircleDOuble {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        System.out.println("Enter Radius");
        double radius = scr.nextDouble();

        System.out.println("Enter x,y coords");
        double x = scr.nextDouble();
        double y = scr.nextDouble();

        System.out.println("Enter Zone");
        int zone = scr.nextInt();

        circle(radius, x, y, zone);


    }

    public static void circle(double radius, double xOrigin, double yOrigin, int zone) {
        double d = 1 - radius;
        double x = 0;
        double y = radius;
        double[] coords = new double[2];

        System.out.println("Coords assuming (0,0)- Value of D- Coords of desired arc- Desired arc coords converted to original");

        while (x < y) {
            System.out.print(x + " " + y + " ");
            System.out.print(" "+d+" ");
            coords=convert(x,y,zone);
            System.out.print(coords[0]+" "+coords[1]+" ");
            System.out.print((coords[0] + xOrigin) + " " + (coords[1] + yOrigin));
            if (d < 0) {
                System.out.println(" E");
                d = d + 2 * x + 3;
                x = x + 1;


            } else {
                System.out.println(" SE");
                d = d + 2 * x - 2 * y + 5;
                x = x + 1;
                y = y - 1;


            }


        }


    }

    public static double[] convert(double x, double y, int zone) {
        double[] coords = new double[2];
        coords[0] = y;
        coords[1] = x;
        x=coords[0];
        y=coords[1];

        if (zone == 0) {
            coords[0] = x;
            coords[1] = y;
        } else if (zone == 1) {
            coords[0] = y;
            coords[1] = x;
        } else if (zone == 2) {
            coords[0] = -y;
            coords[1] = x;
        } else if (zone == 3) {
            coords[0] = -x;
            coords[1] = y;
        } else if (zone == 4) {
            coords[0] = -x;
            coords[1] = -y;
        } else if (zone == 5) {
            coords[0] = -y;
            coords[1] = -x;
        } else if (zone == 6) {
            coords[0] = y;
            coords[1] = -x;
        } else if (zone == 7) {
            coords[0] = x;
            coords[1] = -y;
        }


        return coords;
    }


}
