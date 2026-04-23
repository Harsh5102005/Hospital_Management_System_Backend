package com.hospital.system.Controller;

import com.hospital.system.Security.AuthService;
import com.hospital.system.dto.LoginRequestDto;
import com.hospital.system.dto.LoginResponseDto;
import com.hospital.system.dto.SignUpRequestDto;
import com.hospital.system.dto.SignUpResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(authService.generateToken(loginRequestDto));
    }
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signup(@RequestBody SignUpRequestDto signUpRequestDto ){
        return ResponseEntity.ok(authService.Registration(signUpRequestDto));
    }


}
