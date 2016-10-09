package com.proxibanquev4trio.services.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Guillaume on 09/10/2016.
 */
@Aspect
@Component
public class VirementAspect {

    private static Logger logger = LoggerFactory.getLogger(VirementAspect.class);


    @Before("@annotation(com.proxibanquev4trio.logging.Loggable)")
    public void myAdvice(){
        logger.info("On a appellé une méthode annoté avec loggable !!!");
    }

}
