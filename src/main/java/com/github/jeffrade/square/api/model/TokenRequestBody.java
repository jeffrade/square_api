package com.github.jeffrade.square.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TokenRequestBody {

    public String client_id; // YOUR_APPLICATION_ID

    public String client_secret; // YOUR_APPLICATION_SECRET

    public String code; // YOUR_CODE

    public String redirect_uri; // YOUR_REDIRECT_URI
}
