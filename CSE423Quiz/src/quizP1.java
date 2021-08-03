import java.util.Scanner;
import java.util.*;
import java.io.*;

public class quizP1 {
    public static void main(String[] args) {
        try {
            //***************WORKING COHEN FILE*****************************
            File f=new File("D:\\Users\\CSE423Quiz\\src\\input.txt");
            Scanner scr = new Scanner(f);

            //System.out.println("Enter x1");
            int x1 = scr.nextInt();
            //System.out.println("Enter y1");
            int y1 = scr.nextInt();
            //System.out.println("Enter x2");
            int x2 = scr.nextInt();
            //System.out.println("Enter y2");
            int y2 = scr.nextInt();

            int xmin, xmax, ymin, ymax;
            if (x1 > x2) {
                xmax = x1;
                xmin = x2;
            } else {
                xmax = x2;
                xmin = x1;
            }
            // System.out.println(xmax+"/"+xmin);

            if (y1 > y2) {
                ymax = y1;
                ymin = y2;
            } else {
                ymax = y2;
                ymin = y1;
            }
            //System.out.println(ymax+"/"+ymin);

            //System.out.println("Enter x1");
            x1 = scr.nextInt();
            //System.out.println("Enter y1");
            y1 = scr.nextInt();
            //System.out.println("Enter x2");
            x2 = scr.nextInt();
            //System.out.println("Enter y2");
            y2 = scr.nextInt();

            int[] out1 = calcOut(x1, y1, xmax, xmin, ymax, ymin);
            int[] out2 = calcOut(x2, y2, xmax, xmin, ymax, ymin);

            printOut(out1);
            printOut(out2);
            cohen(out1, out2, x1, y1, x2, y2, xmax, xmin, ymax, ymin);

        }catch(Exception e){
            System.err.println(e);
        }


    }

    public static void cohen(int[] out1,int[] out2,int x1,int y1,int x2,int y2,int xmax,int xmin,int ymax, int ymin){
        int[] check=new int[4];
        int[] out=new int[4];
        for(int i=0;i<out.length;i++){
            if(out1[i]==out2[i]){
                out[i]=out1[i];
            }
        }

        double m=(double)(y2-y1)/(x2-x1);
        System.out.println(m);
        double x=0;
        double y=0;

        while(true){
            if(((out1[0]==out2[0])&&out1[0]==0)&&((out1[1]==out2[1])&&out1[1]==0)&&((out1[2]==out2[2])&&out1[2]==0)&&((out1[3]==out2[3])&&out1[3]==0)){
                System.out.println("made it here//Completely inside clip");
                break;
            }else if((out[0]!=check[0])||(out[1]!=check[1])||(out[2]!=check[2])||(out[3]!=check[3])){
                System.out.println("Made it here// Completely outside clip");
                break;

            }else{
                if((out1[0]!=0)||(out1[1]!=0)||(out1[2]!=0)||(out1[3]!=0)){
                    System.out.println("Out 1//partially outside");
                    if(out1[0]==1){
                        y=ymax;
                        x=x1+((1/m)*(ymax-y1));
                        System.out.println("Top intersection" );
                    }else if(out1[1]==1){
                        y=ymin;
                        x=x1+((1/m)*(ymin-y1));
                        System.out.println("Bottom intersection");
                    }else if(out1[2]==1){
                        x=xmax;
                        y=y1+(m*(xmax-x1));
                        System.out.println("Right intersection");
                    }else if(out1[3]==1){
                        x=xmin;
                        y=y1+(m*(xmin-x1));
                        System.out.println("Left intersection");
                    }
                    System.out.println("New x1: "+x +" New y1: "+y );
                    out1=calcOut((int)x,(int)y,xmax,xmin,ymax,ymin);
                    System.out.print("New out1: ");
                    printOut(out1);


                }else if((out2[0]!=0)||(out2[1]!=0)||(out2[2]!=0)||(out2[3]!=0)){
                    System.out.println("Line 2//partially outside");
                    if(out2[0]==1){
                        y=ymax;
                        x=x2+((1/m)*(ymax-y2));
                        System.out.println("Top intersection");
                    }else if(out2[1]==1){
                        y=ymin;
                        x=x2+((1/m)*(ymin-y2));
                        System.out.println("Bottom intersection");
                    }else if(out2[2]==1){
                        x=xmax;
                        y=y2+(m*(xmax-x2));
                        System.out.println("Right intersection");
                    }else if(out2[3]==1){
                        x=xmin;
                        y=y2+(m*(xmin-x2));
                        System.out.println("Left intersection");
                    }
                    System.out.println("New x2: "+x+" New y2: "+ y);
                    out2=calcOut((int)x,(int)y,xmax,xmin,ymax,ymin);
                    System.out.print("New out2: ");
                    printOut(out2);


                }

                //break;

                for(int i=0;i<out.length;i++){
                    if(out1[i]==out2[i]){
                        out[i]=out1[i];
                    }
                }





            }



        }



    }

    public static int[] calcOut(int x,int y,int xmax,int xmin,int ymax, int ymin){
        int[] out=new int[4];

        if(x<xmin){
            out[3]=1;
        }
        if(x>xmax){
            out[2]=1;
        }
        if(y<ymin){
            out[1]=1;
        }
        if(y>ymax){
            out[0]=1;
        }



        return out;
    }
    public static void printOut(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }


}
