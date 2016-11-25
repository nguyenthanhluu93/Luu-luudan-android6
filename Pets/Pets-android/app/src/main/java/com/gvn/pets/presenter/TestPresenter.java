package com.gvn.pets.presenter;

import com.gvn.pets.base.presenter.RxPresenter;
import com.gvn.pets.model.bean.TestBean;
import com.gvn.pets.model.http.RetrofitHelper;
import com.gvn.pets.model.http.api.TestRequest;
import com.gvn.pets.model.http.service.RequestService;
import com.gvn.pets.presenter.contract.TestContract;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by namIT on 11/18/2016.
 */

public class TestPresenter extends RxPresenter<TestContract.View> implements TestContract.Presenter {
    private RetrofitHelper mRetrofitHelper;

    @Inject
    public TestPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }

    @Override
    public TestBean getCommentData(int id, int comment) {
        //  {"take":20,"time_stamp":"","api":"list_conversation","token":"be8ea213-678b-4a3a-af2f-8fac7003badf"}
        TestRequest testRequest = new TestRequest("list_conversation", "be8ea213-678b-4a3a-af2f-8fac7003badf", 20, "");
        RequestService request = mRetrofitHelper.restartRequestServer();
        Call<TestBean> bodyCall = request.getListConversation(testRequest);
        bodyCall.enqueue(new OnRetrofitCallback<TestBean>().onRetrofitCallback(view));

        return new TestBean();
    }
}
