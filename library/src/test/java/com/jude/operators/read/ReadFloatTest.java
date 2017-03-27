package com.jude.operators.read;

import com.jude.SBReader;
import com.jude.operators.peek.Peek;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class ReadFloatTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("123.456abc789");
        Assert.assertEquals(123.456,(double)sbReader.execute(new ReadFloat()),0.001);
        Assert.assertEquals("abc",sbReader.execute(new Peek(3)));
    }

    @Test
    public void testNull(){
        SBReader sbReader = new SBReader("abcd123");
        try {
            sbReader.execute(new ReadFloat());
        }catch (IllegalStateException e){
            return;
        }
        Assert.fail();
    }

    @Test
    public void testIgnore(){
        SBReader sbReader = new SBReader("7,8,9.123");
        Assert.assertEquals(789.123,(double)sbReader.execute(new ReadFloat(',')),0.001);
    }

    @Test
    public void testIgnore2(){
        SBReader sbReader = new SBReader("5&6,.78@9");
        Assert.assertEquals(56.789,(double)sbReader.execute(new ReadFloat(',','*','&','@')),0.001);
    }

    @Test
    public void testIgnore3(){
        SBReader sbReader = new SBReader("5&6.78@9.123");
        Assert.assertEquals(56.789,(double)sbReader.execute(new ReadFloat(',','*','&','@')),0.001);
    }
}