package com.example.jsmybatis_pagingsearching.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeStampConverter {

    public static String formatTimestamp(Timestamp timestamp, SimpleDateFormat dateFormat) {
        Date date = new Date(timestamp.getTime());
        return dateFormat.format(date);
    }
}
