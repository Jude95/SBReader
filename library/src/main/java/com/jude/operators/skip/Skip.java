package com.jude.operators.skip;

import com.jude.Operator;
import com.jude.SBReader;

/**
 * Created by Jude on 3/27/17.
 */

public class Skip implements Operator<Boolean> {
    int count;

    public Skip(int count) {
        this.count = count;
    }

    @Override
    public Boolean execute(SBReader sbReader) {
        if (sbReader.testPos(sbReader.getPos()+count)){
            sbReader.setPos(sbReader.getPos()+count);
            return true;
        }
        return false;
    }
}
