package project.android.fkq.movingsquare.utils;

import project.android.fkq.movingsquare.bean.ItemBean;
import project.android.fkq.movingsquare.view.GameActivity;

import java.util.ArrayList;
import java.util.List;

public class GameUtil {
    // 游戏信息单元格Bean
    public static List<ItemBean> itemBeans = new ArrayList<>();
    // 空格单元格
    public static ItemBean blankItemBean = new ItemBean();

    /**
     * 判断点击的Item是否可移动
     *
     * @param position
     * @return 能否移动
     */
    public static boolean isMoveable(int position) {
        int type = GameActivity.type;
        // 获取空格Item
        int blankId = GameUtil.blankItemBean.getItemId() - 1;
        // 不同行 相差为type
        if (Math.abs(blankId - position) == type) {
            return true;
        }
        // 相同行 相差为1
        if ((blankId / type == position / type) && Math.abs(blankId - position) == 1) {
            return true;
        }
        return false;
    }

    /**
     * 交换空格与点击Item的位置
     *
     * @param from
     * @param blank
     */
    public static void swapItems(ItemBean from, ItemBean blank) {
        ItemBean tempItemBean = new ItemBean();
        // 交换BitmapId
        tempItemBean.setBitmapId(from.getBitmapId());
        from.setBitmapId(blank.getBitmapId());
        blank.setBitmapId(tempItemBean.getBitmapId());
        // 交换Bitmap
        tempItemBean.setBitmap(from.getBitmap());
        from.setBitmap(blank.getBitmap());
        blank.setBitmap(tempItemBean.getBitmap());
        // 设置新的Blank
        GameUtil.blankItemBean = from;
    }

    /**
     * 生成随机的Item
     */
    public static void getPuzzleGenerator() {
        for (int i = 0; i < itemBeans.size(); i++) {
            //产生[0,1)*type*type的随机整数
            int index = (int) (Math.random() * GameActivity.type * GameActivity.type);
            //list中指针0-8 对应ItemID为1-9,ItemID不会被交换
            swapItems(itemBeans.get(index), GameUtil.blankItemBean);
        }
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < itemBeans.size(); i++) {
            data.add(itemBeans.get(i).getBitmapId());
        }
        // 判断生成是否有解，无解就再来一遍
        if (!canSolve(data)) {
            getPuzzleGenerator();
        }
    }

    /**
     * 是否拼图成功
     *
     * @return 是否拼图成功
     */
    public static boolean isSuccess() {
        for (ItemBean tempBean : GameUtil.itemBeans) {
            //ItemID不会被交换，所以只要判断N轮交换过后ItemID是否等于BitmapID即可
            if (tempBean.getBitmapId() != 0 && (tempBean.getItemId()) == tempBean.getBitmapId()) {
                continue;
            } else if (tempBean.getBitmapId() == 0 && tempBean.getItemId() == GameActivity.type * GameActivity.type) {//空白块判定
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 该数据是否有解
     * @param data int数组
     * @return 该数据是否有解
     *
     * 可行性原则：（随机打乱序列将会有一半的概率无解）
     * 拼图宽度为奇数时，序列逆序对数量为偶数有解
     * 宽度为偶数时，空格位于从下往上 奇 数行时逆序对数量为 偶 数有解，
     *               空格位于从下往上 偶 数行时逆序对数量为 奇 数有解。
     */
    public static boolean canSolve(List<Integer> data) {
        // 获取空格Id
        int blankId = GameUtil.blankItemBean.getItemId();
        // 可行性原则
        if (data.size() % 2 == 1) {
            return getInversions(data) % 2 == 0;
        } else {
            // 从底往上数,空格位于奇数行
            if (((blankId - 1) / GameActivity.type) % 2 == 1) {
                return getInversions(data) % 2 == 0;
            } else { // 从底往上数,空位位于偶数行
                return getInversions(data) % 2 == 1;
            }
        }
    }

    /**
     * 计算序列的逆序对数量
     *
     * @param data int数组
     * @return 逆序对数量
     */
    public static int getInversions(List<Integer> data) {
        int inversions = 0;
        for (int i = 0; i < data.size(); i++) {
            int inversionCount = 0;
            for (int j = i + 1; j < data.size(); j++) {
                int index = data.get(i);
                if (data.get(j) != 0 && data.get(j) < index) {
                    inversionCount++;
                }
            }
            inversions += inversionCount;
        }
        return inversions;
    }

}
