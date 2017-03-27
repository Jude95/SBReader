package com.jude.operators.read;

import com.jude.Operator;
import com.jude.SBReader;

/**
 * Created by Jude on 3/27/17.
 */

public class Read implements Operator<String>{
    int count;

    public Read(int count) {
        this.count = count;
    }

    @Override
    public String execute(SBReader sbReader) {
        int start = sbReader.getPos();
        int end = start + count;
        if (sbReader.testPos(end)){
            return sbReader.subString(start,end);
        }else {
            return sbReader.subString(start,sbReader.length());
        }
    }
}
