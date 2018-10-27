package io.github.xshoji.guicecommandtool.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.xshoji.guicecommandtool.dto.ResponseHttpbinGet;
import io.github.xshoji.guicecommandtool.dto.ResponseHttpbinPost;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ApiClientHttpbin {

    @Inject
    @Named("api_client.base_url")
    protected String baseUrl;


    @Inject
    protected CloseableHttpClient httpclient;

    /**
     * Get baseUrl
     *
     * @return String
     */
    public String getBaseUrl() {
        return this.baseUrl;
    }


    public ResponseHttpbinGet getInfo(String title) {

        String path = "/get";
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(4);
        nameValuePair.add(new BasicNameValuePair("format", "json"));
        nameValuePair.add(new BasicNameValuePair("action", "query"));
        nameValuePair.add(new BasicNameValuePair("prop", "info"));
        nameValuePair.add(new BasicNameValuePair("titles", title));
        String queryString = URLEncodedUtils.format(nameValuePair, "UTF-8");

        HttpGet request = new HttpGet(this.baseUrl + path + "?" + queryString);
        request.setConfig(this.createConfig());
        request.setHeaders(this.createHeader());

        ObjectMapper mapper = new ObjectMapper();
        ResponseHttpbinGet jsonResponseGet = null;
        try {
            jsonResponseGet = mapper.readValue(this.execute(request), ResponseHttpbinGet.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResponseGet;
    }

    /**
     *
     * @link Java apache HttpClient 4.3からの大幅なインターフェース変更に対応 http://qiita.com/mychaelstyle/items/e02b3011d1e71bfa26c5
     * @link Java HTTP通信のサンプル(HttpClient) | ITSakura http://itsakura.com/java-httpclient
     * @link ここを真似してクラス内にレスポンスクラスを定義してみた google-http-java-client/DailyMotionSample.java at master · google/google-http-java-client · GitHub https://github.com/google/google-http-java-client/blob/master/samples/dailymotion-simple-cmdline-sample/src/main/java/com/google/api/services/samples/dailymotion/cmdline/simple/DailyMotionSample.java
     * @return
     */
    public ResponseHttpbinPost postInfo(String title) {

        String path = "/post";
        List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(4);
        nameValuePair.add(new BasicNameValuePair("format", "json"));
        nameValuePair.add(new BasicNameValuePair("action", "query"));
        nameValuePair.add(new BasicNameValuePair("prop", "info"));
        nameValuePair.add(new BasicNameValuePair("titles", title));

        HttpPost request = new HttpPost(this.baseUrl + path);
        try {
            request.setEntity(new UrlEncodedFormEntity(nameValuePair));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        request.setConfig(this.createConfig());
        request.setHeaders(this.createHeader());

        ObjectMapper mapper = new ObjectMapper();
        ResponseHttpbinPost jsonResponsePost = null;
        try {
            jsonResponsePost = mapper.readValue(this.execute(request), ResponseHttpbinPost.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonResponsePost;
    }


    /**
     *
     * @link Java HTTP通信のサンプル(HttpClient) | ITSakura http://itsakura.com/java-httpclient
     * @link NameValuePairで入れ子(nesting)になっているデータを表現する - Hacking My Way ～ itogのhack日記 http://d.hatena.ne.jp/itog/20120307/1331103918
     * @link Android で HTTP 通信するクライアント作りました。　EasyHttpClient | SLUMBERS http://slumbers99.blogspot.jp/2011/09/android-http-easyhttpclient.html
     * @link Java apache HttpClient 4.3からの大幅なインターフェース変更に対応 http://qiita.com/mychaelstyle/items/e02b3011d1e71bfa26c5
     * @return
     */
    protected String execute(HttpUriRequest request) {

        Charset charset = StandardCharsets.UTF_8;

        CloseableHttpClient httpclient = HttpClients.createDefault();

        String responseData = null;
        try {

            CloseableHttpResponse response = httpclient.execute(request);

            int status = response.getStatusLine().getStatusCode();
            //System.out.println("HTTPステータス:" + status);
            //HTTPステータス:200

            if (status == HttpStatus.SC_OK) {
                responseData = EntityUtils.toString(response.getEntity(), charset);
                //System.out.println(responseData);
                //取得したデータが表示される
            }

            if (response != null) {
                response.close();
            }
            if (httpclient != null) {
                httpclient.close();
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }

    /**
     *
     * @return
     */
    public RequestConfig createConfig() {
        return RequestConfig.custom()
                .build();
    }

    /**
     *
     * @return
     */
    public Header[] createHeader() {
        // class - Creating an array of objects in Java - Stack Overflow https://stackoverflow.com/questions/5364278/creating-an-array-of-objects-in-java/5364332#5364332
        Header[] headers = new Header[] {
            new BasicHeader("User-Agent","Apache-HttpClient/4.5.2 (Java/1.8.0_131)")
        };
        return headers;
    }
}
