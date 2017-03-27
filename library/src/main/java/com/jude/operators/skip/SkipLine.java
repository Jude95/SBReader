package com.jude.operators.skip;

import com.jude.Operator;
import com.jude.SBReader;

/**
 * Created by Jude on 3/27/17.
 */

public class SkipLine implements Operator<Boolean> {
    @Override
    public Boolean execute(SBReader sbReader) {
        int pos = sbReader.getPos();
        while (sbReader.charAt(pos)!='\n'){
            pos++;
            if (!sbReader.testPos(pos)){
                return false;
            }
        }
        sbReader.setPos(++pos);
        return true;
    }
}
