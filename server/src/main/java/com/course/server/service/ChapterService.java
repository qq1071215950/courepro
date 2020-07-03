package com.course.server.service;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.ChapterPageDto;



/**
 * @author jiange
 * @date 2020/6/29 16:45
 */
public interface ChapterService {

    /**
     * 分页查询
     * @param chapterPageDto 分页对象
     * @return
     */
    void list(ChapterPageDto chapterPageDto);

    /**
     * 新增
     * @param chapterDto
     */
    void save(ChapterDto chapterDto);

    /**
     * 根据id删除
     * @param id
     */
    void delete(String id);
}
