package com.demo.project.mvc.common.passwordGenerator;

import java.util.Random;

/**
 * Created by saif on 4/7/15.
 */
public class RandomPasswordGenerator {
    private static final String ALPHA_CAPS  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHA_SMALL   = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUM     = "0123456789";
    public static String generatePassword(int minLen, int maxLen) {
        if(minLen > maxLen)
        {
            throw new IllegalArgumentException("Min. Length > Max. Length!");
        }
        Random rnd = new Random();
        int len = rnd.nextInt(maxLen - minLen + 1) + minLen;
        char[] password = new char[len];
        for(int index = 0; index < len; index++) {
            int randType=rnd.nextInt(3);
            if(randType==0)
            {
                password[index] = ALPHA_CAPS.charAt(rnd.nextInt(ALPHA_CAPS.length()));
            }
            else if(randType==1)
            {
                password[index] = NUM.charAt(rnd.nextInt(NUM.length()));
            }

            else if(randType==2)
            {
                password[index] = ALPHA_SMALL.charAt(rnd.nextInt(ALPHA_SMALL.length()));
            }
        }
        String pass=new String(password);
        return pass;
    }
    private static int getNextIndex(Random rnd, int len, char[] pswd) {
        int index = rnd.nextInt(len);
        while(pswd[index = rnd.nextInt(len)] != 0);
        return index;
    }
}
