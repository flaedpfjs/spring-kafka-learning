package com.juzi;

import com.juzi.consumer.RecevierMsg;
import com.juzi.producer.SenderMsg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by ZhiWei.Yang2 on 2016/10/20.
 */

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SpringBootKafkaApplicationTests {

    @Autowired
    private SenderMsg senderMsg;

    @Autowired
    private RecevierMsg recevierMsg;

    @Test
    public void sendTest() throws InterruptedException {
        senderMsg.sendMsg("helloworld.t","ni dgsdfg!");
        recevierMsg.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void receiverTest() throws InterruptedException {
        recevierMsg.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
