package com.obvious.core.rest;

public class RestResponses {

    /**
     * build default rest response with default value.
     * @return
     */
    public static RestResponse buildDefaultRestResponse() {
        RestResponse response = new RestResponse();
        response.setHeader(buildDefaultRestResponseHeader());
        response.setBody(buildDefaultRestResponseBody());
        return response;
    }

    /**
     * build default rest response header with default value.
     * @return
     */
    public static RestResponseHeader buildDefaultRestResponseHeader() {
        RestResponseHeader header = new RestResponseHeader();
        return header;
    }

    public static RestResponseHeader buildRestResponseHeader(Integer version) {
        RestResponseHeader header = new RestResponseHeader();
        header.setVersion(version);
        return header;
    }

    public static RestResponseHeader buildRestResponseHeader (
            Integer version, Integer lastStableVersion) {
        RestResponseHeader header = new RestResponseHeader();
        header.setVersion(version);
        header.setLastStableVersion(lastStableVersion);
        return header;
    }

    public static RestResponseHeader buildRestResponseHeader(
            String usage, Integer version, Integer lastStableVersion) {
        RestResponseHeader header = new RestResponseHeader();
        header.setUsage(usage);
        header.setVersion(version);
        header.setLastStableVersion(lastStableVersion);
        return header;
    }

    public static RestResponseHeader buildRestResponseHeader(
            String appName, String usage,
            Integer version, Integer lastStableVersion) {
        RestResponseHeader header = new RestResponseHeader();
        header.setAppName(appName);
        header.setUsage(usage);
        header.setVersion(version);
        header.setLastStableVersion(lastStableVersion);
        return header;
    }

    /**
     * build default rest response body with default value
     * @return
     */
    public static RestResponseBody buildDefaultRestResponseBody() {
        RestResponseBody body = new RestResponseBody();
        return body;
    }

    /**
     * build rest response body with response data.
     * @param data
     * @return
     */
    public static RestResponseBody buildRestResponseBody(Object data) {
        return buildRestResponseBody(data, null, null);
    }

    /**
     * build rest response body with error info.
     * @param error
     * @return
     */
    public static RestResponseBody buildRestErrorResponseBody(Object error) {
        return buildRestResponseBody(null, error, null);
    }

    /**
     * build rest response body with response data and error info.
     * @param data
     * @param error
     * @return
     */
    public static RestResponseBody buildRestErrorResponseBody(Object data, Object error) {
        return buildRestResponseBody(data, error, null);
    }

    /**
     * build rest response body with warn info
     * @param warn
     * @return
     */
    public static RestResponseBody buildRestWarnResponseBody(Object warn) {
        return buildRestResponseBody(null, null, warn);
    }

    /**
     * build rest response body with response data and warn info
     * @param data
     * @param warn
     * @return
     */
    public static RestResponseBody buildRestWarnResponseBody(Object data, Object warn) {
        return buildRestResponseBody(data, null, warn);
    }

    /**
     * build rest response body with response data， error info and warn info
     * @param data
     * @param error
     * @param warn
     * @return
     */
    public static RestResponseBody buildRestResponseBody(Object data, Object error, Object warn) {
        return new RestResponseBody(data, error, warn);
    }

}
