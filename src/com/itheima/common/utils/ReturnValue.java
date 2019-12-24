package com.itheima.common.utils;

import com.alibaba.fastjson.JSON;

public class ReturnValue {
    private int flag;
    private String data;
    private Object obj;

    public ReturnValue(int flag, String data, Object obj) {
        this.flag = flag;
        this.data = data;
        this.obj = obj;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
