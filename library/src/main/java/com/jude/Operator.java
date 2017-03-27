package com.jude;

/**
 * Created by Jude on 3/27/17.
 */

public interface Operator<Return> {
    Return execute(SBReader sbReader);
}
