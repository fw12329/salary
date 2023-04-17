package com.salary.backend.service.impl.user.account;

import com.salary.backend.mapper.UserMapper;
import com.salary.backend.pojo.User;
import com.salary.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class RegisterServiceImpl implements RegisterService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String,String> map = new HashMap<>();
        if(username == null) {
            map.put("error_message","姓名不能为空");
            return map;
        }
        if(password == null || confirmedPassword == null) {
            map.put("error_message","密码或确认密码不能为空");
        }
        username = username.trim();
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(null,username,encodedPassword);
        userMapper.insert(user);
        map.put("error_message","success");
        return map;
    }
}
