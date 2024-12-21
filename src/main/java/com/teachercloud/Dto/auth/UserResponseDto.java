package com.teachercloud.Dto.auth;

public class UserResponseDto {
    private String email;
    private String name;
    private String lastName;
    private String token;

    public UserResponseDto(String email, String name, String lastName, String token) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getToken() {
        return token;
    }


}
