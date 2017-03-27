package com.jude.operators.back;

import com.jude.SBReader;
import com.jude.operators.peek.Peek;
import com.jude.operators.skip.Skip;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class BackTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("123456789");
        sbReader.execute(new Skip(5));
        sbReader.execute(new Back(3));
        Assert.assertEquals("345",sbReader.execute(new Peek(3)));
    }
    @Test
    public void testHalf(){
        SBReader sbReader = new SBReader("123456");
        Assert.assertEquals(false,sbReader.execute(new Back(3)));
        Assert.assertEquals("123",sbReader.execute(new Peek(3)));
    }
}