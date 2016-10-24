package com.juzi;

import com.juzi.listener.KafkaMessageListener;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhiWei.Yang2 on 2016/10/24.
 */
public class RevicverTest {
    @Autowired
    private KafkaMessageListener kafkaMessageListener;

    @Test
    public void test() {

    }
}
