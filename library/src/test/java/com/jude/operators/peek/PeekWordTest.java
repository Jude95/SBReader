package com.jude.operators.peek;

import com.jude.SBReader;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class PeekWordTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("456abc789d");
        Assert.assertEquals("abc",sbReader.execute(new PeekWord()));
    }
}