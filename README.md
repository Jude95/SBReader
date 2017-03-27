## SBReader
String 格式解析工具 ~~(StringBufferReader)~~ 。
支持字符流。可以方便的使用各种操作符来快速建立对文本数据的解析。

## Usage

```java
        SBReader sbReader = new SBReader("123456789");
        sbReader.execute(new Skip(3));
        String text = sbReader.execute(new Peek(3));
```
操作符数量众多 ~~(暂时很少)~~ ,功能丰富,任意拓展

>
    Back 回退
    Reset

    Peek 查看
    PeekInteger 查看下一个数字
    PeekWord 查看下一个单词
    PeekSpecific 查看下一个指定类型字符


    Read 读取
    ReadFloat  读取Float
    ReadInteger
    ReadLine  读取本行
    ReadTil  读取直到
    ReadTo

    Skip 跳过
    SkipLine  跳过本行
    SkipNextNumber  跳到下一个数字开始处
    SkipNextWord  跳到下一个单词开始处
    SkipTil  调到下一个指定字符串
    SkipTo

## Sample
```java
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
```
