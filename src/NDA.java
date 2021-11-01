import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class NDA {
    public static void main(String[] args) {
        File file = new File("input.txt");
        int lines = 0, numberofpoints = 0, startpoint = 0, finalpoint = 0;
        String word = "";
        int[][] table = new int[0][];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();

            Scanner sc = new Scanner(file);
             word = sc.nextLine();
             numberofpoints = sc.nextInt();
             startpoint = sc.nextInt();
             finalpoint = sc.nextInt();
             lines -= 4;
            table = new int[lines][3];

            for(int i=0; i<lines; i++){
                for(int j=0; j<3; j++)
                {
                    table[i][j] = sc.nextInt();
                }
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)!='0' && word.charAt(i)!= '1'){
                System.out.println("Unacceptable word");
                System.exit(0);
            }
        }
        nfaCycle(word, startpoint, lines, table, finalpoint);
        System.out.println("Unacceptable");
    }

    private static void nfaCycle(String currentWord, int currentState, int size, int[][] table, int finalstate){
        if(currentState==finalstate){
            System.out.println("Acceptable");
            System.exit(0);
            return;
        }
        if(currentWord.isEmpty()){

            return;
        }

        for(int i=0; i<size; i++){
            if(table[i][0]==currentState &&  table[i][1] ==
             Character.getNumericValue(currentWord.charAt(0))){
                nfaCycle(currentWord.substring(1, currentWord.length()), table[i][2], size, table, finalstate);
            }
            if(table[i][0]==currentState && table[i][1] == 2){
                nfaCycle(currentWord, table[i][2], size, table, finalstate);
            }
        }

    }




}
