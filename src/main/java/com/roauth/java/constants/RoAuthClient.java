package com.roauth.java.constants;

import org.dmfs.httpessentials.client.HttpRequestExecutor;
import org.dmfs.httpessentials.exceptions.ProtocolError;
import org.dmfs.httpessentials.exceptions.ProtocolException;
import org.dmfs.httpessentials.httpurlconnection.HttpUrlConnectionExecutor;
import org.dmfs.oauth2.client.*;
import org.dmfs.oauth2.client.grants.AuthorizationCodeGrant;
import org.dmfs.oauth2.client.scope.BasicScope;
import org.dmfs.rfc3986.encoding.Precoded;
import org.dmfs.rfc3986.uris.LazyUri;
import org.dmfs.rfc5545.Duration;

import java.net.URI;

public class RoAuthClient {
    private final HttpRequestExecutor executor = new HttpUrlConnectionExecutor();
    private final OAuth2Client client;

    public RoAuthClient(String clientId, String clientSecret, String redirectUri) {
        this.client = this.initiate(clientId, clientSecret, redirectUri);
    }

    private OAuth2Client initiate(String clientId, String clientSecret, String redirectUri) {
// Create OAuth2 provider
        OAuth2AuthorizationProvider provider = new BasicOAuth2AuthorizationProvider(
                URI.create("https://authorize.roblox.com/"),
                URI.create("https://apis.roblox.com/oauth/v1/token"),
                new Duration(1, 0, 3600));

        OAuth2ClientCredentials credentials = new BasicOAuth2ClientCredentials(
                clientId,
                clientSecret
        );

        return new BasicOAuth2Client(
                provider,
                credentials,
                new LazyUri(new Precoded(redirectUri)));
    }

    public OAuth2AccessToken getAccessToken(String code) throws ProtocolException, ProtocolError {

        OAuth2InteractiveGrant grant = new AuthorizationCodeGrant(
                client, new BasicScope("scope"));

        URI authorizationUrl = grant.authorizationUrl();

        return grant.withRedirect(client.redirectUri()).accessToken(executor);
    }

    public OAuth2Client getClient() {
        return this.client;
    }

}
