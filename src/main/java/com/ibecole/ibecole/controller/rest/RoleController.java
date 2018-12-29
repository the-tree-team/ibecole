package com.ibecole.ibecole.controller.rest;


import com.ibecole.ibecole.entity.admin.Role;
import com.ibecole.ibecole.payload.UserIdentityAvailability;
import com.ibecole.ibecole.payload.UserSummary;
import com.ibecole.ibecole.repository.admin.RoleRepository;
import com.ibecole.ibecole.repository.admin.UserRepository;
import com.ibecole.ibecole.security.CurrentUser;
import com.ibecole.ibecole.security.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;


    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }



}
