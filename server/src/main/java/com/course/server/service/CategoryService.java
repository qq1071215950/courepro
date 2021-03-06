package com.course.server.service;

import com.course.server.dto.CategoryDto;
import com.course.server.dto.PageDto;

import java.util.List;

public interface CategoryService {

    /**
     * 列表查询
     */
    public void list(PageDto pageDto);

    /**
     * 保存，id有值时更新，无值时新增
     */
    void save(CategoryDto categoryDto);

    /**
    * 删除
    */
    void delete(String id);

    List<CategoryDto> all();
}
