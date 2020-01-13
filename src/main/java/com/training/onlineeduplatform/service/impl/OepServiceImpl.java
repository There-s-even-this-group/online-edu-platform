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
 * 实现 UserDetailsService 接口，并实现该接口中的 loadUserByUsemame 方法，
 * loadUserByUsemame 方法是根据用户名查询用户的所有信息，包括用户的角色，如果没有查到相关用户
 * 就抛出 UsernameNotFoundException 常，表示用户不存在 ，如果查到了，就直接返回，
 * 由 SpringSecurity 框架完成密码的对比操作。
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
