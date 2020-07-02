package com.course.server.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CourseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * name
     */
    private String name;
    /**
     * summary
     */
    private String summary;
    /**
     * time
     */
    private Integer time;
    /**
     * price
     */
    private BigDecimal price;
    /**
     * image
     */
    private String image;
    /**
     * level
     */
    private String level;
    /**
     * charge
     */
    private String charge;
    /**
     * status
     */
    private String status;
    /**
     * enroll
     */
    private Integer enroll;
    /**
     * sort
     */
    private Integer sort;
    /**
     * created_at
     */
    private Date createdAt;
    /**
     * updated_at
     */
    private Date updatedAt;
    /**
     * teacher_id
     */
    private String teacherId;
}
