package com.fishion.demo.ecframework;

import com.sunwayworld.casic.module.scm.scm.casicpurorder.dao.impl.CasicPurorderDaoImpl;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * @author : yuzq
 * @version V1.0
 * @Description: TODO
 * @date Date : 2019年07月22日 10:26
 */
public class TestDeleteByMethod {

    public static void main(String[] args) {
        CasicPurorderDaoImpl purorderDao = new CasicPurorderDaoImpl();
        System.out.println("执行开始");
//        purorderDao.deleteBy(Collections.emptyList(),"contractNo");
//        purorderDao.delete("123");
        purorderDao.deleteByIds(Collections.emptyList());
        System.out.println("执行结束");

    }
}
