package com.xunluyaoyao.web.utils;

import java.util.regex.Pattern;

public class TestUtil {
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }
}
