package org.wbing.list;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import org.wbing.view.list.WAdapter;

/**
 * @author wangbing
 * @date 2018/8/23
 */
public abstract class WSingleListFragment<Data, Binding extends ViewDataBinding> extends WListFragment<Data, Binding> {

    private WAdapter<Data, Binding> adapter;


    @Override
    public WAdapter<Data, Binding> adapter() {
        if (adapter == null) {
            adapter = new WAdapter.SimpleAdapter<>(variableId(), holderLayout());
        }
        return adapter;
    }


    @Override
    public void recycle() {
        adapter.removeAll();
        adapter = null;
    }

    protected abstract int variableId();

    protected abstract int holderLayout();

}
