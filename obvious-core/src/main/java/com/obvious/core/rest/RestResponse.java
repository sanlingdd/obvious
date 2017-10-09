package com.obvious.core.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RestResponse implements Serializable {

    @Autowired
    private RestResponseHeader header;

    @Autowired
    private RestResponseBody body;
}
