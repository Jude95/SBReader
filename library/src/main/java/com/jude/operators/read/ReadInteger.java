package com.jude.operators.read;

import com.jude.Operator;
import com.jude.SBReader;
import com.jude.util.Judgement;

/**
 * Created by Jude on 3/27/17.
 */

public class ReadInteger implements Operator<Integer> {
    char[] ignoreChar;

    public ReadInteger() {
    }

    public ReadInteger(char... ignoreChar) {
        this.ignoreChar = ignoreChar;
    }

    @Override
    public Integer execute(SBReader sbReader) {
        int start = sbReader.getPos();
        if (!Judgement.isNumber(sbReader.charAt(start))){
            throw new IllegalStateException("current pos is not a number");
        }
        int end = start;
        int number = 0;
        char temp;
        while (sbReader.testPos(end) && (Judgement.isNumber(temp = sbReader.charAt(end)) || isIgnoreChar(temp))){
            if (Judgement.isNumber(temp = sbReader.charAt(end))){
                number*=10;
                number+=(temp-'0');
            }
            end++;
        }
        sbReader.setPos(end);
        return number;
    }

    boolean isIgnoreChar(char c){
        if (ignoreChar == null )return false;
        for (char c1 : ignoreChar) {
            if (c == c1){
                return true;
            }
        }
        return false;
    }
}
