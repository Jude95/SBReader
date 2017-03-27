package com.jude.operators.peek;

import com.jude.Operator;
import com.jude.SBReader;

/**
 * Created by Jude on 3/27/17.
 */

public class Peek implements Operator<String> {
    int count;

    public Peek(int count) {
        this.count = count;
    }

    @Override
    public String execute(SBReader sbReader) {
        if (sbReader.testPos(sbReader.getPos()+count)){
            return sbReader.subString(sbReader.getPos(),sbReader.getPos()+count);
        }else {
            return sbReader.subString(sbReader.getPos(),sbReader.length());
        }
    }
}
