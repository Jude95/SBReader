package com.jude.operators.skip;

import com.jude.SBReader;
import com.jude.domain.LocationType;
import com.jude.operators.peek.Peek;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class SkipTilTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("123456789");
        sbReader.execute(new SkipTil("456"));
        Assert.assertEquals("456",sbReader.execute(new Peek(3)));
    }

    @Test
    public void testLimit(){
        SBReader sbReader = new SBReader("1234567890");
        Assert.assertEquals(false,sbReader.execute(new SkipTil("789", 6)));
        Assert.assertEquals("123",sbReader.execute(new Peek(3)));
    }

    @Test
    public void testAfter(){
        SBReader sbReader = new SBReader("123456789");
        sbReader.execute(new SkipTil("456", LocationType.After));
        Assert.assertEquals("789",sbReader.execute(new Peek(3)));
    }

    @Test
    public void testNull(){
        SBReader sbReader = new SBReader("123456789");
        Assert.assertEquals(false,sbReader.execute(new SkipTil("abc", LocationType.After)));
        Assert.assertEquals("123",sbReader.execute(new Peek(3)));
    }
}