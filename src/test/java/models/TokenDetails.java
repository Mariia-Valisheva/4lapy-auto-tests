package models;

import lombok.Data;

@Data
public class TokenDetails {
    private String accessToken, refreshToken, tokenType, sessionState, scope;
    private int expiresIn, refreshExpiresIn;
}
