package com.obvious.core.rest;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class RestResponse implements Serializable {

    @Autowired
    private RestResponseHeader header;

    @Autowired
    private RestResponseBody body;
}
