package com.course.server.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author jiange
 * @date 2020/6/29 19:22
 */
@Setter
@Getter
@ToString
public class PageDto<T> {
    /**
     * 当前页码
     */
    protected int page;

    /**
     * 每页条数
     */
    protected int size;

    /**
     * 总条数
     */
    protected long total;

    protected List<T> list;
}
