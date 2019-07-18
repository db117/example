package com.db117.example.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author db117
 * @date 2019/7/18
 **/
@FeignClient(name = "db117", url = "${db117}")
public interface FeignExample {
    @GetMapping
    public String db117();
}
