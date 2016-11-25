package com.gvn.pets.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gvn.pets.R;
import com.gvn.pets.base.model.ServerResponse;
import com.gvn.pets.base.view.root.BaseFragmentDefaultCallBack;
import com.gvn.pets.model.bean.TestBean;
import com.gvn.pets.presenter.TestPresenter;
import com.gvn.pets.presenter.contract.TestContract;
import com.gvn.pets.utils.LogUtil;

import retrofit2.Response;

public class TestFragment extends BaseFragmentDefaultCallBack<TestPresenter> implements TestContract.View, View.OnClickListener {

    private static final String ARG_NUMBER = "arg_number";
    private int mNumber;
    private Button next;
    private TextView number;

    public static TestFragment newInstance(int number) {
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NUMBER, number);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mNumber = args.getInt(ARG_NUMBER);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void initInject() {
        //TODO
        //Register fragment
        getFragmentComponent().inject(this);
        //Create view
        next = bindView(R.id.next);
        number = bindView(R.id.number);
        next.setOnClickListener(this);
    }

    @Override
    protected void onViewReady() {
        //TODO
        number.setText(mNumber + " - fragment");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next:
                mPresenter.getCommentData(mNumber + 1, mNumber + 2);
                break;
        }
    }

    @Override
    public <E extends ServerResponse> void showContent(Response<E> response) {
        if(response.body() instanceof TestBean)
        LogUtil.i("namIT", ((TestBean)response.body()).getConversationItem().size() +" size Test Bean");
    }
}
