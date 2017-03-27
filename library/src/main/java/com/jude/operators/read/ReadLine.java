package com.jude.operators.read;

import com.jude.Operator;
import com.jude.SBReader;

/**
 * Created by Jude on 3/27/17.
 */

public class ReadLine implements Operator<String> {
    @Override
    public String execute(SBReader sbReader) {
        int start = sbReader.getPos();
        int end = start;
        while (sbReader.charAt(end)!='\n'){
            end++;
            if (!sbReader.testPos(end)){
                return sbReader.subString(start,--end);
            }
        }
        // skip the char '\n'
        sbReader.setPos(end+1);
        return sbReader.subString(start,end);
    }
}
