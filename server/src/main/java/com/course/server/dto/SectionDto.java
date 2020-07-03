package com.course.server.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SectionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * title
     */
    private String title;
    /**
     * course_id
     */
    private String courseId;
    /**
     * chapter_id
     */
    private String chapterId;
    /**
     * video
     */
    private String video;
    /**
     * time
     */
    private Integer time;
    /**
     * charge
     */
    private String charge;
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
     * vod
     */
    private String vod;
}
