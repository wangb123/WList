package org.wbing.list;

import org.wbing.view.list.IMultiItem;
import org.wbing.view.list.WAdapter;
import org.wbing.view.list.WMultiAdapter;
import org.wbing.view.list.databinding.WListItemMultiRootBinding;

/**
 * @author wangbing
 * @date 2018/8/23
 */
public abstract class WMultiListFragment<Data extends IMultiItem> extends WListFragment<Data, WListItemMultiRootBinding> {
    WMultiAdapter<Data> adapter;

    @Override
    public WMultiAdapter<Data> adapter() {
        if (adapter == null) {
            adapter = new WMultiAdapter<>(variableId());
        }
        return adapter;
    }

    @Override
    public void recycle() {
        adapter.removeAll();
        adapter = null;
    }

    protected abstract int variableId();
}
