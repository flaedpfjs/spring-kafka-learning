package com.juzi.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.kafka.listener.BatchAcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ZhiWei.Yang2 on 2016/10/24.
 */
@Component("kafkaMessageListener")
public class KafkaMessageListener implements BatchAcknowledgingMessageListener<String, Object>,ApplicationContextAware {

    /*
  * 工作线程池
  */
    private final ExecutorService workers = Executors.newCachedThreadPool();

    private ApplicationContext applicationContext;


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void onMessage(List<ConsumerRecord<String, Object>> data, Acknowledgment acknowledgment) {
        // 提交到工作线程池处理
 //       Future<String> committedTask = workers.submit(applicationContext.getBean(IndexedDataJob.class, data, acknowledgment));
        System.out.println(data);
    }
}