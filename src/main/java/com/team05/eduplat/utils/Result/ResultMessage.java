package com.team05.eduplat.utils.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: gdouStadium
 * @description:
 * @author: $(USER)
 * @create: $(TIME)
 **/
public class ResultMessage {
    private Integer code;
    private String msg;
    private Map<String, Object> data;

    public ResultMessage() {
    }

    public Integer getCode() {
        return this.code;
    }

    public ResultMessage setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public ResultMessage setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public ResultMessage put(String key, Object value) {
        if (this.data == null) {
            this.data = new HashMap();
        }

        this.data.put(key, value);
        return this;
    }

    public ResultMessage putAll(Map<String, Object> data) {
        if (this.data == null) {
            this.data = new HashMap();
        }

        this.data.putAll(data);
        return this;
    }
}