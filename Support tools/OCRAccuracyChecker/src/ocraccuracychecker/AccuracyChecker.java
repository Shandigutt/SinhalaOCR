/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocraccuracychecker;

/**
 *
 * @author Tharaka
 */
public class AccuracyChecker {
    static String s_Input;
    static String s_Image;
    
    public static float checkAccuracy(String sInput, String sImage, int iVerboseLevel){
        int iImageTotal = sImage.length();
        int iInputTotal = sInput.length();
        int iDefectCount;
        iDefectCount = 0;
        
        for (int i = 0; i < ((iInputTotal > iImageTotal) ? iImageTotal : iInputTotal); i++) {
            if (sInput.charAt(i) != sImage.charAt(i)) {
                ++iDefectCount;
                if (iVerboseLevel > 0) {
                    for (int j = 1; j < iVerboseLevel; j++) {
                        if (i - j >= 0) {
                            if (sInput.charAt(i) == sImage.charAt(i - j)) {
                                --iDefectCount;
                                break;
                            }
                        }else if (i + j < iImageTotal) {
                            if (sInput.charAt(i) == sImage.charAt(i + j)) {
                                --iDefectCount;
                                break;
                            }
                        }
                    }
                }
            }
        }
        iDefectCount += (iImageTotal - iInputTotal);
        return ((float)iInputTotal - iDefectCount) / (float)iInputTotal * 100;
    }
    
}
