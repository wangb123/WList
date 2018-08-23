package org.wbing.app_list;

import android.graphics.Color;

import org.wbing.app_list.data.ContentData;
import org.wbing.app_list.databinding.ItemContentBinding;
import org.wbing.list.WSingleListFragment;
import org.wbing.view.list.LineItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangbing
 * @date 2018/8/23
 */
public class SingleListFragment extends WSingleListFragment<ContentData, ItemContentBinding> {
    @Override
    protected int variableId() {
        return BR.data;
    }

    @Override
    protected int holderLayout() {
        return R.layout.item_content;
    }

    @Override
    public void onPostViewCreate() {
        super.onPostViewCreate();
        getBinding().list.addItemDecoration(new LineItemDecoration());
    }

    @Override
    public void loadData() {
        List<ContentData> ls = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ls.add(new ContentData(getRandomColor(), "item text " + i));
        }
        adapter().setList(ls);
    }

    private int[] colors = {
            Color.BLACK,
            Color.DKGRAY,
            Color.GRAY,
            Color.LTGRAY,
            Color.WHITE,
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
