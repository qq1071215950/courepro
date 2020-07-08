package com.course.server.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseContentFileDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * course_id
     */
    private String courseId;
    /**
     * url
     */
    private String url;
    /**
     * name
     */
    private String name;
    /**
     * size
     */
    private Integer size;
}
