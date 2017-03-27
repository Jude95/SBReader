package com.jude.util;

import com.jude.domain.CharType;

/**
 * Created by Jude on 3/27/17.
 */

public class Judgement {

    public static boolean is(char c, CharType type){
        switch (type){
            case Letter:return isLetter(c);
            case Number:return isNumber(c);
            case Space:return isSpace(c);
            case Symbol:return !isLetter(c)&&!isNumber(c)&&!isSpace(c);
            default:throw new IllegalArgumentException();
        }
    }

    public static boolean isLetter(char c){
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }

    public static boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }

    public static boolean isSpace(char c){
        return (c == ' ') || (c == '\n') || (c == '\f') || (c == '\r') || (c == '\t');
    }
}
