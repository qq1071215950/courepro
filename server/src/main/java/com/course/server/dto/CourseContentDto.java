package com.course.server.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseContentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * content
     */
    private String content;
}
