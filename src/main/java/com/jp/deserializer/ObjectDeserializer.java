package com.jp.deserializer;


import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * Created by 张俊鹏 on 4/20/2018
 */
public class ObjectDeserializer implements Deserializer<Object> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        Object object=null;

        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream( data );

        try {
            ObjectInputStream objectInputStream=new ObjectInputStream( byteArrayInputStream );
            object = objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException( e );
        }

        System.out.println( "topic = " + topic );
        System.out.println( "object = " + object );

        return object;
    }

    @Override
    public void close() {

    }
}
