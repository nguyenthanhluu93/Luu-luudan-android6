package com.gvn.pets.model.http.api;

import com.gvn.pets.base.model.ServerRequest;

/**
 * Created by namIT on 11/28/2016.
 */

public class GetApplicationInfoRequest extends ServerRequest {

    private static final long serialVersionUID = 5354828645479974093L;

    public GetApplicationInfoRequest() {
        super("get_inf_for_application");
    }
}
