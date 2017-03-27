package com.jude.operators.back;

import com.jude.Operator;
import com.jude.SBReader;

/**
 * Created by Jude on 3/27/17.
 */

public class Reset implements Operator<Void>{
    @Override
    public Void execute(SBReader sbReader) {
        sbReader.setPos(0);
        return null;
    }
}
