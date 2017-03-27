package com.jude.operators.peek;

import com.jude.SBReader;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class PeekTest {

    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("123456789");
        Assert.assertEquals("123",sbReader.execute(new Peek(3)));
    }
}