package com.phaseThreeAssesment.eCommerceAssesment.Util;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

@Service
public class CryptoUtil {

    public static String getEncrypted(String input){
        return new String(Base64.encode(input.getBytes()));
    }

    public static String getDecrypted(String input){
        return new String(Base64.decode(input.getBytes()));
    }
}
