package org.wbing.list;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.wbing.base.ui.impl.WFrag;
import org.wbing.list.databinding.WListFragmentBinding;
import org.wbing.view.list.WAdapter;

/**
 * @author wangbing
 * @date 2018/8/23
 */
public abstract class WListFragment<Data, Binding extends ViewDataBinding> extends WFrag<WListFragmentBinding> {

    RecyclerView.LayoutManager layoutManager;

    @Override
    public int layoutId() {
        return R.layout.w_list_fragment;
    }

    @Override
    public void onPostViewCreate() {
        super.onPostViewCreate();
        getBinding().list.setLayoutManager(layoutManager());
        getBinding().list.setAdapter(adapter());
    }

    public RecyclerView.LayoutManager layoutManager() {
        if (layoutManager == null) {
            layoutManager = new LinearLayoutManager(getContext());
        }
        return layoutManager;
    }

    public abstract WAdapter<Data, Binding> adapter();
}
