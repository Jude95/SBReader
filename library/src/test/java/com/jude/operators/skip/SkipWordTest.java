package com.jude.operators.skip;

import com.jude.SBReader;
import com.jude.operators.peek.Peek;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class SkipWordTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("123abc789");
        sbReader.execute(new SkipNextWord());
        Assert.assertEquals("789",sbReader.execute(new Peek(3)));
    }

    @Test
    public void testNull(){
        SBReader sbReader = new SBReader("123456789");
        Assert.assertEquals(false,sbReader.execute(new SkipNextWord()));
        Assert.assertEquals("123",sbReader.execute(new Peek(3)));
    }
}