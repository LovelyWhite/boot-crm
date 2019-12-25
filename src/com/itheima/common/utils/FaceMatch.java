package com.itheima.common.utils;


import com.alibaba.fastjson.JSON;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaceMatch {
    public static JSONObject match(String img1, String img2) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + "osBgj9oIxUe9ZsTvVpKhAA1l"
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + "Lgh7lQvtwtw3X2YhPFwcXqrpxrpNGKZ2";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response;
        HttpGet httpGet = new HttpGet(getAccessTokenUrl);
        try {
            response = httpClient.execute(httpGet);
            String result = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            List<Map<String, Object>> images = new ArrayList<>();
            Map<String, Object> map1 = new HashMap<>();
            map1.put("image", img1.split("base64,")[1]);
            map1.put("image_type", "BASE64");
            map1.put("face_type", "LIVE");
            map1.put("quality_control", "LOW");
            map1.put("liveness_control", "NONE");
            Map<String, Object> map2 = new HashMap<>();
            map2.put("image", img2.split("base64,")[1]);
            map2.put("image_type", "BASE64");
            map2.put("face_type", "LIVE");
            map2.put("quality_control", "LOW");
            map2.put("liveness_control", "NORMAL");
            images.add(map1);
            images.add(map2);
            String url = "https://aip.baidubce.com/rest/2.0/face/v3/match?access_token=" + access_token;
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(JSON.toJSONString(images)));
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity());
            /*
             *
             * {"error_code":0,"error_msg":"SUCCESS","log_id":304569239273181391,"timestamp":1553927318,"cached":0,
             * "result":{"score":100,
             * "face_list":[{"face_token":"dce00527410066d1ae1ed35a85fe8180"},
             * {"face_token":"dce00527410066d1ae1ed35a85fe8180"}]
             * }
             * }
             * */
            response.close();
            return new JSONObject(result);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
