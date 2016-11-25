package com.gvn.pets.base.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gvn.pets.base.model.BaseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by namIT on 11/18/2016.
 */

public abstract class BaseAdapter<VH extends BaseAdapterViewHolder, E extends BaseBean> extends RecyclerView.Adapter<VH> {

    protected final int EMPTY_DATA = -1;
    protected List<E> datas;
    protected Context context;
    private String error;
    //event listener
    protected BaseAdapterCallback<E> listener;

    /**
     * @param context  context
     * @param listener Event item Click "listener extends BaseAdapterListener"
     */
    public BaseAdapter(Context context, BaseAdapterCallback listener) {
        this.context = context;
        this.listener = listener;
        this.datas = new ArrayList<>();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        try {
            if (viewType == EMPTY_DATA) {
                return (VH) new BaseAdapterViewHolder(LayoutInflater.from(context).inflate(onViewEmpty(), parent, false));
            } else {
                return onCreateViewAdapter(parent, viewType);
            }
        } catch (Exception e) {
            e.printStackTrace();
            error = e.getMessage();
            return (VH) new BaseAdapterViewHolder(LayoutInflater.from(context).inflate(onViewError(), parent, false));
        }
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (holder.itemView == LayoutInflater.from(context).inflate(onViewEmpty(), null, false)) {
            listener.onEmptyData(true);
        } else if (holder.itemView == LayoutInflater.from(context).inflate(onViewError(), null, false)) {
            listener.onAdapterError(error);
        } else {
            onViewReady(holder, position);
        }
    }

    /**
     * @param parent
     * @param viewType
     * @return ViewHolder extends BaseAdapterViewHolder
     */
    @NonNull
    protected abstract VH onCreateViewAdapter(ViewGroup parent, int viewType);

    /**
     * @return view error
     */
    @NonNull
    protected abstract int onViewError();

    /**
     * @return view loading data
     */
    @NonNull
    protected abstract int onViewEmpty();

    /**
     * @param holder
     * @param position handling view here
     */
    @NonNull
    protected abstract void onViewReady(VH holder, int position);

    @Override
    public int getItemCount() {
        if (datas == null)
            return 0;
        if (datas.size() <= 0) {
            return 0;
        }
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (datas == null)
            return EMPTY_DATA;
        if (datas.size() <= 0)
            return EMPTY_DATA;
        return super.getItemViewType(position);
    }

    /**
     * @param datas clear old data add new data "List<E extends BaseBean>"
     */
    public void setData(List<E> datas) {
        if (datas == null)
            return;
        this.datas.clear();
        this.datas.addAll(datas);
    }

    /**
     * @param datas add new data "List<E extends BaseBean>" to old data
     */
    public void appenData(List<E> datas) {
        this.datas.addAll(datas);
    }

    /**
     * @param data add new data "E extends BaseBean" to old data
     */
    public void appenData(E data) {
        this.datas.add(data);
    }

    /**
     * notifyDataSetChanged
     */
    public void notifyData() {
        notifyDataSetChanged();
    }

    /**
     * Event item Click
     */
    protected class OnItemClick implements View.OnClickListener {
        private E item;
        private int position;

        /**
         * @param item     object
         * @param position
         */
        public OnItemClick(E item, int position) {
            this.item = item;
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(item, position, v);
        }
    }
}
