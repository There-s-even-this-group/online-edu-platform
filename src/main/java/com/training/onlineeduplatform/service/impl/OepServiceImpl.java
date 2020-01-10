package com.training.onlineeduplatform.service.impl;

import com.training.onlineeduplatform.mapper.OepMapper;
import com.training.onlineeduplatform.model.Oep;
import com.training.onlineeduplatform.service.OepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 2020/1/10.
 *
 * @author Yue Wu
 */
@Service
@Transactional
public class OepServiceImpl implements OepService, UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    OepMapper rmMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Oep rm = rmMapper.loadUserByUsername(username);
        if (rm == null) {
            throw new UsernameNotFoundException("账户不存在！");
        }
        rm.setRoles(rmMapper.getUserRolesByUid(rm.getId()));
        return rm;
    }

    @Override
    public void addRm(String name, String username, String passowrd, String role) {
        rmMapper.saveNewRm(name,username,passwordEncoder.encode(passowrd),role);
    }
}
