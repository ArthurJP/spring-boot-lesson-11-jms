package com.jp.kafka;

import com.jp.domain.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by 张俊鹏 on 4/20/2018
 */
@Component
public class ConsumerListener {

    @KafkaListener(topics = "jp")
    public void consumer(String msg){
        System.out.println(msg);
    }

    @KafkaListener(topics = "jp-1")
    public void consumer(User user){
        System.err.println( "user = " + user );
    }
}
