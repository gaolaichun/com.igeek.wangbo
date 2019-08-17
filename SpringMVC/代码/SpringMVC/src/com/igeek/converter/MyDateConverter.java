package com.igeek.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 60915
 * \* Date: 2019/8/17
 * \* Time: 22:10
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class MyDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}