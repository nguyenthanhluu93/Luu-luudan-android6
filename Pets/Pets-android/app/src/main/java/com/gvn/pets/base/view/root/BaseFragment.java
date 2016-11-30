package com.gvn.pets.base.view.root;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gvn.pets.app.AppController;
import com.gvn.pets.app.BaseView;
import com.gvn.pets.base.presenter.BasePresenter;
import com.gvn.pets.inject.component.DaggerFragmentComponent;
import com.gvn.pets.inject.component.FragmentComponent;
import com.gvn.pets.inject.module.FragmentModule;
import com.gvn.pets.utils.LogUtils;

import javax.inject.Inject;

/**
 * T được truyền vào Là 1 Presenter
 * Đăng ký giá trị T trong 1 Fragment extends BaseFragment: ta Sử dụng "getFragmentComponent().inject(this)" this là Fragment hiện tại
 * BaseView Là 1 Callback Khi extends BaseFragment Sẽ tự động override showError
 * Sử dụng BaseView: Presenter extend RxPresenter<T extends BaseView>
 * Trong RxPresenter Có 2 giá trị cần truyền vào:
 * + 1 attachView<T extends BaseView> Ở đây ta sẽ đăng ký Sự kiên callBack
 * + 2 detachView Ở đây ta gọi để hủy Đăng ký BaseView ở framgnet
 * Hàm "bindView(@IdRes int id)" sẽ thay thế cho phương thức  "rootView.findViewById(id)"
 * <p>
 * Created by namIT on 11/18/2016.
 */

public abstract class BaseFragment<T extends BasePresenter> extends SupportFragment implements BaseView {

    @Inject
    protected T presenter;
    protected View rootView;
    protected boolean isInited = false;
    protected Activity activity;
    protected Context context;

    @Override
    public void onAttach(Context context) {
        this.activity = (Activity) context;
        this.context = context;
        super.onAttach(context);
    }

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(AppController.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(),container, false);
        initInject();
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Đăng ký callBack
        presenter.attachView(this);
        if (savedInstanceState == null) {
            if (!isHidden()) {
                isInited = true;
                onViewReady();
            }
        } else {
            if (!isSupportHidden()) {
                isInited = true;
                onViewReady();
            }
        }
        onViewReady();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!isInited && !hidden) {
            isInited = true;
            onViewReady();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) presenter.detachView();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtils.d("BaseFragment", "resultCode: " + resultCode + "\n" + "requestCode: " + requestCode);
    }

    /**
     * Replacement findViewById
     *
     * @param id id res
     * @return
     */
    protected <T extends View> T bindView(@IdRes int id) {
        return (T) rootView.findViewById(id);
    }

    /**
     * @return return LayoutId của fragment
     */
    protected abstract int getLayoutId();
    /**
     * Ở đây sẽ gọi phương thức này để đăng ký Callback
     * getFragmentComponent().inject(this)\
     * và khởi tạo các View ở đây
     */
    protected abstract void initInject();

    /**
     * View Cài đặt thành công sẽ được sử lý ở phương thức này
     */
    protected abstract void onViewReady();


    //CallBack
    @Override
    public void showError(String msg) {
        //TODO callback
        LogUtils.i("namIT", msg);
    }
}