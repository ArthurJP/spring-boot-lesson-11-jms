package com.jp.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by 张俊鹏 on 4/10/2018
 */
public class Producer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Properties properties = new Properties();

        properties.setProperty( "bootstrap.servers","localhost:9092" );
        properties.put( "key.serializer",StringSerializer.class );
        properties.put( "value.serializer",StringSerializer.class );

        KafkaProducer kafkaProducer=new KafkaProducer( properties );
        ProducerRecord<String,String> producerRecord=new ProducerRecord<>( "jp",0,"message","大家好" );
        Future<RecordMetadata> future = kafkaProducer.send( producerRecord );

        RecordMetadata recordMetadata=future.get();
        System.out.println( "recordMetadata = " + recordMetadata );
    }

}
