package com.course.server.service;

import com.course.server.dto.SectionDto;
import com.course.server.dto.SectionPageDto;

public interface SectionService {

    /**
     * 列表查询
     */
    public void list(SectionPageDto sectionPageDto);

    /**
     * 保存，id有值时更新，无值时新增
     */
    void save(SectionDto sectionDto);

    /**
    * 删除
    */
    void delete(String id);
}
