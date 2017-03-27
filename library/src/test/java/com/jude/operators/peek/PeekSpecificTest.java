package com.jude.operators.peek;

import com.jude.SBReader;
import com.jude.domain.CharType;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class PeekSpecificTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("123a456b789c");
        Assert.assertEquals("abc",sbReader.execute(new PeekSpecific(3, CharType.Letter)));
    }

    @Test
    public void testMix(){
        SBReader sbReader = new SBReader("123a #456b789c");
        Assert.assertEquals("a#b",sbReader.execute(new PeekSpecific(3, CharType.Letter,CharType.Symbol)));
    }
}