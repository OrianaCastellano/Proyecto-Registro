package com.mycompany.servletsm.Controllers;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class passwordController {
    
    public String getHast(byte[] inputBytes){
        String hashValue = "";
        
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(inputBytes);
            
            byte[] diggestBytes = messageDigest.digest();
            hashValue = DatatypeConverter.printHexBinary(diggestBytes).toUpperCase();} 
        
        catch (Exception e) { }
        
    return hashValue;}
    
    
}
