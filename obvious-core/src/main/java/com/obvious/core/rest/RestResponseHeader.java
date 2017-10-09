package com.obvious.core.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RestResponseHeader implements Serializable {

    @Value("${spring.application.name:'undefined'}")
    private String appName;

    private String usage;

    private Integer version;

    private Integer lastStableVersion;
}
