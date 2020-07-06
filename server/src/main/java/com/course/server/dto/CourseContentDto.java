package com.course.server.dto;

import lombok.Data;

/**
 * @author jiange
 * @date 2020/7/6 17:50
 */
@Data
public class CourseContentDto {

    /**
     * 课程id
     */
    private String id;

    /**
     * 课程内容
     */
    private String content;
}
