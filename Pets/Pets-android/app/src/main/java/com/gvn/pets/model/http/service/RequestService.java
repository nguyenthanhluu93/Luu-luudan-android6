package com.gvn.pets.model.http.service;

import com.gvn.pets.model.bean.GetApplicationInfoBean;
import com.gvn.pets.model.bean.GetUpdateInfoFlagBean;
import com.gvn.pets.model.bean.GetUserStatusBean;
import com.gvn.pets.model.bean.InstallCountBean;
import com.gvn.pets.model.bean.LoginBean;
import com.gvn.pets.model.http.api.GetApplicationInfoRequest;
import com.gvn.pets.model.http.api.GetUpdateInfoFlagRequest;
import com.gvn.pets.model.http.api.GetUserStatusRequest;
import com.gvn.pets.model.http.api.InstallCountRequest;
import com.gvn.pets.model.http.api.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by namIT on 11/24/2016.
 */

public interface RequestService {

    @POST("/get_inf_for_application")
    Call<GetApplicationInfoBean> getInfoForApplication(@Body GetApplicationInfoRequest request);

    @POST("/install_application")
    Call<InstallCountBean> installApplication(@Body InstallCountRequest request);

    @POST("/get_update_info_flag")
    Call<GetUpdateInfoFlagBean> updateInfoFlagRequest(@Body GetUpdateInfoFlagRequest request);

    @POST("/get_user_status_by_email")
    Call<GetUserStatusBean> getUserStatus(@Body GetUserStatusRequest request);

    @POST("/login")
    Call<LoginBean> login(@Body LoginRequest request);
}
