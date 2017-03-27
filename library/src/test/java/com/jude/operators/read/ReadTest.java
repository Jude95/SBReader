package com.jude.operators.read;

import com.jude.SBReader;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class ReadTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("123456789");
        Assert.assertEquals("123",sbReader.execute(new Read(3)));
    }
    @Test
    public void testHalf(){
        SBReader sbReader = new SBReader("123");
        Assert.assertEquals("123",sbReader.execute(new Read(6)));
    }
}