package com.soft.security.controller;

import com.soft.common.model.ResponseModel;
import com.soft.common.utils.JwtTokenUtil;
import com.soft.security.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sucx
 * @projectName moto_parent
 * @description:
 * @date 2020/5/1115:54
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseModel login(@RequestBody SystemUser sysUser){
        final UserDetails userDetails = userDetailsService.loadUserByUsername(sysUser.getUserCode());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseModel.ok(ResponseModel.SELECT_SUCCESS,token);
    }

}
