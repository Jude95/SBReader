package com.jude.operators.read;

import com.jude.Operator;
import com.jude.SBReader;
import com.jude.domain.CharType;
import com.jude.util.Judgement;

/**
 * Created by Jude on 3/27/17.
 */

public class ReadTo implements Operator<String> {
    CharType charType;

    public ReadTo(CharType charType) {
        this.charType = charType;
    }

    @Override
    public String execute(SBReader sbReader) {
        int start = sbReader.getPos();
        int end = start;
        while (!Judgement.is(sbReader.charAt(end),charType)){
            end++;
            if (!sbReader.testPos(end)){
                return null;
            }
        }
        sbReader.setPos(end);
        return sbReader.subString(start,end);
    }
}
