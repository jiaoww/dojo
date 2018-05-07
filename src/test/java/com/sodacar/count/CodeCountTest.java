package com.sodacar.count;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by evin on 2018/5/7.
 */
public class CodeCountTest {
    private URL currentDir = this.getClass().getResource("");

    @Test
    public void testAll() {
        File file = new File(currentDir.getPath() + "Dave.java");
        CodeCount codeCount = new CodeCount();
        codeCount.count(file);
        Assert.assertEquals(codeCount.getAllLines(), 12);
    }

    @Test
    public void testBlank() {
        File file = new File(currentDir.getPath() + "Dave.java");
        CodeCount codeCount = new CodeCount();
        codeCount.count(file);
        Assert.assertEquals(codeCount.getBlankLines(), 3);
    }

    @Test
    public void test() {
        File file = new File(currentDir.getPath() + "Dave.java");
        CodeCount codeCount = new CodeCount();
        codeCount.count(file);
        Assert.assertEquals(codeCount.getCommentLines(), 4);
    }

    @Test
    public void testEffective() {
        File file = new File(currentDir.getPath() + "Dave.java");
        CodeCount codeCount = new CodeCount();
        codeCount.count(file);
        Assert.assertEquals(codeCount.getEffectiveLines(), 3);
    }

    @Test
    public void testImport() {
        File file = new File(currentDir.getPath() + "Dave.java");
        CodeCount codeCount = new CodeCount();
        codeCount.count(file);
        Assert.assertEquals(codeCount.getImportLines(), 1);
    }
}
