package com.fishion.demo.encrypt;

import com.sunwayworld.casic.framework.utils.CasicEncryptUtils;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年04月25日 15:25
 */
public class EncryptStr2 {
    public static void main(String[] args) {

        String str = "123ABC@#$%^&*()";
        System.out.println("----------sourceStr----------" + str);

        String secretStr = CasicEncryptUtils.DESEncrypt(str);
        String secretStr2 = CasicEncryptUtils.DESEncrypt(str);
        System.out.println("----------secretStr----------" + secretStr);

        System.out.println("----------secretStr1 == secretStr2 ----------" + secretStr.equals(secretStr2));

        String targetStr = CasicEncryptUtils.DESDecrypt(secretStr);
        System.out.println("----------targetStr----------" + targetStr);

    }
}
