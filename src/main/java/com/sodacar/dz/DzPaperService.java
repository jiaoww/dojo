package com.sodacar.dz;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by evin on 2018/4/23.
 */
public class DzPaperService {
    /**
     * 识别牌型
     *
     * @param handles 传入牌
     * @return 编号 1-10 分别对应10种不同的牌型 返回值大小代表牌型的大小 返回值越大 牌型越大
     */
    public int shapeCheck(List<Paper> handles) {
        if (isRoyalFlush(handles))
            return PaperType.ROYAL_FLUSH;
        else if (isStraightFlush(handles))
            return PaperType.STRAIGHT_FLUSH;
        else if (isFourOfAKind(handles))
            return PaperType.FOUR_OF_A_KIND;
        else if (isFullhouse(handles))
            return PaperType.FULLHOUSE;
        else if (isFlush(handles))
            return PaperType.FLUSH;
        else if (isStraight(handles))
            return PaperType.STRAIGHT;
        else if (isThreefAKind(handles))
            return PaperType.THREE_OF_A_KIND;
        else if (isTwoPairs(handles))
            return PaperType.TWO_PAIRS;
        else if (isOnePairs(handles))
            return PaperType.ONE_PAIR;
        else
            return PaperType.HIGH_CARD;
    }


    /**
     * 判断是不是顺子
     *
     * @param papers
     * @return
     */
    public boolean isStraight(List<Paper> papers) {
        Map<Integer, Long> rst = papers.stream()
                .collect(Collectors.groupingBy(Paper::getNum, Collectors.counting()));
        if (rst.size() == papers.size()) {
            //如果是个不同的数字才有可能是连续的
            Collections.sort(papers, Comparator.comparing(Paper::getNum));
            //然后去最大值减最小值 如果为 paper.size()-1则为连续的
            if (papers.get(papers.size() - 1).getNum() - papers.get(0).getNum() == papers.size() - 1)
                return true;
        }
        return false;
    }

    /**
     * 判断是不是同花
     *
     * @param papers
     * @return
     */
    public boolean isFlush(List<Paper> papers) {
        Map<PaperShape, Long> rst = papers
                .stream()
                .collect(Collectors.groupingBy(Paper::getShape, Collectors.counting()));
        if (rst.size() == 1)
            return true;
        else
            return false;

    }

    /**
     * 点数和
     *
     * @param papers 传入牌
     * @return 返回值为 牌面大小的和
     */
    public int numSum(List<Paper> papers) {
        return papers.stream()
                .mapToInt(Paper::getNum)
                .sum();
    }

    /**
     * 判断是不是四条
     *
     * @param handles 传入牌
     * @return
     */
    public boolean isFourOfAKind(List<Paper> handles) {
        Map<Integer, Long> rst = handles
                .stream()
                .collect(Collectors.groupingBy(Paper::getNum, Collectors.counting()));
        if (rst.size() == 2) {
            for (Map.Entry<Integer, Long> m : rst.entrySet()) {
                if (m.getValue() == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是不是满堂红
     *
     * @param handles
     * @return
     */
    public boolean isFullhouse(List<Paper> handles) {
        Map<Integer, Long> rst = handles
                .stream()
                .collect(Collectors.groupingBy(Paper::getNum, Collectors.counting()));
        if (rst.size() == 2) {
            for (Map.Entry<Integer, Long> m : rst.entrySet()) {
                if (m.getValue() == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是不是三条
     *
     * @param handles 一手牌
     * @return
     */
    public boolean isThreefAKind(List<Paper> handles) {
        Map<Integer, Long> rst = handles
                .stream()
                .collect(Collectors.groupingBy(Paper::getNum, Collectors.counting()));
        if (rst.size() == 3) {
            for (Map.Entry<Integer, Long> m : rst.entrySet()) {
                if (m.getValue() == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是不是 两对
     *
     * @param handles
     * @return
     */
    public boolean isTwoPairs(List<Paper> handles) {
        Map<Integer, Long> rst = handles
                .stream()
                .collect(Collectors.groupingBy(Paper::getNum, Collectors.counting()));
        if (rst.size() == 3) {
            for (Map.Entry<Integer, Long> m : rst.entrySet()) {
                if (m.getValue() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是不是一对
     *
     * @param handles
     * @return
     */

    public boolean isOnePairs(List<Paper> handles) {
        Map<Integer, Long> rst = handles
                .stream()
                .collect(Collectors.groupingBy(Paper::getNum, Collectors.counting()));
        if (rst.size() == 4) {
            for (Map.Entry<Integer, Long> m : rst.entrySet()) {
                if (m.getValue() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是不是同花大顺
     *
     * @param handles
     * @return
     */
    public boolean isRoyalFlush(List<Paper> handles) {
        if (this.isStraightFlush(handles)) {
            Collections.sort(handles, Comparator.comparing(Paper::getNum));
            if (handles.get(0).getNum() == 10)
                return true;
        }
        return false;
    }

    /**
     * 判断是不是同花顺
     *
     * @param handles
     * @return
     */
    public boolean isStraightFlush(List<Paper> handles) {
        if (isStraight(handles) && isFlush(handles))
            return true;
        return false;
    }

    /**
     * 判断两手牌的大小
     *
     * @param handles1
     * @param handles2
     * @return -1 小于 0 等于 1 大于
     */
    public int compare(List<Paper> handles1, List<Paper> handles2) {
        int shape1 = shapeCheck(handles1);
        int shape2 = shapeCheck(handles2);
        if (shape1 > shape2)
            return 1;
        else if (shape1 < shape2)
            return -1;
        else {
            int shapeNumSum1 = numSum(handles1);
            int shapeNumSum2 = numSum(handles2);
            if (shapeNumSum1 > shapeNumSum2)
                return 1;
            else if (shapeNumSum1 < shapeNumSum2)
                return -1;
            else
                return 0;
        }
    }
}
