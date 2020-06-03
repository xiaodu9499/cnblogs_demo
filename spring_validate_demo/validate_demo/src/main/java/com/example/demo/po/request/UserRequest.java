package com.example.demo.po.request;

import com.example.demo.annotation.MyConstraint;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

@Data
public class UserRequest implements Serializable {

    @MyConstraint(message = "名称必须为tom")
    @NotBlank(message = "用户名必填")
    private String userName;

    @NotNull(message = "年龄必填")
    @Min(value = 1, message = "年龄最小为1岁")
    @Max(value = 100, message = "年龄最大为100岁")
    private Integer age;

    @NotNull(message = "用户的孩子不能为空")
    @Size(min = 1, max = 10, message = "孩子的个数不能小于1,不能大于10")
    private List<Integer> child;

}
