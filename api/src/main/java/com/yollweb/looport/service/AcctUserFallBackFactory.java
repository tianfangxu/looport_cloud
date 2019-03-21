package com.yollweb.looport.service;

import com.yollweb.looport.content.ResultModel;
import com.yollweb.looport.process.request.LoginUserModel;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class AcctUserFallBackFactory implements FallbackFactory<AcctUserFeignService> {
    @Override
    public AcctUserFeignService create(Throwable throwable) {
        return new AcctUserFeignService() {
            @Override
            public ResultModel login(LoginUserModel model) {
                ResultModel rm = new ResultModel();
                rm.setCode(500).setMsg("服务正在维护升级中...").setSuccess(false);
                return rm;
            }
        };
    }
}
