package com.fishion.demo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class TestJson {

    String code;
    String  sysInfo;

    List<OutPutInfo> message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSysInfo() {
        return sysInfo;
    }

    public void setSysInfo(String sysInfo) {
        this.sysInfo = sysInfo;
    }

    public List<OutPutInfo> getMessage() {
        return message;
    }

    public void setMessage(List<OutPutInfo> message) {
        this.message = message;
    }

    public static void main(String[] args) {
        String jsonStr = "{\"value\":\"{\\\"code\\\":\\\"200\\\",\\\"message\\\":[{\\\"reason\\\":\\\"\\\",\\\"rwdh\\\":\\\"813320180223017\\\",\\\"status\\\":\\\"success\\\"}]}\"}";


        JSONObject object = JSON.parseObject(jsonStr);
        Object object2 = object.get("value");
        TestJson testJson = JSON.parseObject(object2.toString(),
                TestJson.class) ;
        System.out.println(object.get("value"));
        System.out.println(JSON.toJSONString(object2));
        System.out.println(testJson);
    }
}
