/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocraccuracychecker;

import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author Tharaka
 */
public class OCRAccuracyChecker {
    
    /**
     * @param args the command line arguments
     */
    static Vector vec_Input;
    static Vector vec_Image;
    
    public static void main(String[] args) {
        vec_Input = new Vector();
        vec_Image = new Vector();
        
        StringTokenizer oTokenizer = new StringTokenizer("This is the image text");
        while (oTokenizer.hasMoreTokens()) {
            vec_Image.add(oTokenizer.nextToken());
            //System.out.println(oTokenizer.nextToken());
        }
        
        oTokenizer = new StringTokenizer("This is the a image text");
        while (oTokenizer.hasMoreTokens()) {
            vec_Input.add(oTokenizer.nextToken());
            //System.out.println(oTokenizer.nextToken());
        }
        
        float fAccuracy = AccuracyRunner.runAccuracyChecker(vec_Input, vec_Image, 0, 1);
        System.out.println("Accuracy is: " + fAccuracy + "%");
    }
    
}
