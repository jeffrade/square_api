package com.github.jeffrade.square.api.controller;

import com.github.jeffrade.square.api.model.JsonApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuth2Controller {

    @RequestMapping("/status")
    public JsonApiResponse status() {
        return new JsonApiResponse(200);
    }

}
