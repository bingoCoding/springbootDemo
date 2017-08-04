package com.example.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.http.NameValuePair;


/**
 * http 调用
 * @author yan
 *
 */
public class HttpUtil {

	/** 日志 */
	private static final Logger LOG = LoggerFactory.getLogger(HttpUtil.class);
	
	/**
	 * post调用 http返回字符串
	 * @param URL 路径 例如:http://www.raintai.com
	 * @return  json字符串
	 */
	public static String doHttpPost(String URL,Map<String, String> params) {
		LOG.info("调用外部http服务:" + URL);
		
		StringBuilder sendData = new StringBuilder();  
		if(params!=null&&params.size()>0){
			for(Entry<String, String> entry : params.entrySet()){
	            sendData.append(entry.getKey()).append("=").append(entry.getValue()).append("&");  
	        }  
	        if(sendData.length() > 0){  
	            sendData.setLength(sendData.length() - 1); //删除最后一个&符号  
	        }  
		}
        
		InputStream instr = null;
		ByteArrayOutputStream outStream=null;
		try {
			URL url = new URL(URL);
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setDoOutput(true);
			urlCon.setDoInput(true);
			urlCon.setUseCaches(false);
			urlCon.setRequestMethod("POST");  
			urlCon.setRequestProperty("Content-Type", "text/xml");
			//urlCon.setRequestProperty("Content-length", String.valueOf(sendData.length()));
			DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream());
			printout.write(sendData.toString().getBytes());
			printout.flush();
			printout.close();
			instr = urlCon.getInputStream();
			String ResponseString = null;
			
			if (instr != null) {
				outStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = instr.read(buffer)) != -1) {
					outStream.write(buffer, 0, len);
				}
				instr.close();
				outStream.close();
				ResponseString=new String(outStream.toByteArray());
			}
			
			LOG.warn("返回数据为:{}", ResponseString);
			return ResponseString;
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		} finally {
			try {
				outStream.close();
				instr.close();

			} catch (Exception ex) {
				return "0";
			}
		}
		
		
	}

	 /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param params
     *            请求参数。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, Map<String, String> params) {
    	StringBuilder sendData = new StringBuilder();  
		if(params!=null&&params.size()>0){
			for(Entry<String, String> entry : params.entrySet()){
	            sendData.append(entry.getKey()).append("=").append(entry.getValue()).append("&");  
	        }  
	        if(sendData.length() > 0){  
	            sendData.setLength(sendData.length() - 1); //删除最后一个&符号  
	        }  
		}
		
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            conn.setRequestProperty("Accept-Encoding", "deflate");
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(sendData);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    


	public static String httpGet(String url,boolean isRetry){
		String reValue = null;
		CloseableHttpClient httpclient = createHttpClient(isRetry);

		// 创建Get方法实例
		HttpGet httpgets = new HttpGet(url);
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(20000)//设置连接超时时间 20s
				.setConnectionRequestTimeout(3000)//设置从connect Manager获取Connection 超时时间
				.setSocketTimeout(30000).build();//请求获取数据的超时时间 15s
		httpgets.setConfig(requestConfig);
		try {
			HttpResponse response = httpclient.execute(httpgets);
			HttpEntity entity = response.getEntity();
			int status = response.getStatusLine().getStatusCode();
			if (200 == status) {
				if (entity != null) {
					reValue = EntityUtils.toString(entity, "UTF-8");
					// Do not need the rest
					httpgets.abort();
				}
			}
		}catch (Exception ex){
			ex.printStackTrace();
		} finally {
			if (null != httpclient){
				try {
					httpclient.close();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		return reValue;
	}
	
	
	public static String sendPost(String url,Map<String,Object> map,boolean isRetry){  
		System.out.println(url);
		CloseableHttpClient httpClient = null;  
        HttpPost httpPost = null;  
        String result = null;  
        try{  
            httpClient = createHttpClient(isRetry);
            httpPost = new HttpPost(url);  
            //设置参数  
            List<NameValuePair> list = new ArrayList<NameValuePair>();  
            Iterator iterator = map.entrySet().iterator();  
            while(iterator.hasNext()){  
                Entry<String,Object> elem = (Entry<String, Object>) iterator.next();  
                list.add(new BasicNameValuePair(elem.getKey(),""+elem.getValue()));  
            }  
            if(list.size() > 0){  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"gbk");  
                httpPost.setEntity(entity);  
            }  
            HttpResponse response = httpClient.execute(httpPost);  
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,"gbk");  
                }  
            }  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
        return result;  
    }  
	
	public static CloseableHttpClient createHttpClient(boolean isRetry) {
		CloseableHttpClient httpclient = null;
	if(isRetry) {//请求重试处理
		HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				if (executionCount >= 5) {// 如果已经重试了5次，就放弃
					return false;
				}
				if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
					return true;
				}
				if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常
					return false;
				}
				if (exception instanceof InterruptedIOException) {// 超时
					return false;
				}
				if (exception instanceof UnknownHostException) {// 目标服务器不可达
					return false;
				}
				if (exception instanceof ConnectTimeoutException) {// 连接被拒绝
					return false;
				}
				if (exception instanceof SSLException) {// ssl握手异常
					return false;
				}

				HttpClientContext clientContext = HttpClientContext.adapt(context);
				HttpRequest request = clientContext.getRequest();
				// 如果请求是幂等的，就再次尝试
				if (!(request instanceof HttpEntityEnclosingRequest)) {
					return true;
				}
				return false;
			}
		};
		httpclient = HttpClients.custom().setRetryHandler(httpRequestRetryHandler).build();// 创建HttpClient实例
	}else{
		httpclient = HttpClients.createDefault();// 创建HttpClient实例
	}
	return httpclient;
}
}
