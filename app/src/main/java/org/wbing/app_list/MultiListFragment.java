package org.wbing.app_list;

import android.graphics.Color;

import org.wbing.app_list.data.AdData;
import org.wbing.app_list.data.ContentData;
import org.wbing.app_list.data.NewsData;
import org.wbing.list.WMultiListFragment;
import org.wbing.view.list.IMultiItem;
import org.wbing.view.list.LineItemDecoration;

import java.util.ArrayList;

/**
 * @author wangbing
 * @date 2018/8/23
 */
public class MultiListFragment extends WMultiListFragment<IMultiItem> {
    @Override
    protected int variableId() {
        return BR.data;
    }

    @Override
    public void onPostViewCreate() {
        super.onPostViewCreate();
        getBinding().list.addItemDecoration(new LineItemDecoration());
    }


    @Override
    public void loadData() {
        ArrayList<IMultiItem> ls = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ls.add(createData(i));
        }
        adapter().setList(ls);
    }

    private IMultiItem createData(int i) {
        int random = (int) Math.round(Math.random() * 3);
        switch (random) {
            case 1:
                return new AdData(getRandomColor(), "广告：" + i);
            case 2:
                return new NewsData(getRandomColor(), "新闻：" + i);
            default:
                return new ContentData(getRandomColor(), "内容：" + i);
        }
    }

    private int[] colors = {
            Color.BLACK,
            Color.DKGRAY,
            Color.GRAY,
            Color.LTGRAY,
            Color.GRAY,
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.CYAN,
            Color.MAGENTA
    };

    private int getRandomColor() {
        int random = (int) (Math.random() * 9);
        return colors[random];
    }
}
