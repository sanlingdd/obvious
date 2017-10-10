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
public class RestResponseBody implements Serializable{

    private Object data;

    private Object error;

    private Object warn;

}
