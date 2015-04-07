package com.demo.project.mvc.common.encryptor;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by saif on 4/7/15.
 */
@Component
public class RandomEncryptor {

    @Autowired
    private StandardPBEStringEncryptor standardPBEStringEncryptor;

    @Value("${password.encryptKey}")
    private String encryptKey;


    public String encrypt(String text){
        try {

            String encryptionKey = encryptKey;
            if(!standardPBEStringEncryptor.isInitialized()){
                standardPBEStringEncryptor.setPassword(encryptionKey);
                standardPBEStringEncryptor.setStringOutputType("hexadecimal");
            }
            return standardPBEStringEncryptor.encrypt(text);
        }
        catch (Exception e){

        }
        return "";
    }
    public String decrypt(String text){
        try {
            String encryptionKey = encryptKey;
            if(!standardPBEStringEncryptor.isInitialized()){
                standardPBEStringEncryptor.setPassword(encryptionKey);
                standardPBEStringEncryptor.setStringOutputType("hexadecimal");
            }
            return standardPBEStringEncryptor.decrypt(text);
        }
        catch (Exception e){

        }
        return "";
    }
    public Boolean isEqual(String encryptedText , String text ){
        try {
            String encryptionKey = encryptKey;
            if(!standardPBEStringEncryptor.isInitialized()){
                standardPBEStringEncryptor.setPassword(encryptionKey);
                standardPBEStringEncryptor.setStringOutputType("hexadecimal");
            }
            return this.decrypt(encryptedText).equals(text);
        }
        catch (Exception e){

        }
        return false;
    }
}
