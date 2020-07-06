package com.course.server.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherDto implements Serializable {

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
     * nickname
     */
    private String nickname;
    /**
     * image
     */
    private String image;
    /**
     * position
     */
    private String position;
    /**
     * motto
     */
    private String motto;
    /**
     * intro
     */
    private String intro;
}
