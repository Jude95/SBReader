package com.jude;

/**
 * Created by Jude on 3/27/17.
 */

public interface StringSource {
    /**
     * 当需要更多字符时，重复调用此方法直到SBReader饱和。
     * @return 返回null表示以读取结束。
     */
    String read();
}
