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
public class RestResponseHeader implements Serializable {

    private String appName = "undefined";

    private String usage = "no usage info";

    private int version;

    private int lastStableVersion;
}
