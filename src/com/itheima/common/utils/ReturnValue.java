package com.itheima.common.utils;

import com.alibaba.fastjson.JSON;

import static com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect;

public class ReturnValue {
    private int flag;
    private String content;
    private Object obj;

    public ReturnValue(int flag, String content, Object obj) {
        this.flag = flag;
        this.content = content;
        this.obj = obj;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,DisableCircularReferenceDetect);
    }
}
