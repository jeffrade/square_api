package com.github.jeffrade.square.api.controller;

import com.github.jeffrade.square.api.model.JsonApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class OAuth2Controller {

    @Value("${square.app.name}")
    private String squareAppName;

    @Value("${square.api.applicationId}")
    private String squareApiApplicationId;

    @Value("${square.api.acceptToken}")
    private String squareApiAcceptToken;

    @Value("${square.api.applicationSecret}")
    private String squareApiApplicationSecret;

    @RequestMapping("/status")
    public JsonApiResponse status() {
        log.info("Entering /status...");
        log.debug("squareAppName={}", squareAppName);
        log.debug("squareApiApplicationId={}", squareApiApplicationId);
        log.debug("squareApiAcceptToken={}", squareApiAcceptToken);
        log.debug("squareApiApplicationSecret={}", squareApiApplicationSecret);
        return new JsonApiResponse(200);
    }

    @RequestMapping(value="/oauth-redirect", method=RequestMethod.GET)
    public JsonApiResponse oauthRedirect(final HttpServletRequest request) {
        log.info("Entering /oauth-redirect...");
        JsonApiResponse resp = new JsonApiResponse(200);
        resp.addData("ip", request.getRemoteAddr());
        return resp;
    }

}
