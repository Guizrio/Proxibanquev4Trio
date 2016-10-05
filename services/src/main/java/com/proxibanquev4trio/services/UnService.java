package com.proxibanquev4trio.services;

import com.proxibanquev4trio.dao.UnDao;

/**
 * Created by Guillaume on 06/10/2016.
 */
public class UnService {

    private String name = "monService";
    UnDao unDao;

    public void doSomething(){

        System.out.println("))))))))))))))))))))))))))))))))))))))))))))))");
        unDao = new UnDao();
        unDao.getClientName();
        System.out.println("))))))))))))))))))))))))))))))))))))))))))))))");
    }

}
