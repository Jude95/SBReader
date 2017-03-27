package com.jude.operators.read;

import com.jude.Operator;
import com.jude.SBReader;
import com.jude.util.Judgement;

/**
 * Created by Jude on 3/27/17.
 */

public class ReadFloat implements Operator<Float> {
    char[] ignoreChar;

    public ReadFloat() {
    }

    public ReadFloat(char... ignoreChar) {
        this.ignoreChar = ignoreChar;
    }

    @Override
    public Float execute(SBReader sbReader) {
        int start = sbReader.getPos();
        if (!Judgement.isNumber(sbReader.charAt(start))){
            throw new IllegalStateException("current pos is not a number");
        }
        int end = start;
        float numberInteger = 0;
        float numberDecimal = 0;
        int power = 0;
        char temp;
        boolean decimal = false;
        while (sbReader.testPos(end) && (Judgement.isNumber(temp = sbReader.charAt(end)) || (temp == '.' && !decimal) || isIgnoreChar(temp))){
            if (Judgement.isNumber(temp = sbReader.charAt(end))){
                if (decimal){
                    // 计算小数
                    power++;
                    numberDecimal+=((temp -'0')*Math.pow(10,-power));
                }else {
                    // 计算整数
                    numberInteger*=10;
                    numberInteger+=(temp-'0');
                }
            }else if (temp == '.'){
                decimal = true;
            }
            end++;
        }
        sbReader.setPos(end);
        return numberInteger+numberDecimal;
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
