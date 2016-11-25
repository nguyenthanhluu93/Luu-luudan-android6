package com.gvn.pets.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gvn.pets.R;
import com.gvn.pets.base.view.adapter.BaseAdapter;
import com.gvn.pets.base.view.adapter.BaseAdapterViewHolder;
import com.gvn.pets.model.bean.TestBean;
import com.gvn.pets.ui.adapter.callback.TestAdapterListener;

/**
 * Created by namIT on 11/18/2016.
 */

public class TestAdapter extends BaseAdapter<TestAdapter.ViewHolder, TestBean> {

    public TestAdapter(Context context, TestAdapterListener listener) {
        super(context, listener);
    }

    @NonNull
    @Override
    protected int onViewEmpty() {
        return R.layout.layout_empty;
    }

    @NonNull
    @Override
    protected int onViewError() {
        return R.layout.layout_error;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewAdapter(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test_adapter, parent, false));
    }

    @NonNull
    @Override
    protected void onViewReady(ViewHolder holder, int position) {
        //TODO
    }

    public class ViewHolder extends BaseAdapterViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
