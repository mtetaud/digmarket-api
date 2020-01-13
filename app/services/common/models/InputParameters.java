package services.common.models;

import exceptions.DefaultHttpExceptionType;
import exceptions.HttpException;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class InputParameters {

    // url
    public String host;
    public String resourcePattern;
    public List<String> pathParams;
    public Map<String, String> queryParams;

    // request
    public String httpMethod;
    public Map<String, String> httpHeaders;

    public String getUrl() {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(this.host+this.resourcePattern);

        if(Objects.nonNull(pathParams)){
            for(String param : pathParams){
                urlBuilder = new StringBuilder(urlBuilder.toString().replaceFirst("#", param));
            }
        }

        if(urlBuilder.toString().contains("#")){
            throw new HttpException(DefaultHttpExceptionType.UNKNOWN_ERROR);
        }

        return urlBuilder.toString();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getResourcePattern() {
        return resourcePattern;
    }

    public void setResourcePattern(String resourcePattern) {
        this.resourcePattern = resourcePattern;
    }

    public List<String> getPathParams() {
        return pathParams;
    }

    public void setPathParams(List<String> pathParams) {
        this.pathParams = pathParams;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Map<String, String> getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(Map<String, String> httpHeaders) {
        this.httpHeaders = httpHeaders;
    }
}
