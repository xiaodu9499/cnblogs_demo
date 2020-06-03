package com.example.demo;

import com.example.demo.annotation.MyConstraint;
import com.example.demo.po.request.UserRequest;
import com.example.demo.po.response.BaseResponse;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void testValidateObj() {
        UserRequest userRequest = new UserRequest();
        BaseResponse users = userService.getUsers(userRequest);
        System.out.println(users);

    }

    @Test
    void testValidateMyConstraint() {
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("蟑螂恶霸");
        userRequest.setAge(22);
        List<Integer> objects = new ArrayList<>();
        objects.add(2);
        userRequest.setChild(objects);
        BaseResponse users = userService.getUsers(userRequest);
        System.out.println(users);

    }



    @Test
    void testValidateObjNull() {
        BaseResponse users1 = userService.getUsers(null);
        System.out.println(users1);
    }

    @Test
    void testValidateSingle() {

        BaseResponse users = userService.getUserById(null);
        System.out.println(users);
    }

}
