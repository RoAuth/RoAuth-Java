package com.roauth.java.manager;

import com.roauth.java.RoAuth;
import org.dmfs.httpessentials.client.HttpRequestExecutor;
import org.dmfs.httpessentials.httpurlconnection.HttpUrlConnectionExecutor;
import org.dmfs.oauth2.client.*;
import org.dmfs.rfc3986.encoding.Precoded;
import org.dmfs.rfc3986.uris.LazyUri;

import java.net.URI;
import java.time.Duration;

public class AuthManager {
    private final RoAuth auth;

    public AuthManager(RoAuth auth) {
        this.auth = auth;
    }

    public void startClient(String owo) {

    }
}
