package com.course.server.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * parent
     */
    private String parent;
    /**
     * name
     */
    private String name;
    /**
     * sort
     */
    private Integer sort;
}
