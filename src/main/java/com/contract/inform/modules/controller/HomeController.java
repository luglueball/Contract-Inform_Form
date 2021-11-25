package com.contract.inform.modules.controller;

import com.contract.inform.common.utils.R;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController{
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation("刷新请求")
    @GetMapping("/refresh")
    public R refresh(HttpServletRequest request) {
        return R.ok();
    }
}
