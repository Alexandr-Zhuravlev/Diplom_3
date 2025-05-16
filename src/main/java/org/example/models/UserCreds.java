package org.example.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UserCreds {
    private String email;
    private String password;
}
