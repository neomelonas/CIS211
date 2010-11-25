/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3;

import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author nmelon01
 */
public class Homework3 {

    public Homework3() //    CONSTRUCTOR
    {

        // declare objects needed to do the graphics later

        Frame df = new Frame("application frame");

        df.setSize(800, 500);

        df.show();

        Graphics g = df.getGraphics();



        // declare all your arrays

        String[] name = {"Mary", "John", "William", "Debbie", "Ralph"};
        int[] temp = {34, 24, 78, 65, 45, 100, 90, 97, 56, 89, 78, 98, 74, 90, 98, 24, 45, 76, 89, 54, 12, 20, 22, 55, 66};
        int[][] scores = new int[8][8];
        float[] averages = new float[5];
        char[] letter = new char[5];

        reorganizeArrays(temp, scores, averages);
        calcLetterGrade(averages, letter);
        makeTables(name, scores, averages, letter);
    }

    public void reorganizeArrays(int[] temp, int[][] scores, float[] averages) {
        for (int b = 0;b < 5; b++) {
            for (int c = 0; c < 5; c++) {
                int pos = b + c;
                scores[b][c]=temp[pos];
            }
            scores[b][6] = scores[0][b];
            scores[b][7] = scores[0][b];
            for (int a = 0; a < 5; a++){
                scores[b][5] += scores[b][a];
                if (a > 0) {
                    if (scores[b][a] < scores[b][6]) scores[b][6] = scores[b][a];
                    if (scores[b][a] > scores[b][7]) scores[b][7] = scores[b][a];
                }
            }
            float thisAvg = 0;
            for (int i = 0; i < 5; i++) {
                if (scores[b][i] != scores[b][6]  && i < 4) {
                    thisAvg += (float) scores[b][i];
                }
            }
            thisAvg += (float) scores[b][4] * 2;
            averages[b] = thisAvg / 5;
        }
    }

    public void calcLetterGrade(float[] averages, char[] letter) {
        for (int a = 0; a < 5; a++) {
            if (averages[a] <= 100 && averages[a] >= 90) letter[a] = 'A';
            else if (averages[a] < 90 && averages[a] >= 80) letter[a] = 'B';
            else if (averages[a] < 80 && averages[a] >= 70) letter[a] = 'C';
            else if (averages[a] < 70 && averages[a] >= 60) letter[a] = 'D';
            else letter[a] = 'F';
        }
    }

    public void makeTables(String[] name, int[][] scores, float[] averages, char[] letter) {
        String output = "\tQ1\tQ2\tQ3\tQ4\tFinal\tTotal\tLow\tHigh\tAverage\tLetter\n";
        for (int a = 0; a < 5; a++) {
            output += name[a] + "\t";
            for (int b = 0; b < 8; b++) {
                output += Integer.toString(scores[a][b]) + "\t";
            }
            output += Float.toString(averages[a]) + "\t" + Character.toString(letter[a]) + "\n";
        }
        System.out.println(output);
    }

    public static void main(String[] args) {

        Homework3 test = new Homework3();    // creates the objecrt of this class and runs constructor

        System.exit(0);

    }
}
