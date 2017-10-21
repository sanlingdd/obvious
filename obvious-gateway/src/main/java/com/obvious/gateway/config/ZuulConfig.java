package com.obvious.gateway.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@Configurable
@EnableZuulProxy
public class ZuulConfig {

}
