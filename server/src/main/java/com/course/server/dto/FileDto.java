package com.course.server.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FileDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;
    /**
     * path
     */
    private String path;
    /**
     * name
     */
    private String name;
    /**
     * suffix
     */
    private String suffix;
    /**
     * size
     */
    private Integer size;
    /**
     * use
     */
    private String use;
    /**
     * created_at
     */
    private Date createdAt;
    /**
     * updated_at
     */
    private Date updatedAt;
    /**
     * shard_index
     */
    private Integer shardIndex;
    /**
     * shard_size
     */
    private Integer shardSize;
    /**
     * shard_total
     */
    private Integer shardTotal;
    /**
     * key
     */
    private String key;
    /**
     * vod
     */
    private String vod;
}
