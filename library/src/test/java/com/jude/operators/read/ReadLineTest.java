package com.jude.operators.read;

import com.jude.SBReader;
import com.jude.operators.peek.Peek;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class ReadLineTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("123456\n789");
        Assert.assertEquals("123456",sbReader.execute(new ReadLine()));
        Assert.assertEquals("789",sbReader.execute(new Peek(3)));
    }

    @Test
    public void testNull(){
        SBReader sbReader = new SBReader("123456");
        Assert.assertEquals("123456",sbReader.execute(new ReadLine()));
    }
}