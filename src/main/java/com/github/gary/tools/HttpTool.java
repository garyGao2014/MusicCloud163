package com.github.gary.tools;

import com.github.gary.core.Params;
import com.google.common.collect.Lists;
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

import java.util.List;

/**
 * @author garygao
 */
public class HttpTool {
    /**
     * 默认的浏览器
     */
    private static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36";

    private static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";

    private static final String DEFAULT_CHARSET = "utf-8";

    /**
     * 发送post请求
     *
     * @param url   url地址
     * @param text 请求参数
     * @return result 完整的请求返回
     */
    public static String post(String url, String text) {
        try {
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(5000)
                    .setSocketTimeout(5000)
                    .setCookieSpec(CookieSpecs.DEFAULT).build();
            CloseableHttpClient client = HttpClients.custom()
                    .setDefaultRequestConfig(config)
                    .setUserAgent(DEFAULT_USER_AGENT)
                    .build();
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-Type", DEFAULT_CONTENT_TYPE);
            post.addHeader("Origin", "https://music.163.com");
            post.addHeader("Referer", "https://music.163.com/");
            List<NameValuePair> params = Lists.newArrayListWithCapacity(2);
            params.add(new BasicNameValuePair("params", EncryTool.getParams(text, Params.nonce)));
            params.add(new BasicNameValuePair("encSecKey", EncryTool.getEncSecKey(Params.pubKey, Params.modulus)));
            post.setEntity(new UrlEncodedFormEntity(params, DEFAULT_CHARSET));
            System.out.println("请求：" + post.toString() + ",text:" + text);
            HttpResponse res = client.execute(post);
            String result = EntityUtils.toString(res.getEntity());
            post.abort();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
