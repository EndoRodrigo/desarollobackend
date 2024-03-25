package com.back.demo.service;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.back.demo.model.User;
import com.back.demo.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class UserService {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private int jwtExpiration;

    @Autowired
    private UserRepository userRepository;

    public String getUser(User user){
        Optional<User> data = userRepository.findById(user.getId());
        //Optional<User> data = userRepository.findByName(user);
        if (data.isEmpty()) {
            return null;
        }else{
            return generarToken(data);
        }
    }

    private String generarToken(Optional<User> data) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        Date expirationDate = new Date(System.currentTimeMillis() + jwtExpiration * 1000);
        return Jwts.builder()
                .setSubject(Long.toString(data.get().getId()))
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key)
                .compact();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

}
