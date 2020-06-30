package com.course.server.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

/**
 * 统一返回对象，后续进行优化
 * @author jiange
 * @date 2020/6/30 17:23
 */
@Setter
@Getter
@ToString
public class ResponseDto<T> {
    /**
     * 业务上的成功或失败
     */
    private boolean success = true;

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private T content;
}
