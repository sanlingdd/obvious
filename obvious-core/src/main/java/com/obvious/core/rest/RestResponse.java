package com.obvious.core.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse implements Serializable {

    private RestResponseHeader header = new RestResponseHeader();

    private RestResponseBody body = new RestResponseBody();

    public RestResponse appName (String appName) {

        this.header.setAppName(appName);
        return this;
    }

    public RestResponse usage(String usage) {
        this.header.setUsage(usage);
        return this;
    }

    public RestResponse version (int version) {
        this.header.setVersion(version);
        return this;
    }

    public RestResponse lastStableVersion(int lastStableVersion) {
        this.header.setLastStableVersion(lastStableVersion);
        return this;
    }

    public RestResponse data (Object data) {
        this.body.setData(data);
        return this;
    }

    public RestResponse error (Object error) {
        this.body.setError(error);
        return this;
    }

    public RestResponse warn(Object warn) {
        this.body.setWarn(warn);
        return this;
    }
}
