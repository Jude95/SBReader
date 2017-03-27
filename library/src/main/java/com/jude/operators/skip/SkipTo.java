package com.jude.operators.skip;

import com.jude.Operator;
import com.jude.SBReader;
import com.jude.domain.CharType;
import com.jude.util.Judgement;

/**
 * Created by Jude on 3/27/17.
 */

public class SkipTo implements Operator<Boolean>{
    CharType charType;

    public SkipTo(CharType charType) {
        this.charType = charType;
    }

    @Override
    public Boolean execute(SBReader sbReader) {
        int pos = sbReader.getPos();
        while (!Judgement.is(sbReader.charAt(pos),charType)){
            pos++;
            if (!sbReader.testPos(pos)){
                return false;
            }
        }
        sbReader.setPos(pos);
        return true;
    }
}
