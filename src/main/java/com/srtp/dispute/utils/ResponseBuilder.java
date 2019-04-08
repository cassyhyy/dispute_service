package com.srtp.dispute.utils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.srtp.dispute.model.Response;
import com.srtp.dispute.utils.json.JsonUtil;
import org.apache.commons.lang.StringUtils;


public class ResponseBuilder {

    public static Response build (boolean isSuccess, Object data) {
        Response response = new Response();
        response.setSuccess(isSuccess);
        response.setData(data);
        return response;
    }

    public static Response buildResult(String result) {
        Response response = null;
        if (StringUtils.isBlank(result)) {
            response = build(false, null);
        } else {
            response = JsonUtil.toBean(result, Response.class);

        }
        return response;
    }
}