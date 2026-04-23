package com.hospital.system.Security;

import com.hospital.system.Entity.User;
import com.hospital.system.Repository.UserRepository;
import com.hospital.system.dto.LoginRequestDto;
import com.hospital.system.dto.LoginResponseDto;
import com.hospital.system.dto.SignUpRequestDto;
import com.hospital.system.dto.SignUpResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto generateToken(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        assert user != null;
        String token= jwtUtil.getToken(user);
        return new LoginResponseDto(token,user.getId());
    }
    public SignUpResponseDto Registration(@RequestBody SignUpRequestDto signUpRequestDto){
        User user= userRepository.findByUsername(signUpRequestDto.getUsername()).orElse(null);
        if(user!=null){
            throw new IllegalArgumentException("User already exists");
        }
        user=userRepository.save(User.builder()
                .username(signUpRequestDto.getUsername())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .build());
        return new SignUpResponseDto(user.getUsername(),user.getId());
    }
}
