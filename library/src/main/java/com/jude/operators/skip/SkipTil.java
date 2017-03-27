package com.jude.operators.skip;

import com.jude.Operator;
import com.jude.SBReader;
import com.jude.domain.LocationType;
import com.jude.util.KMPTool;

/**
 * Created by Jude on 3/27/17.
 */

public class SkipTil implements Operator<Boolean> {
    String word;
    int limit;
    LocationType locationType;

    public SkipTil(String word) {
        this(word, LocationType.Before,0);
    }

    public SkipTil(String word, int limit) {
        this(word, LocationType.Before,limit);
    }

    public SkipTil(String word, LocationType locationType) {
        this(word, locationType,0);
    }

    public SkipTil(String word, LocationType locationType, int limit) {
        this.word = word;
        this.locationType = locationType;
        this.limit = limit;
    }

    @Override
    public Boolean execute(SBReader sbReader) {
        int end = sbReader.getPos();
        int i = end;
        int j = 0;
        int plen = word.length();

        int[] next = KMPTool.getKMPArray(word);

        while ((limit == 0 && i <= end+limit) && sbReader.testPos(i) && j < plen) {

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
                return true;
            }
        }
        return false;
    }
}
