package models;

import lombok.Data;

@Data
public class LoginResponse {
    private String type;
    private TokenDetails token;
}
