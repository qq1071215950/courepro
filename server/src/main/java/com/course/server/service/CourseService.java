package com.course.server.service;

import com.course.server.dto.CourseContentDto;
import com.course.server.dto.CourseDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.SortDto;

public interface CourseService {

    /**
     * 列表查询
     */
    public void list(PageDto pageDto);

    /**
     * 保存，id有值时更新，无值时新增
     */
    void save(CourseDto courseDto);

    /**
    * 删除
    */
    void delete(String id);

    /**
     * 更新时长
     * @param courseId
     */
    void updateTime(String courseId);

    CourseContentDto findContent(String id);

    int saveContent(CourseContentDto contentDto);

    void sort(SortDto sortDto);
}
