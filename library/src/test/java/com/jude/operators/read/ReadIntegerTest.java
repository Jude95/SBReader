package com.jude.operators.read;

import com.jude.SBReader;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class ReadIntegerTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("123456\n789");
        Assert.assertEquals(123456,(long)sbReader.execute(new ReadInteger()));
    }

    @Test
    public void testNull(){
        SBReader sbReader = new SBReader("abcd123");
        try {
            sbReader.execute(new ReadInteger());
        }catch (IllegalStateException e){
            return;
        }
        Assert.fail();
    }

    @Test
    public void testIgnore(){
        SBReader sbReader = new SBReader("123,456,789");
        Assert.assertEquals(123456789,(long)sbReader.execute(new ReadInteger(',')));
    }

    @Test
    public void testIgnore2(){
        SBReader sbReader = new SBReader("123,4*5&6,78@9");
        Assert.assertEquals(123456789,(long)sbReader.execute(new ReadInteger(',','*','&','@')));
    }
}