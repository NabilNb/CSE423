

public class DDAQuiz{
   
    public static void main(String[] args) {
        //getting the capabilities object of GL2 profile
      
      DDA(38,88,71,12);
    }

       



    public static void DDA(double x1, double y1, double x2, double y2){
        double m=(y2-y1)/(x2-x1);
        //System.out.println(m+" "+x1 );
        double x=x1;
        double y=y1;
        System.out.println(x1+ "  "+ y1);
        if(m>-1 && m<1){
            while(x<x2){
                x=x+1;
                y=y+m*1;
                 System.out.println("x: "+ Math.round(x)+ " y:"+ Math.round(y));
                //System.out.println(x+ ""+ y);
                //System.out.println("if" );
            }
            System.out.println("x: "+ Math.round(x)+ " y:"+ Math.round(y));
            //System.out.println("if end" );
        } else{
            while(y!=y2){
                y=y-1;
                x=x-((1/m)*1);
                System.out.println("x: "+ Math.round(x)+ " y:"+ Math.round(y));
                //System.out.println("else" );
                //System.out.println(x+ ""+ y);
            }
            System.out.println("x: "+ Math.round(x)+ " y:"+ Math.round(y));
            //System.out.println("else end" );


        }




    }




}
