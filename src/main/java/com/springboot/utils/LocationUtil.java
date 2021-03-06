package com.springboot.utils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author Wuhall
 */
public class LocationUtil {
    private static final String amapUrl = "https://restapi.amap.com/v3/geocode/geo";
    private static final String amapKey = "d2ba606e1e2021b70cf661fb3c808d63";

    /**
     *  根据地名获取经纬度信息
     */
    public String getLocation(String address) throws UnsupportedEncodingException {
        String param = "address=" + URLEncoder.encode(address,"utf-8") + "&key=" + amapKey;
        String sourceStr = HttpRequestUtil.sendGet(amapUrl,param);
        JSONObject jsonObject = JSONObject.parseObject(sourceStr);
        JSONArray jsonArray = jsonObject.getJSONArray("geocodes");
        if(jsonArray.size() == 0){
            return null;
        }
        Object object = jsonArray.get(0);
        JSONObject result = (JSONObject)object;
        String resultStr = result.getString("location");
        return resultStr;
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        System.out.println(getLocation("江苏省南京市六合区雄州街道王桥路17-6号花语馨苑"));
    }

    /**
     *  隐藏手机号中间4位信息
     */
    @Test
    public void formatePhone() {
        String num = "18687536664";
        String num1 = num.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
        System.out.println(num1);
    }
}
