package com.sodacar.dz;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evin on 2018/4/23.
 */
public class DzTest {

    @Test
    public void testShapeCheck() {
        List<Paper> handles = new ArrayList<>();
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(11, PaperShape.CLUB));
        handles.add(new Paper(12, PaperShape.CLUB));
        handles.add(new Paper(13, PaperShape.CLUB));
        handles.add(new Paper(9, PaperShape.CLUB));
        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertTrue(dzPaperService.shapeCheck(handles) == PaperType.STRAIGHT_FLUSH);
    }


    @Test
    public void testStraight() {
        List<Paper> handles = new ArrayList<>();
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(11, PaperShape.CLUB));
        handles.add(new Paper(12, PaperShape.CLUB));
        handles.add(new Paper(13, PaperShape.CLUB));
        handles.add(new Paper(14, PaperShape.CLUB));
        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertTrue(dzPaperService.isStraight(handles));
    }


    @Test
    public void testFlush() {
        List<Paper> handles = new ArrayList<>();
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(11, PaperShape.CLUB));
        handles.add(new Paper(12, PaperShape.CLUB));
        handles.add(new Paper(13, PaperShape.CLUB));
        handles.add(new Paper(9, PaperShape.CLUB));
        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertTrue(dzPaperService.isFlush(handles));
    }

    @Test
    public void testStraightFlush() {
        List<Paper> handles = new ArrayList<>();
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(11, PaperShape.CLUB));
        handles.add(new Paper(12, PaperShape.CLUB));
        handles.add(new Paper(13, PaperShape.CLUB));
        handles.add(new Paper(9, PaperShape.CLUB));
        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertTrue(dzPaperService.isStraightFlush(handles));
    }

    @Test
    public void testNotFlush() {
        List<Paper> handles = new ArrayList<>();
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(11, PaperShape.CLUB));
        handles.add(new Paper(12, PaperShape.CLUB));
        handles.add(new Paper(13, PaperShape.CLUB));
        handles.add(new Paper(8, PaperShape.HEART));
        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertFalse(dzPaperService.isFlush(handles));
    }


    @Test
    public void testNumSum() {
        List<Paper> handles = new ArrayList<>();
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(11, PaperShape.CLUB));
        handles.add(new Paper(12, PaperShape.CLUB));
        handles.add(new Paper(13, PaperShape.CLUB));
        handles.add(new Paper(9, PaperShape.CLUB));
        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertTrue(dzPaperService.numSum(handles) == 10 + 11 + 12 + 13 + 9);
    }

    @Test
    public void testFourOfAKind() {
        List<Paper> handles = new ArrayList<>();
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(10, PaperShape.HEART));
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(10, PaperShape.DIAMOND));
        handles.add(new Paper(12, PaperShape.CLUB));
        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertTrue(dzPaperService.isFourOfAKind(handles));
    }

    @Test
    public void testFullhouse() {
        List<Paper> handles = new ArrayList<>();
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(10, PaperShape.HEART));
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(12, PaperShape.DIAMOND));
        handles.add(new Paper(12, PaperShape.CLUB));
        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertTrue(dzPaperService.isFullhouse(handles));
    }

    @Test
    public void testThreefAKnd() {
        List<Paper> handles = new ArrayList<>();
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(10, PaperShape.HEART));
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(12, PaperShape.DIAMOND));
        handles.add(new Paper(13, PaperShape.CLUB));
        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertTrue(dzPaperService.isThreefAKind(handles));
    }

    @Test
    public void testTwoPairs() {
        List<Paper> handles = new ArrayList<>();
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(10, PaperShape.HEART));
        handles.add(new Paper(13, PaperShape.CLUB));
        handles.add(new Paper(12, PaperShape.DIAMOND));
        handles.add(new Paper(12, PaperShape.CLUB));
        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertTrue(dzPaperService.isTwoPairs(handles));
    }

    @Test
    public void testOnePairs() {
        List<Paper> handles = new ArrayList<>();
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(10, PaperShape.HEART));
        handles.add(new Paper(13, PaperShape.CLUB));
        handles.add(new Paper(12, PaperShape.DIAMOND));
        handles.add(new Paper(14, PaperShape.CLUB));
        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertTrue(dzPaperService.isOnePairs(handles));
    }


    @Test
    public void testRoyalFlush() {
        List<Paper> handles = new ArrayList<>();
        handles.add(new Paper(10, PaperShape.CLUB));
        handles.add(new Paper(11, PaperShape.CLUB));
        handles.add(new Paper(12, PaperShape.CLUB));
        handles.add(new Paper(13, PaperShape.CLUB));
        handles.add(new Paper(14, PaperShape.CLUB));
        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertTrue(dzPaperService.isRoyalFlush(handles));
    }

    @Test
    public void testCompare() {
        List<Paper> handles1 = new ArrayList<>();
        handles1.add(new Paper(10, PaperShape.CLUB));
        handles1.add(new Paper(11, PaperShape.CLUB));
        handles1.add(new Paper(12, PaperShape.CLUB));
        handles1.add(new Paper(13, PaperShape.CLUB));
        handles1.add(new Paper(14, PaperShape.CLUB));

        List<Paper> handles2 = new ArrayList<>();
        handles2.add(new Paper(10, PaperShape.CLUB));
        handles2.add(new Paper(11, PaperShape.CLUB));
        handles2.add(new Paper(12, PaperShape.CLUB));
        handles2.add(new Paper(13, PaperShape.CLUB));
        handles2.add(new Paper(9, PaperShape.CLUB));

        DzPaperService dzPaperService = new DzPaperService();
        Assert.assertTrue(dzPaperService.compare(handles1, handles2) > 0);
    }

}
