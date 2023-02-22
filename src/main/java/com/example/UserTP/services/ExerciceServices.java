package com.example.UserTP.services;
import org.springframework.stereotype.Service;

@Service
public class ExerciceServices {
    
    public static String reverseStringLetter(String code){
        String result ="";
        for (int i=0; i<code.length(); i++) {
            char c = code.charAt(i);
            if (c == 'n'){
                c ='u';
                result += c;
            }
            
            else if (c == 'u') {
                c ='n';
                result += c;
            }
            else if (c == 'm') {
                c ='w';
                result += c;
            }
            else if (c == 'w') {c ='m';result += c;}
            else if (c == 'a') {c = 'e';result += c;}
            else if (c == 'e') {c = 'a';result += c;}
            else if (c == 'b') {c = 'p';result += c;}
            else if (c == 'p') {c = 'b';result += c;}
            else if (c == 'd') {c = 'q';result += c;}
            else if (c == 'q') {c = 'd';result += c;}
            else {
                result += c;
            }
        }
        return result;
    }

    public static int SumLetter(String code) {
        int valeur = 0;
        for (int i = 1; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c == 'r') {
                valeur += 4;
            } else if (c == 'w') {
                valeur += 2;
            } else if (c == 'x') {
                valeur += 1;
            }
            if (i % 3 == 0 && i != 9) {
                valeur *= 10;
            }
        }
        return valeur;
    }

    public static String duel(int hp1, int hp2, int d1,  int d2){
        String winner = "";
        int i =0;
        do {            
            hp1 -= d2;
            i += 1;
          } while (hp1 > 0);
          System.out.println(i);
          int j =0;
        do {            
            hp2 -= d1;
            j += 1;
          } while (hp2 > 0);
          System.out.println(j);
        if (i < j) winner = "Player 2 win " + i + " hits";
        else if ( i > j ) winner = "Player 1 wins " + j + " hits";
        return winner ;
    }

    public static String BirdTalk(String q){
        String result = "";
        for (int i =0; i<q.length(); i++) {
            char c = q.charAt(i);
            if (c == 'a' || c =='e'|| c =='i'|| c =='o'|| c =='u') {
                result += c;
                result += 'p';
                result += c;
            }else{
                result += c;
            }

        }return result;
    }   

    public static String ADN(String q){
        String result = "";
        int A =0;   int T =0;   int C =0;   int G =0;
        for (int i =0; i<q.length(); i++) {
            char c = q.charAt(i);
            if (c == 'A') {
                A += 1;
            }else if (c == 'T') {
                T += 1;
            }else if (c == 'C') {
                C += 1;
            }else if (c == 'G') {
                G += 1;
            }
        }
        result = "A C G T : " + A  + " " + C + " " +  G + " " + T;



        return result;
    }

    public static double Round(double q){
        double result = 0;
        double area = (Math.sqrt(3)*Math.pow(q, 2))/4;
        if (area % 1 == 0) {
            result = area;
        }else{
            result = area + (1 - (area % 1));
        }
        return result;
    }



    // public static void main(String[] args) {
    //     ExerciceServices es = new ExerciceServices();
        //System.out.println(es.reverseStringLetter("keep running"));
        //System.out.println(es.SumLetter("-rwxrwxrwx"));
        //System.out.println(es.duel(100,90,10,10));
        //System.out.println(es.BirdTalk("alex"));
        //System.out.println(es.ADN("AACT"));
        //System.out.println(es.Round(12));
    // }


    

}
