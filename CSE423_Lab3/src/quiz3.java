import java.util.*;

 class quiz3 {
     public static void main(String[] args) {
         Scanner scr=new Scanner(System.in);
         int x0=scr.nextInt();
         int y0=scr.nextInt();
         int x1=scr.nextInt();
         int y1=scr.nextInt();

         int dx=x1-x0;
         int dy=y1-y0;
         int zone=findZone(dx,dy);

         int x=x0;
         int y=y0;

         System.out.println("zone "+ zone);

         if(zone==1){
            x0=y0;
            y0=x0;
         }else if(zone==2){
             x0=y0;
             y0=-x0;
         }else if(zone==3){
             x0=-x0;
             y0=y0;
         }else if(zone==4){
             x0=-x0;
             y0=-y0;
         }else if(zone==5){
             x0=-y0;
             y0=-x0;
         }else if(zone==6){
             x0=-y0;
             y0=x0;
         }else if(zone==7){
             x0=x0;
             y0=-y0;
         }

         if(zone==1){
             x1=y1;
             y1=x1;
         }else if(zone==2){
             x1=y1;
             y1=-x1;
         }else if(zone==3){
             x1=-x1;
             y1=y1;
         }else if(zone==4){
             x1=-x1;
             y1=-y1;
         }else if(zone==5){
             x1=-y1;
             y1=-x1;
         }else if(zone==6){
             x1=-y1;
             y1=x1;
         }else if(zone==7){
             x1=x1;
             y1=-y1;
         }

         System.out.println("x0: "+ x0 +" y0:"+y0);
         System.out.println("x1: "+ x1 +" y1:"+y1);


        /*
         int dInit=(2*dy)-dx;

         int dE=2*dy;
         int dNE=2*(dy-dx);
         int d=dInit;

         while(x<x1){
             if(d>0){
                 d=d+dNE;

                 x++;
                 y++;


             }else{
                 d=d+dE;
                 x++;
                 System.out.println("E & x: " +x0 +" y: "+y0 );
             }


         }

         */





     }

     public static int findZone(int dx, int dy){
         int zone=0;
         if(Math.abs(dx)>Math.abs(dy)){
             if(dx>0 && dy>0){
                 zone=0;
             }else if(dx>0 && dy<0){
                 zone=7;
             }else if(dx<0 && dy>0){
                 zone=3;
             }else if(dx<0 && dy<0){
                 zone=4;
             }
         }else{
             if(dx>0 && dy>0){
                 zone=1;
             }else if(dx>0 && dy<0){
                 zone=6;
             }else if(dx<0 && dy>0){
                 zone=2;
             }else if(dx<0 && dy<0){
                 zone=5;
             }

         }
         return zone;
     }



}
