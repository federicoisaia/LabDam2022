package com.mdgz.dam.labdam2022.data;


import androidx.room.TypeConverter;

import java.time.LocalDate;

public class LocalDateConverter {
    @TypeConverter
    public static String fromDate(LocalDate value) {
        return (value == null ? null : value.toString());
    }

    @TypeConverter
    public static LocalDate dateFromLong(String value) {
        return ((value == null ? null : LocalDate.parse(value)));
    }
}
