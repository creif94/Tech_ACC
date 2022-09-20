package com.example.ReviewTestround3;

public class AuthenticateDTO {

    private Boolean authenticated;
    private User user;

    public AuthenticateDTO(User user, Boolean authenticated) {
        this.authenticated = authenticated;
        this.user = user;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
