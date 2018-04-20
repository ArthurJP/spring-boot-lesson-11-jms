package com.jp.serializer;


import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * Created by 张俊鹏 on 4/20/2018
 */
public class ObjectSerializer implements Serializer<Object> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Object data) {
        System.out.println( "topic = " + topic );
        System.out.println( "data = " + data );

        byte[] dataArray = null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream( outputStream );
            objectOutputStream.writeObject( data );
            dataArray=outputStream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException( e );
        }

        return dataArray;
    }

    @Override
    public void close() {

    }
}
