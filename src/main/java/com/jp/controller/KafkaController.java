package com.jp.controller;

import com.jp.domain.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 张俊鹏 on 4/20/2018
 */
@RestController
public class KafkaController {
    private final KafkaTemplate<String,Object> kafkaTemplate;

//    构造注入，使用这种方式可以不写注解
//    @Autowired
    public KafkaController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/message/send")
    public String sendMessage(@RequestParam String msg) {
        kafkaTemplate.send( "jp", msg );
        return msg;
    }

    @PostMapping("/user/save")
    public User saveUser(@RequestBody User user){
        kafkaTemplate.send( "jp-1",user );
        return user;
    }
}
