package com.jude;

import java.util.Arrays;

public class SBReader {
    char[] value;
    int count;
    StringSource source;
    int pos = 0;

    private static final int MAX_ARRAY_SIZE = 2147483639;


    public SBReader(String origin) {
        initLength(origin.length());
        append(origin);
    }

    public SBReader(StringSource originSource) {
        this(originSource,64);
    }

    public SBReader(StringSource originSource, int expectLength) {
        initLength(expectLength);
        this.source = originSource;
    }

    private void initLength(int length) {
        this.value = new char[length];
    }

    public int length() {
        return this.count;
    }

    private int capacity() {
        return this.value.length;
    }

    private void ensureCapacity(int newSize) {
        if (newSize > 0) {
            this.ensureCapacityInternal(newSize);
        }
    }

    private void ensureCapacityInternal(int newSize) {
        if (newSize - this.value.length > 0) {
            this.value = Arrays.copyOf(this.value, this.newCapacity(newSize));
        }
    }

    private int newCapacity(int newSize) {
        int doubleSize = (this.value.length << 1) + 2;
        if (doubleSize - newSize < 0) {
            doubleSize = newSize;
        }

        return doubleSize > 0 && MAX_ARRAY_SIZE - doubleSize >= 0 ? doubleSize : this.hugeCapacity(newSize);
    }

    private int hugeCapacity(int newSize) {
        if (MAX_ARRAY_SIZE - newSize < 0) {
            throw new OutOfMemoryError();
        } else {
            return newSize > MAX_ARRAY_SIZE ? newSize : MAX_ARRAY_SIZE;
        }
    }

    public void setLength(int length) {
        if (length < 0) {
            throw new StringIndexOutOfBoundsException(length);
        } else {
            this.ensureCapacityInternal(length);
            if (this.count < length) {
                Arrays.fill(this.value, this.count, length, '\u0000');
            }

            this.count = length;
        }
    }

    public boolean testPos(int newPos){
        if (newPos < 0){
            return false;
        }else if (newPos < this.count) {
            return true;
        } else if (source != null){
            readToPos(newPos);
            return true;
        }
        return false;
    }

    public char charAt(int pos) {
        if (pos < 0){
            throw new IllegalArgumentException("pos shouldn't be "+pos);
        }else if (pos < this.count) {
            return this.value[pos];
        } else if (source != null){
            readToPos(pos);
            return this.value[pos];
        }
        throw new StringIndexOutOfBoundsException(pos);
    }

    public String subString(int start,int end){
        return new String(value,start,end-start);
    }

    public int getPos(){
        return pos;
    }

    public void setPos(int newPos){
        if (pos < 0){
            throw new IllegalArgumentException("pos shouldn't be "+pos);
        }else if (pos < this.count) {
            this.pos = newPos;
            return;
        } else if (source != null){
            readToPos(pos);
            this.pos = newPos;
            return;
        }
        throw new StringIndexOutOfBoundsException(pos);
    }

    private void readToPos(int pos){
        while (this.count <= pos){
            if (!append(source.read())){
                throw new StringIndexOutOfBoundsException(pos);
            }
        }
    }

    public boolean append(String data) {
        if(data == null) {
            return false;
        } else {
            int length = data.length();
            this.ensureCapacityInternal(this.count + length);
            data.getChars(0, length, this.value, this.count);
            this.count += length;
            return true;
        }
    }


    public <T> T execute(Operator<T> operator){
        return operator.execute(this);
    }

}
