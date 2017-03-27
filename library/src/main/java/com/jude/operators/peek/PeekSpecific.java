package com.jude.operators.peek;

import com.jude.Operator;
import com.jude.SBReader;
import com.jude.domain.CharType;
import com.jude.util.Judgement;

/**
 * Created by Jude on 3/27/17.
 */

public class PeekSpecific implements Operator<String> {
    CharType[] charTypes;
    int count;
    public PeekSpecific(int count, CharType... charTypes) {
        this.charTypes = charTypes;
        this.count = count;
    }

    @Override
    public String execute(SBReader sbReader) {
        int pos = sbReader.getPos();
        char[] chars = new char[count];
        int index = 0;
        char temp;
        while (index < count && sbReader.testPos(pos)){
            for (CharType charType : charTypes) {
                temp = sbReader.charAt(pos);
                if (Judgement.is(temp,charType)){
                    chars[index] = temp;
                    index++;
                }
            }
            pos++;
        }
        return new String(chars,0,index);
    }
}
