package com.example.demo.service;

import com.example.demo.po.request.UserRequest;
import com.example.demo.po.response.BaseResponse;

public interface UserService {

    BaseResponse getUsers(UserRequest userRequest);

    BaseResponse getUserById(Integer id);

}
