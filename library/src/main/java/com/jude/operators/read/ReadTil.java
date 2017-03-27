package com.jude.operators.read;

import com.jude.Operator;
import com.jude.SBReader;
import com.jude.domain.LocationType;
import com.jude.util.KMPTool;

/**
 * Created by Jude on 3/27/17.
 */

public class ReadTil implements Operator<String>{
    String word;
    LocationType locationType;

    public ReadTil(String word) {
        this(word,LocationType.Before);
    }

    public ReadTil(String word, LocationType locationType) {
        this.word = word;
        this.locationType = locationType;
    }

    @Override
    public String execute(SBReader sbReader) {
        int start = sbReader.getPos();
        int end = start;
        int i = end;
        int j = 0;
        int plen = word.length();

        int[] next = KMPTool.getKMPArray(word);

        while (sbReader.testPos(i) && j < plen) {

            if (sbReader.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    i++;
                    j = 0;
                } else {
                    j = next[j];
                }

            }

            if (j == plen) {
                end = i - (locationType == LocationType.Before ? j : 0);
                sbReader.setPos(end);
                return sbReader.subString(start,end);
            }
        }
        return null;
    }
}
