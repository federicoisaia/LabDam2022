package com.mdgz.dam.labdam2022.data;


import androidx.room.TypeConverter;

import java.time.Instant;
import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Long fromDate(Date value) {
        return (value == null ? null : value.toInstant().toEpochMilli());
    }

    @TypeConverter
    public static Date dateFromLong(Long value) {
        return (value == null ? null : Date.from(Instant.ofEpochMilli(value)));
    }
}
