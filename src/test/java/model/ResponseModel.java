package model;

import lombok.Data;

@Data
public class ResponseModel {
    private String accessToken, refreshToken, tokenType, expiresIn, sessionState, scope, refreshExpiresIn;
}
