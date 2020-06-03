package com.example.demo.service.impl;

import com.example.demo.po.request.UserRequest;
import com.example.demo.po.response.BaseResponse;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public BaseResponse getUsers(@Valid UserRequest userRequest) {
        BaseResponse response = new BaseResponse();
        response.setCode(0);
        response.setMsg("操作成功");
        return response;
    }

    @Override
    public BaseResponse getUserById(@Valid @NotNull(message = "id必填") Integer id) {
        return null;
    }
}
