package com.course.server.service;

import com.course.server.dto.CategoryDto;
import com.course.server.dto.CourseCategoryDto;
import com.course.server.dto.PageDto;

import java.util.List;

/**
 * @author jiange
 * @date 2020/7/6 11:20
 */
public interface CourseCategoryService {
    void list(PageDto pageDto);

    void save(CourseCategoryDto courseCategoryDto);

    void delete(String id);

    void saveBatch(String courseId, List<CategoryDto> dtoList);

    List<CourseCategoryDto> listByCourse(String courseId);
}
