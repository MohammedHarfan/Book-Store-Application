package com.store.service;

import com.store.model.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
