package com.sodacar.count;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by evin on 2018/5/7.
 */
public class CodeCountTest {
    private String testFile = "/Users/evin/git/tdd-dojo-seed/src/test/java/com/sodacar/count/Dave.java";

    @Test
    public void testAll() {
        File file = new File(testFile);
        CodeCount codeCount = new CodeCount();
        codeCount.count(file);
        Assert.assertEquals(codeCount.getAllLines(), 11);
    }

    @Test
    public void testBlank() {
        File file = new File(testFile);
        CodeCount codeCount = new CodeCount();
        codeCount.count(file);
        Assert.assertEquals(codeCount.getBlankLines(), 2);
    }

    @Test
    public void testComment() {
        File file = new File(testFile);
        CodeCount codeCount = new CodeCount();
        codeCount.count(file);
        Assert.assertEquals(codeCount.getCommentLines(), 4);
    }

    @Test
    public void testEffective() {
        File file = new File(testFile);
        CodeCount codeCount = new CodeCount();
        codeCount.count(file);
        Assert.assertEquals(codeCount.getEffectiveLines(), 3);
    }

    @Test
    public void testImport() {
        File file = new File(testFile);
        CodeCount codeCount = new CodeCount();
        codeCount.count(file);
        Assert.assertEquals(codeCount.getImportLines(), 1);
    }
}
