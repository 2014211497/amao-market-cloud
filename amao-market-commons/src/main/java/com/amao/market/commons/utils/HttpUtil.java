package com.amao.market.commons.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author LinYuchang
 */
public class HttpUtil {

    public static String doGet(String url, Header... headers) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            if (headers != null) {
                for (Header header : headers) {
                    httpGet.addHeader(header);
                }
            }
            try (CloseableHttpResponse response = client.execute(httpGet)) {
                HttpEntity entity = response.getEntity();
                return entity == null ? null : EntityUtils.toString(entity);
            }
        }
    }

    public static String doPostJson(String url, String json, Header... headers) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            BasicResponseHandler handler = new BasicResponseHandler();
            StringEntity entity = new StringEntity(json, "utf-8");
            entity.setContentEncoding("utf-8");
            entity.setContentType("application/json");
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(entity);
            if (headers != null) {
                for (Header header : headers) {
                    httpPost.addHeader(header);
                }
            }
            return client.execute(httpPost, handler);
        }
    }
}
