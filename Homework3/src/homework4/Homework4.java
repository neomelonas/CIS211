/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

import java.util.*;
/**
 *
 * @author nmelon01
 */
public class Homework4 {

    /**
     * OH NO A CONSTRUCTOR!
     */
    public Homework4() {
        // declare all your arrays

        String[] name = {"Smith, Mary", "Smythe, John", "Clinton, William", "Klink, Debbie", "Theremin, Ralph"};
        int[] temp = {34, 78, 78, 65, 45, 100, 90, 97, 56, 89, 78, 98, 74, 90, 98, 24, 45, 76, 89, 54, 12, 20, 22, 55, 66};
        int[][] scores = new int[5][5];
        int[] weight = {132, 165, 200, 155, 145};
        
        reorganizeArrays(name, temp, scores);
        String best = name[highestStudentExam(scores)];

    }

    public void reorganizeArrays(String[] n, int[] temp, int[][] scores) {
        for (int b = 0; b < 5; b++) {
            for (int c = 0; c < 5; c++) {
                int pos = b + c;
                scores[b][c] = temp[pos];
            }
        }
        String[][] trash = new String[5][6];
        for (int a = 0; a < 5; a++) {
            trash [a][0] = n[a];
            for (int b = 1; b < 6; b++) {
                trash[a][b] = Integer.toString(scores[a][b-1]);
            }
        }
        String[] holder = new String[6];
        for (int x = 1; x < 10; x++) {
            for (int y = 0; y < 10 - x; y++) {
                if (trash[y][0].compareTo(trash[y + 1][0]) > 0) {
                    holder = trash[y];
                    trash[y][0] = trash[y + 1][0];
                    trash[y + 1] = holder;
                }
            }
        }

        for (int a = 0; a < 5; a++) {
            n[a] = trash[a][0];
            for (int b = 1; b < 6; b++){
                scores[a][b-1] = Integer.parseInt(trash[a][b].trim());
            }
        }




    }

    public int highestStudentExam(int[][] s) {
        int i = 0, test = 0;
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                if (s[a][b] > test) i = a;
            }
        }
        return i;
    }

    public int mostCommonScore(){
        int i = 1;
        return i;
    }

    public static void main(String[] args) {

        Homework4 test = new Homework4();    // creates the objecrt of this class and runs constructor

        System.exit(0);

    }
}
