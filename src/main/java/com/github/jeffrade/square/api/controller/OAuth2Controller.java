package com.github.jeffrade.square.api.controller;

import com.github.jeffrade.square.api.model.JsonApiResponse;
import com.github.jeffrade.square.api.model.TokenRequestBody;
import com.github.jeffrade.square.api.service.OAuth2Service;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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

    @Autowired
    private OAuth2Service oAuth2Service;

    @RequestMapping("/status")
    public JsonApiResponse status() {
        log.info("Entering /status...");
        return new JsonApiResponse(200, "Up and running!");
    }

    @RequestMapping(value="/oauth/token", method=RequestMethod.GET)
    public JsonApiResponse oauthToken(final HttpServletRequest request) {
        log.info("Entering /oauth/token");
        Response<ResponseBody> resp = null;
        int status = 200;
        String message = null;
        try {
            TokenRequestBody body = new TokenRequestBody(
                squareApiApplicationId, squareApiApplicationSecret, squareApiAcceptToken, "oauth-redirect");
            final String jsonBody = new Gson().toJson(body);
            resp = oAuth2Service
                .token(jsonBody)
                .execute();
            ResponseBody respBody = resp.body();
            message = respBody == null ? resp.raw().toString() : respBody.string();
        } catch (IOException e) {
            status = resp.code();
            if(resp.errorBody() != null) {
                try {
                    message = resp.errorBody().string();
                } catch (IOException ioe) {
                    status = 500;
                    log.error("Encountered an error trying to get errors", ioe);
                }
            }
            log.error("Sorry, we encountered an error.", e);
        } catch (Exception e) {
            status = 500;
            message = "Sorry, we encountered an unknown error.";
            log.error(message, e);
        }

        return new JsonApiResponse(status, message);
    }

    @RequestMapping(value="/oauth-redirect", method=RequestMethod.GET)
    public JsonApiResponse oauthRedirect(final HttpServletRequest request) {
        log.info("Entering /oauth-redirect...");
        JsonApiResponse resp = new JsonApiResponse(200);
        resp.addData("ip", request.getRemoteAddr());
        return resp;
    }

}
