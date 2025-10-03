package com.base.admin.controller;

import com.base.admin.dto.authentication.LoginRequest;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.service.AuthenticationService;
import com.base.admin.service.InitializeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;


//@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final InitializeService initializeService;

    public AuthenticationController(AuthenticationService authenticationService, InitializeService initializeService) {
        this.authenticationService = authenticationService;

        this.initializeService = initializeService;
    }


    @Async
    @PostMapping("/login")
    public CompletableFuture<ResponseEntity<Object>> login(@RequestBody LoginRequest request) {
        try {
            Authentication authentication = authenticationService.authenticateUser(request);
            if (authentication.isAuthenticated()) {
                return CompletableFuture.completedFuture(ResponseHandler.generateResponseSuccess("", authenticationService.buildAuthenticateResponse(authentication)));
            }
        } catch (Exception e) {
            return CompletableFuture.completedFuture(ResponseHandler.generateResponseError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
        return CompletableFuture.completedFuture(ResponseHandler.generateResponseError("UNAUTHORIZED", HttpStatus.UNAUTHORIZED));
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> logout() {
        return ResponseEntity.ok(authenticationService.logout());
    }

    @PostMapping("/initDB")
    public ResponseEntity<Boolean> initDB() {
        return ResponseEntity.ok(initializeService.initializeRoleMenuAuthority());
    }
}


