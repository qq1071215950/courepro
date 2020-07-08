package com.course.server.service;

import com.course.server.dto.CourseContentDto;
import com.course.server.dto.PageDto;

public interface CourseContentService {

    /**
     * 列表查询
     */
    public void list(PageDto pageDto);

    /**
     * 保存，id有值时更新，无值时新增
     */
    void save(CourseContentDto courseContentDto);

    /**
    * 删除
    */
    void delete(String id);
}
