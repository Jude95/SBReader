package com.jude.operators.peek;

import com.jude.SBReader;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */
public class PeekIntegerTest {
    @Test
    public void testCommon(){
        SBReader sbReader = new SBReader("ssda456b789c");
        Assert.assertEquals(456,(long)sbReader.execute(new PeekInteger()));
    }
}