import java.io.*;
import java.util.*;

public class CSE420Lab02 {
    public static void main(String[] args) {
        File file = new File("D:\\BuX\\CSE420\\Labs\\CSE420Lab02\\Input.txt");
        Scanner scr;
        try {
            scr = new Scanner(file);

            int totalInput = scr.nextInt();

            System.out.println("Total Inputs = " + totalInput);
            int lineNo=0;

            while (lineNo<totalInput) {
                String st = scr.next();
                lineNo++;
                boolean email = false;
                if (st.contains("@")) {
                    email = true;
                }

                if (email) {  //checking if the string is email
                    boolean valid = true;
                    int state = 0;
                    int finalState = 5;
                    int comCount = 0;
                    for (int i = 0; i < st.length(); i++) {
                        char character = st.charAt(i);
                        int charNum = (int) st.charAt(i);
                        if (state == 0 && (character == '.' || character == '_' || character == '-')) {
                            valid = false;
                            break;
                        } else if (((charNum >= (int) 'a' && charNum <= (int) 'z') || (charNum >= (int) 'A' && charNum <= (int) 'Z') || (charNum >= (int) '0' && charNum <= (int) '9') || (character == '.' || character == '_' || character == '-')) && state <= 1) {
                            state = 1;

                        } else if (character == '@' && state == 1) {
                            state = 2;
                        } else if (((charNum >= (int) 'a' && charNum <= (int) 'z') || (charNum >= (int) 'A' && charNum <= (int) 'Z') || (charNum >= (int) '0' && charNum <= (int) '9')) && (state == 2 || state == 3)) {
                            state = 3;
                        } else if (character == '.' && state == 3) {
                            state = 4;
                        } else if ((((charNum >= (int) 'a' && charNum <= (int) 'z') || (charNum >= (int) 'A' && charNum <= (int) 'Z') || (charNum >= (int) '0' && charNum <= (int) '9')) && (state == 4 || state == finalState)) && comCount <= 2) {
                            state = finalState;
                            comCount++;

                        } else {
                            valid = false;
                        }


                    }

                    if (valid&& state==finalState) {
                        System.out.println(st + " - valid Email Address."+" Line no: "+ lineNo);
                    } else {
                        System.out.println(st + " - invalid Email Address."+" Line no: "+ lineNo);
                    }
                } else {  //checking url
                    boolean valid = true;
                    int state = 0;
                    int finalState = 5;
                    int totalDot = 0;
                    int dotChecked = 0;
                    boolean prevDot = false;
                    int comCharCounter = 0;
                    int wCount=0;
                    for(int i = 0 ; i < st.length() ; i++){
                        if(st.charAt(i) == '.')
                            totalDot++;
                    }
                    for(int i = 0 ; i < st.length() ; i++){
                        int check = (int)st.charAt(i);
                        char character = st.charAt(i);
                        if(state == 0 && (character == '_' || character == '-')){
                            valid = false;
                            break;
                        }
                        /*else if (((charNum >= (int) 'w' || charNum >= (int) 'W' ) && wCount<=3 && state<=1)) {
                            state = 1;
                            System.out.println("state 1");
                            wCount++;
                        } else if (character == '.' && state == 1) {
                            /*
                            if(wCount<3||wCount>4){
                                valid=false;
                            }


                            state = 2;
                            checked++;
                            */
                        else if(((check >= (int) 'a'  &&  check <= (int)'z') || (check >= (int) 'A'  &&  check <= (int)'Z')  ||   (check >= (int) '0'  &&  check <= (int)'9') ||(character == '_'||character == '-'))&& state <= 1){
                            state = 1;
                            //System.out.println(st.charAt(i) + "@state1");
                            if(st.charAt(i)=='w'||st.charAt(i)=='W'){
                                wCount++;
                                //System.out.println("st1"+ wCount);
                            }
                        }
                        else if(character == '.' && state == 1 ){
                            state = 2;
                            dotChecked++;
                            //System.out.println(st.charAt(i)+ "@state2");
                        }
                        else if(((check >= (int) 'a'  &&  check <= (int)'z') || (check >= (int) 'A'  &&  check <= (int)'Z')  ||   (check >= (int) '0'  &&  check <= (int)'9') ||(character == '_'||character == '-'))&& (state == 2 || state == 3)){
                            state = 3;
                            prevDot = false;
                            //System.out.println(st.charAt(i)+ "@state3.1");
                        }
                        else if(character == '.' && state == 3 && !prevDot && dotChecked < totalDot-1){
                            state = 3;
                            prevDot = true;
                            dotChecked++;
                            //System.out.println(st.charAt(i)+ "@state3.2");
                        }
                        else if(character == '.' && state == 3 && !prevDot && dotChecked == totalDot-1){
                            state = 4;
                            prevDot = true;
                            dotChecked++;
                            //System.out.println(st.charAt(i)+ "@state4");
                        }
                        else if((((check >= (int) 'a'  &&  check <= (int)'z') || (check >= (int) 'A'  &&  check <= (int)'Z')) && (state == 4|| state == finalState)) && (comCharCounter <= 2 )){
                            state = 5;
                            prevDot = false;
                            comCharCounter++;
                           // System.out.println(st.charAt(i)+ "@state5");

                        } else {
                            valid = false;
                        }

                    }
                    if(wCount<3||wCount>3){
                        System.out.println("wCount"+wCount);
                        valid=false;
                    }

                    if(valid){
                        System.out.println(st + " - Valid Website. Line No: "+ lineNo);
                    } else{
                        System.out.println(st+ " - Invalid Website. Line No: "+ lineNo);
                    }


                }

            }
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
