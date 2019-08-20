package com.fishion.demo.base;

import com.sunwayworld.framework.utils.NumberUtils;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年05月24日 15:02
 */
public class TestDouble {
    public static void main(String[] args) {
        Double d = 3.4500001;

        System.out.println(NumberUtils.toQuantityDouble(d) + "2323");

        Double e = 3.4499999;
        Double f = 3.4500001;
        System.out.println(d.equals(e));
        System.out.println(d.equals(f));
    }
}
