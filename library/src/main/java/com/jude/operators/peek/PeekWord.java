package com.jude.operators.peek;

import com.jude.Operator;
import com.jude.SBReader;
import com.jude.util.Judgement;

/**
 * Created by Jude on 3/27/17.
 */

public class PeekWord implements Operator<String>{
    @Override
    public String execute(SBReader sbReader) {
        int start = sbReader.getPos();
        // find next word
        while (sbReader.testPos(start) && !Judgement.isLetter(sbReader.charAt(start))){
            start++;
        }
        int end = start + 1;
        // begin record
        while (sbReader.testPos(end) && Judgement.isLetter(sbReader.charAt(end))){
            end++;
        }
        return sbReader.subString(start,end);
    }
}
