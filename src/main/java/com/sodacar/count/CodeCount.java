package com.sodacar.count;

import java.io.File;

/**
 * Created by evin on 2018/5/7.
 */
public class CodeCount {

    private long allLines = 0;
    private long blankLines = 0;
    private long commentLines = 0;
    private long effectiveLines = 0;
    private long importLines = 0;


    public void count(File inFIle) {

    }

    public long getBlankLines() {
        return blankLines;
    }

    public long getCommentLines() {
        return commentLines;
    }

    public long getEffectiveLines() {
        return effectiveLines;
    }

    public long getAllLines() {
        return allLines;
    }

    public long getImportLines() {
        return importLines;
    }
}
