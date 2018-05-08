package com.sodacar.count;

import java.io.*;
import java.util.regex.Pattern;

/**
 * Created by evin on 2018/5/7.
 */
public class CodeCount {

    private long allLines = 0;
    private long blankLines = 0;
    private long commentLines = 0;
    private long effectiveLines = 0;
    private long importLines = 0;


    public void count(File inFile) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
            String line;
            boolean flag = true;
            while ((line = buffer.readLine()) != null) {
                allLines++;
                line = line.trim();
                if ("".equals(line)) {
                    blankLines++;
                } else if (line.startsWith("package")) {
                    continue;
                } else if (line.startsWith("import")) {
                    importLines++;
                } else if (line.startsWith("/*") && line.endsWith("*/")) {
                    commentLines++;
                } else if (line.startsWith("//")) {
                    commentLines++;
                } else if (line.startsWith("/*") && flag) {
                    commentLines++;
                    flag = !flag;
                } else if (line.contains("*/") && !flag) {
                    commentLines++;
                    flag = !flag;
                } else if (!flag) {
                    commentLines++;
                } else {
                    effectiveLines++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
