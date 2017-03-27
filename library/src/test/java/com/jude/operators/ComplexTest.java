package com.jude.operators;

import com.jude.SBReader;
import com.jude.domain.CharType;
import com.jude.operators.read.ReadFloat;
import com.jude.operators.read.ReadInteger;
import com.jude.operators.read.ReadTil;
import com.jude.operators.skip.SkipLine;
import com.jude.operators.skip.SkipTo;

import org.junit.Test;

/**
 * Created by Jude on 3/27/17.
 */

public class ComplexTest {

    @Test
    public void testComplex(){
        SBReader sbReader = new SBReader(
                "CPU usage from 93776ms to 26591ms ago (2017-03-27 17:55:24.469 to 2017-03-27 17:56:31.654):\n" +
                "  6.8% 4245/com.sohu.inputmethod.sogou: 3.6% user + 3.2% kernel\n" +
                "  6.3% 2942/system_server: 4% user + 2.2% kernel / faults: 709 minor\n" +
                "  4.1% 3618/com.android.systemui: 2.7% user + 1.3% kernel / faults: 378 minor\n" +
                "  3.5% 23878/com.tencent.mobileqq: 1.6% user + 1.8% kernel / faults: 81 minor\n" +
                "  2.9% 580/surfaceflinger: 1.3% user + 1.6% kernel\n" +
                "  2.4% 24262/com.tencent.mobileqq:smartdevice: 0.8% user + 1.5% kernel / faults: 187 minor\n" +
                "  1.9% 2726/com.xiangha_google: 1.3% user + 0.5% kernel / faults: 121 minor\n" +
                "  1.8% 26539/com.speedsoftware.rootexplorer: 0.9% user + 0.8% kernel");

        int beginTime,endTime;

        sbReader.execute(new SkipTo(CharType.Number));
        beginTime = sbReader.execute(new ReadInteger());
        sbReader.execute(new SkipTo(CharType.Number));
        endTime = sbReader.execute(new ReadInteger());

        System.out.println("beginTime:"+beginTime);
        System.out.println("endTime:"+endTime);

        while (sbReader.execute(new SkipLine())){
            float percentTotal;
            int pid;
            String name;
            float percentUser,percentKernel;

            sbReader.execute(new SkipTo(CharType.Number));
            percentTotal = sbReader.execute(new ReadFloat());

            sbReader.execute(new SkipTo(CharType.Number));
            pid = sbReader.execute(new ReadInteger());
            name = sbReader.execute(new ReadTil(":"));

            sbReader.execute(new SkipTo(CharType.Number));
            percentUser = sbReader.execute(new ReadFloat());
            sbReader.execute(new SkipTo(CharType.Number));
            percentKernel = sbReader.execute(new ReadFloat());

            System.out.println("pid:"+pid+"  name:"+name+"  percentTotal:"+percentTotal+"  percentUser:"+percentUser+"  percentKernel:"+percentKernel);
        }
    }
}
