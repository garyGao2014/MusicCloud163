package com.github.gary;

import com.alibaba.fastjson.JSONObject;
import com.github.gary.tools.EncryTool;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {

            CloseableHttpClient client = null;
            RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(5000)
                    .setCookieSpec(CookieSpecs.DEFAULT).build();
            client = HttpClients.custom().setDefaultRequestConfig(config).setUserAgent(
                    "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36")
                    .build();
            HttpPost musicGet = new HttpPost("https://music.163.com/weapi/song/enhance/player/url?csrf_token=");
            musicGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
//            418603077 告白
//            完整输出:{"code":200,"expi":1200,"flag":0,"fee":8,"type":"mp3","canExtend":false,"url":"http://m10.music.126.net/20180228184238/10b3a22bf3ed1c1f513007ba25a3df81/ymusic/6e01/a4d4/bbef/2dda07904eb54d44abb278165e1c6ead.mp3","gain":-0.00020,"br":128000,"size":3443609,"id":418603077,"md5":"2dda07904eb54d44abb278165e1c6ead","payed":0}
//            29561031  taylor
//            完整输出:{"code":-110,"expi":1200,"flag":0,"fee":4,"canExtend":false,"gain":0.0,"br":0,"size":0,"id":29561031,"payed":0}
            String param1 = "{\"ids\":\"[" + 418603077 + "]\",\"br\":160000,\"csrf_token\":\"\"}", // bab30657eb19cbe86127fc5394dffe79
                    param2 = "010001",
                    param3 = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7",
                    param4 = "0CoJUm6Qyw8W8jud";

            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("params", EncryTool.getParams(param1, param4)));
            nvps.add(new BasicNameValuePair("encSecKey", EncryTool.getEncSecKey(param2, param3)));

            musicGet.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            HttpResponse res = client.execute(musicGet);
            JSONObject data = JSONObject.parseObject(EntityUtils.toString(res.getEntity())).getJSONArray("data").getJSONObject(0);

//            JSONObject musicDetails = new JSONObject(EntityUtils.toString(res.getEntity())).getJSONArray("data")
//                    .getJSONObject(0);
            musicGet.abort();

            int id = data.getIntValue("id");
            String musicurl = data.getString("url");
            String type = data.getString("type");
            System.out.printf("id:%3$d  type:%2$s  url:%1$s %n", musicurl, type, id);

            System.out.printf("完整输出:" + data.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
