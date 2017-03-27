package com.jude.operators.read;

import com.jude.SBReader;
import com.jude.domain.LocationType;
import com.jude.operators.peek.Peek;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class ReadTilTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("123456789");
        Assert.assertEquals("123",sbReader.execute(new ReadTil("456")));
        Assert.assertEquals("456",sbReader.execute(new Peek(3)));
    }

    @Test
    public void testAfter(){
        SBReader sbReader = new SBReader("123456789");
        Assert.assertEquals("123456",sbReader.execute(new ReadTil("456", LocationType.After)));
        Assert.assertEquals("789",sbReader.execute(new Peek(3)));
    }

    @Test
    public void testNull(){
        SBReader sbReader = new SBReader("123456789");
        Assert.assertEquals(null,sbReader.execute(new ReadTil("abc", LocationType.After)));
        Assert.assertEquals("123",sbReader.execute(new Peek(3)));
    }
}