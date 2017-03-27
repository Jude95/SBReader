package com.jude.operators.peek;

import com.jude.Operator;
import com.jude.SBReader;
import com.jude.util.Judgement;

/**
 * Created by Jude on 3/27/17.
 */

public class PeekInteger implements Operator<Integer>{
    @Override
    public Integer execute(SBReader sbReader) {
        int start = sbReader.getPos();
        // find next number
        while (sbReader.testPos(start) && !Judgement.isNumber(sbReader.charAt(start))){
            start++;
        }
        int end = start + 1;
        while (sbReader.testPos(end) && Judgement.isNumber(sbReader.charAt(end))){
            end++;
        }
        return Integer.valueOf(sbReader.subString(start,end));
    }
}
