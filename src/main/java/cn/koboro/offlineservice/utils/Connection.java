package cn.koboro.offlineservice.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author xdw
 */
public class Connection {

    private Connection() {

    }

    private MultiValueMap params;

    private Connection(HttpMethod method) {
        this.method = method;
        this.params = new LinkedMultiValueMap<>();
    }

    private HttpMethod method;

    private static RestTemplate restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());

    public static Connection newPOST() {
        return new Connection(HttpMethod.POST);
    }

    public static Connection newGET() {
        return new Connection(HttpMethod.GET);
    }

    public <T> T send(String url, Class<T> responseType) {
        return send(url, new HttpHeaders() {{
            add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        }}, responseType);
    }

    public <T> T send(String url, HttpHeaders headers, Class<T> responseType) {
        return (T) restTemplate.exchange(url, method, new HttpEntity(params, headers), responseType).getBody();
    }

    public <T> T send(String url, Object params, Class<T> responseType) {
        return send(url, params, new HttpHeaders(), responseType);
    }

    public <T> T send(String url, Object params, HttpHeaders headers, Class<T> responseType) {
        headers.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        return restTemplate.exchange(url, method, new HttpEntity(params, headers), responseType).getBody();
    }

    public Connection setParam(Object key, Object value) {
        params.set(key, value);
        return this;
    }

}
