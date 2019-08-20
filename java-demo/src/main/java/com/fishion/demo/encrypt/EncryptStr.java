package com.fishion.demo.encrypt;

import com.sunwayworld.casic.framework.utils.CasicEncryptUtils;
import com.sunwayworld.framework.utils.EncryptUtils;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月25日 15:25
 */
public class EncryptStr {
    public static void main(String[] args) {

//        String  str = "123ABC@#$%^&*()";
//        String  str = "";
//        String  str = null;
        String str = "69qE+rSkjmixMPoiOfdrgqMHsgwAQAte";
        System.out.println("----------sourceStr----------" + str);
        EncryptBase64(str);

    }

    public static void EncryptDES(String str) {
        String secretStr = CasicEncryptUtils.DESEncrypt(str);
        String secretStr2 = CasicEncryptUtils.DESEncrypt(str);
        System.out.println("----------secretStr----------" + secretStr);

        System.out.println("----------secretStr1 == secretStr2 ----------" + secretStr.equals(secretStr2));

        String targetStr = CasicEncryptUtils.DESDecrypt(secretStr);
        System.out.println("----------targetStr----------" + targetStr);
    }

    public static void EncryptBase64(String str) {

        String secretStr = EncryptUtils.base64Encode(str);
        String secretStr2 = EncryptUtils.base64Encode(str);
        System.out.println("----------secretStr----------" + secretStr);

        System.out.println("----------secretStr1 == secretStr2 ----------" + secretStr.equals(secretStr2));

        String targetStr = EncryptUtils.base64Decode(secretStr);
        System.out.println("----------targetStr----------" + targetStr);
    }
}
