package com.yollweb.looport.service;

import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.process.request.UserModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * fallbackFactory:MANAGESERVICE服务的降级处理
 */
@FeignClient(value = "MANAGESERVICE",fallbackFactory = AcctUserFallBackFactory.class)
public interface AcctUserFeignService {

    @RequestMapping("login")
    public ResultModel login(@RequestBody UserModel model);
}
