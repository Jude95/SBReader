package com.jude.operators.skip;

import com.jude.Operator;
import com.jude.SBReader;
import com.jude.util.Judgement;

/**
 * Created by Jude on 3/27/17.
 */

public class SkipNextNumber implements Operator<Boolean> {

    @Override
    public Boolean execute(SBReader sbReader) {
        int start = sbReader.getPos();
        // find next word
        while (!Judgement.isNumber(sbReader.charAt(start))){
            start++;
            if (!sbReader.testPos(start)){
                return false;
            }
        }
        int end = start + 1;
        // begin record
        while (sbReader.testPos(end) && Judgement.isNumber(sbReader.charAt(end))){
            end++;
        }
        sbReader.setPos(end);
        return true;
    }
}
