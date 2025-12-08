package com.example.rideshare.service;

import com.example.rideshare.dto.LoginRequest;
import com.example.rideshare.dto.RegisterRequest;

public interface AuthService {
    String register(RegisterRequest request);

    String login(LoginRequest request);
}
