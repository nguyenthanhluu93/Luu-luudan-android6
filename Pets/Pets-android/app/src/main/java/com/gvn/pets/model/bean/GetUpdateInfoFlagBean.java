package com.gvn.pets.model.bean;

import com.google.gson.annotations.SerializedName;
import com.gvn.pets.base.model.ServerResponse;

/**
 * Created by namIT on 11/29/2016.
 */

public class GetUpdateInfoFlagBean extends ServerResponse {

    private static final long serialVersionUID = -5193791616224092310L;

    @SerializedName("update_email_flag")
    public int updateEmailFlag;

    @SerializedName("verification_flag")
    public int verificationFlag;

    @SerializedName("finish_register_flag")
    public int finishRegisterFlag;
}
