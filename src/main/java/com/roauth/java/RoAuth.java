package com.roauth.java;

import com.roauth.java.constants.RoAuthClient;
import org.dmfs.oauth2.client.OAuth2AccessToken;
import org.dmfs.oauth2.client.OAuth2InteractiveGrant;
import org.dmfs.oauth2.client.grants.AuthorizationCodeGrant;
import org.dmfs.oauth2.client.scope.BasicScope;

import java.net.URI;

public class RoAuth {
    private final RoAuth instance;
    private final RoAuthClient roAuthClient;
    public RoAuth() {
        this.instance = this;
        this.roAuthClient = new RoAuthClient("client_id", "client_secret", "http://localhost:12229/oauth/redirect");
    }

    public void startOwo() {

    }

    public static RoAuth getInstance() {
        return new RoAuth();
    }
}