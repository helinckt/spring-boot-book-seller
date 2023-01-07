package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

public interface IAuthenticationService {


    User signInAndReturnJWT(User signInRequest);
}

