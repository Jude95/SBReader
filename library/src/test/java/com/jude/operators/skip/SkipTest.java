package com.jude.operators.skip;

import com.jude.SBReader;
import com.jude.operators.peek.Peek;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class SkipTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("123456789");
        sbReader.execute(new Skip(3));
        Assert.assertEquals("456",sbReader.execute(new Peek(3)));
    }

}