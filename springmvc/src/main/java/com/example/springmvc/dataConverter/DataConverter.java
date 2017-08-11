package com.example.springmvc.dataConverter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class DataConverter extends AbstractHttpMessageConverter<MyObj>{


    public DataConverter(){
        super(new MediaType("application","abc",Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return MyObj.class.isAssignableFrom(aClass);
    }

    @Override
    protected MyObj readInternal(Class<? extends MyObj> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return null;
    }

    @Override
    protected void writeInternal(MyObj myObj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

    }
}
