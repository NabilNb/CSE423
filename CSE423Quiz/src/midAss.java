import java.util.Scanner;

public class midAss {
    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);


        int x=scr.nextInt();
        int y=scr.nextInt();

        int zone1=scr.nextInt();
        int zone2=scr.nextInt();

        int[] wtf=convertToZone0(x,y,zone1);
        x=wtf[0];
        y=wtf[1];

        System.out.println(wtf[0]+" "+wtf[1]);

        wtf=convertToOriginal(x,y,zone2);
        System.out.println(wtf[0]+" "+wtf[1]);



    }

    public static int[] convertToZone0(int x, int y, int zone) {
        int[] convertion = new int[2];
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

    public static int[] convertToOriginal(int x, int y, int zone) {
        int[] original = new int[2];
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
