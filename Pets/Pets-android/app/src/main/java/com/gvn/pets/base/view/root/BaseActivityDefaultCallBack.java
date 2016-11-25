package com.gvn.pets.base.view.root;

import com.gvn.pets.base.model.ServerResponse;
import com.gvn.pets.model.http.RetrofitCallback;

/**
 * Created by namIT on 11/25/2016.
 */

public abstract class BaseActivityDefaultCallBack extends BaseActivity implements RetrofitCallback.DefaultViewCallBack {

    @Override
    public void showError(int code) {
        switch (code) {
            //Client
            case ServerResponse.CLIENT_ERROR_UNKNOW:
                break;
            case ServerResponse.CLIENT_ERROR_NO_CONNECTION:
                break;
            case ServerResponse.CLIENT_ERROR_NO_DATA:
                break;
            case ServerResponse.CLIENT_ERROR_CAN_NOT_CONNECTION:
                break;
            case ServerResponse.CLIENT_ERROR_PARSE_JSON:
                break;
            case ServerResponse.CLIENT_ERROR_AUTHEN_WITH_CHAT_SERVER:
                break;
            case ServerResponse.CLIENT_ERROR_BILLING_UNAVAIABLE:
                break;
            //Server
            case ServerResponse.SERVER_UNKNOWN_ERROR:
                break;
            case ServerResponse.SERVER_WRONG_DATA_FORMAT:
                break;
            case ServerResponse.SERVER_INVALID_TOKEN:
                break;
            case ServerResponse.SERVER_NO_CHANGE:
                break;
            case ServerResponse.SERVER_OUT_OF_DATE_API:
                break;
            case ServerResponse.SERVER_OLD_VERSION:
                break;
            case ServerResponse.SERVER_CHANGE_BACKEND_SETTING:
                break;
            case ServerResponse.SERVER_AGE_DENY:
                break;
            case ServerResponse.SERVER_EMAIL_NOT_FOUND:
                break;
            case ServerResponse.SERVER_INVALID_EMAIL:
                break;
            case ServerResponse.SERVER_EMAIL_REGISTERED:
                break;
            case ServerResponse.SERVER_SEND_MAIL_FAIL:
                break;
            case ServerResponse.SERVER_INVALID_USER_NAME:
                break;
            case ServerResponse.SERVER_INVALID_BIRTHDAY:
                break;
            case ServerResponse.SERVER_INCORRECT_PASSWORD:
                break;
            case ServerResponse.SERVER_INVALID_PASSWORD:
                break;
            case ServerResponse.SERVER_UPLOAD_IMAGE_ERROR:
                break;
            case ServerResponse.SERVER_UPLOAD_FILE_ERROR:
                break;
            case ServerResponse.SERVER_BUZZ_NOT_FOUND:
                break;
            case ServerResponse.SERVER_ACCESS_DENIED:
                break;
            case ServerResponse.SERVER_FORBIDDEN_IMAGE:
                break;
            case ServerResponse.SERVER_COMMENT_NOT_FOUND:
                break;
            case ServerResponse.SERVER_FILE_NOT_FOUND:
                break;
            case ServerResponse.SERVER_LOCKED_FEARUTE:
                break;
            case ServerResponse.SERVER_BLOCKED_USER:
                break;
            case ServerResponse.SERVER_NOT_ENOUGHT_MONEY:
                break;
            case ServerResponse.SERVER_RECEIVER_NOT_ENOUGH_MONEY:
                break;
            case ServerResponse.SERVER_ITEM_NOT_AVAIABLE:
                break;
            case ServerResponse.SERVER_USER_NOT_EXIST:
                break;
            case ServerResponse.SERVER_LOOKED_USER:
                break;
            case ServerResponse.SERVER_INCORRECT_CODE:
                break;
            case ServerResponse.SERVER_ALREADY_PURCHASE:
                break;
            case ServerResponse.UPDATE_NEWS_FROM_BACKEND:
                break;
        }
    }
}
