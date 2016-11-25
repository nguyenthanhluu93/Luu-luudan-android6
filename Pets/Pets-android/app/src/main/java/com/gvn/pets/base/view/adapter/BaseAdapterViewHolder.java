package com.gvn.pets.base.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by namIT on 11/18/2016.
 */

public class BaseAdapterViewHolder extends RecyclerView.ViewHolder {
    public View view;

    public BaseAdapterViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;
    }

    /**
     * Replacement findViewById
     * @param id id res
     * @return
     */
    protected <T extends View> T $(int id) {
        return (T) this.view.findViewById(id);
    }
}
