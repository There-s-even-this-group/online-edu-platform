package com.training.onlineeduplatform.service;

import com.training.onlineeduplatform.model.Oep;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created on 2020/1/10.
 *
 * @author Yue Wu
 */
public interface OepService {
    UserDetails loadUserByUsername(String username);
    void addRm(String name,String username,String passowrd, String role);
}
