/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocraccuracychecker;

import java.util.Vector;

/**
 *
 * @author Tharaka
 */
public class AccuracyRunner {
    
    public static float runAccuracyChecker(Vector vec_Input, Vector vec_Image, 
            int iCharacterVerboseLevel,int iWordVerboseLevel){
        float[] afAccuracyList = new float[vec_Input.size()];
        for (int i = 0; i < vec_Input.size(); i++) {
            if (i < vec_Image.size()) {
                afAccuracyList[i] = AccuracyChecker.checkAccuracy((String)vec_Input.get(i), 
                        (String)vec_Image.get(i), iCharacterVerboseLevel);
            }
            if (iWordVerboseLevel > 0) {
                float fVerboseValue = (float)0.0;
                for (int j = 0; j < iWordVerboseLevel; j++) {
                    if (i - j >= 0) {
                        fVerboseValue = AccuracyChecker.checkAccuracy((String)vec_Input.get(i), 
                            (String)vec_Image.get(i - j), iCharacterVerboseLevel);
                        if (afAccuracyList[i] < fVerboseValue) {
                            afAccuracyList[i] = fVerboseValue;
                        }
                    }
                    if (i + j < vec_Image.size()) {
                        fVerboseValue = AccuracyChecker.checkAccuracy((String)vec_Input.get(i), 
                            (String)vec_Image.get(i + j), iCharacterVerboseLevel);
                        if (afAccuracyList[i] < fVerboseValue) {
                            afAccuracyList[i] = fVerboseValue;
                        }
                    }
                }
            }
        }
        
        float fTotalAccuracy = 0;
        for (int i = 0; i < afAccuracyList.length; i++) {
            fTotalAccuracy += afAccuracyList[i];
        }
        return fTotalAccuracy / afAccuracyList.length;
    }
}
