package com.gvn.pets.base.view.adapter;

import android.view.View;

import com.gvn.pets.base.model.BaseBean;

/**
 * Created by namIT on 11/21/2016.
 */

public interface BaseAdapterCallback<E extends BaseBean> {
    void onItemClick(E item, int position, View view);

    void onEmptyData(boolean isEmpty);

    void onAdapterError(String error);
}