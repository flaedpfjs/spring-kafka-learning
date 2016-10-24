package com.juzi.job;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("indexedDataJob")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class IndexedDataJob {

    private static final Logger logger = LoggerFactory.getLogger(IndexedDataJob.class);


}
