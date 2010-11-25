/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package homework4;

/**
 *
 * @author nmelon01
 */
public class Sort {
    public static void main(String[] args){
        int[] n = {1,2,3,4,5};
        int[] s = new int[5];
        for (int a = 0; a < 5; a++) {
            int test = 0;
            for (int b = 0; b < 5; b++) {
                if (a == 0) {
                    if (n[b] > test) test = n[b];
                }
                else { if (n[b] > test  && n[b] < s[a-1]) test = n[b]; }
            }
            s[a] = test;
            System.out.println(s[a]);
        }
    }
}
