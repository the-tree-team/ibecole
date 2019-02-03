package com.ibecole.ibecole.controller.rest;


import com.ibecole.ibecole.entity.admin.Role;
import com.ibecole.ibecole.entity.admin.RoleName;
import com.ibecole.ibecole.entity.admin.User;
import com.ibecole.ibecole.exception.AppException;
import com.ibecole.ibecole.payload.ApiResponse;
import com.ibecole.ibecole.payload.JwtAuthenticationResponse;
import com.ibecole.ibecole.payload.LoginRequest;
import com.ibecole.ibecole.payload.SignUpRequest;
import com.ibecole.ibecole.repository.admin.RoleRepository;
import com.ibecole.ibecole.repository.admin.UserRepository;
import com.ibecole.ibecole.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;


    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostConstruct
    public void init (){
        if (roleRepository.count()==0) {
            Role role = new Role();
            Role role1 = new Role();
            role.setName(RoleName.ROLE_USER);
            role1.setName(RoleName.ROLE_ADMIN);
            List<Role> list = new ArrayList<>();
            list.add(role);
            list.add(role1);
            roleRepository.saveAll(list);
        }

        User user = new User("allaoua", "allaoua",
                "allaoua@gmail.com", passwordEncoder.encode("allaoua"));



        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));
        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                .orElseThrow(() -> new AppException("User Role not set."));
        List roles= new ArrayList();
        roles.add(adminRole);
        roles.add(userRole);
        user.setRoles(roles);

        User result = userRepository.save(user);
        }


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequest loginRequest) {


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody @Valid SignUpRequest signUpRequest) {
        System.out.println( " dans la fonction signe up"+signUpRequest.getRoles());
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        System.out.println( "create account ");
        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

//        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
         //       .orElseThrow(() -> new AppException("User Role not set."));

//        user.setRoles(Collections.singleton(userRole));
        List<Role> roles= new ArrayList();
       signUpRequest.getRoles()
                .stream()
                .forEach(
                    a -> {
                        roles.add(roleRepository.findByName(a.getName()).get());
                        System.out.println(roles);

                });


        user.setRoles(roles);


        System.out.println("After le foreach roles signup "+roles);
        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}
