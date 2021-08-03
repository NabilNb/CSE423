import java.util.*;

public class task2 {
    public static void main(String[]args){
        Random rand=new Random();
        int[] players=new int[7]; //7 players
        int temp;
        boolean music=false;
        boolean oneLeft=false; //to check if one is remaining

        for(int i=0;i<players.length;i++){
            players[i]=i;// creating players
        }
        while(oneLeft!=true){

            while(music!=true){
                rotate(players);

                temp=rand.nextInt(5);
                if(temp==1){
                    music=true;
                }

            }
            if(players.length>1){
                System.out.println("Player "+ players[players.length/2] + " is disqualified");
                players=removeOnePlayer(players);
            }
            if(players.length==1){
                oneLeft=true;
            }
            music=false;


        }

        int player=players[0];

        System.out.println("The winner is player "+player);

    }



    public static void rotate(int[] source){
        int temp=source[0];
        for(int i=0;i<source.length-1;i++){
            source[i]=source[i+1];
        }
        source[source.length-1]=temp;
    }
    public static void print(int[] source){
        for(int i=0;i<source.length;i++){
            System.out.println(source[i]);
        }
    }
    public static int[] removeOnePlayer(int[] source){
        int count=0;
        int[] array=new int[source.length-1];
        for(int i=0;i<array.length;i++){
            array[i]=source[count];
            count++;
            if(count==source.length/2){
                count++;
            }
        }
        return array;
    }






}
