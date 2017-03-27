package com.jude.operators.read;

import com.jude.SBReader;
import com.jude.domain.CharType;
import com.jude.operators.peek.Peek;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class ReadToTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("123456abc");
        Assert.assertEquals("123456",sbReader.execute(new ReadTo(CharType.Letter)));
        Assert.assertEquals("abc",sbReader.execute(new Peek(3)));
    }

    @Test
    public void testNull(){
        SBReader sbReader = new SBReader("123456789");
        Assert.assertEquals(null,sbReader.execute(new ReadTo(CharType.Letter)));
        Assert.assertEquals("123",sbReader.execute(new Peek(3)));
    }
}