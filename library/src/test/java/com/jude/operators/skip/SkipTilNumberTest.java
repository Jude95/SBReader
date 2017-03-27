package com.jude.operators.skip;

import com.jude.SBReader;
import com.jude.operators.peek.Peek;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class SkipTilNumberTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("abc123defg");
        sbReader.execute(new SkipNextNumber());
        Assert.assertEquals("def",sbReader.execute(new Peek(3)));
    }

    @Test
    public void testNull(){
        SBReader sbReader = new SBReader("abcdefg");
        Assert.assertEquals(false,sbReader.execute(new SkipNextNumber()));
        Assert.assertEquals("abc",sbReader.execute(new Peek(3)));
    }
}