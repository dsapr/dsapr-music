package com.dsapr.dsaprmusic.controller;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/weixin")
public class WeixinController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/auth_url")
    public String getAuthUrl(@PathParam("redirect") String redirect) {
        return wxMpService.getOAuth2Service().buildAuthorizationUrl(redirect, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
    }

}















