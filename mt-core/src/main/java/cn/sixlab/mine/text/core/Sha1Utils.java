/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/8 21:28
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.mine.text.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha1Utils {
    private static final char[] HEX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    
    private static MessageDigest getSha1Digest() {
        try {
            return MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException var1) {
            throw new RuntimeException(var1.getMessage());
        }
    }
    
    public static byte[] sha(byte[] data) {
        return getSha1Digest().digest(data);
    }
    
    public static byte[] sha(String data) {
        return sha(data.getBytes());
    }
    
    public static String shaHex(String data) {
        return new String(encode(sha(data)));
    }
    
    public static char[] encode(byte[] bytes) {
        int nBytes = bytes.length;
        char[] result = new char[2 * nBytes];
        int j = 0;
        
        for (int i = 0; i < nBytes; ++i) {
            result[j++] = HEX[(240 & bytes[i]) >>> 4];
            result[j++] = HEX[15 & bytes[i]];
        }
        
        return result;
    }
    
}
