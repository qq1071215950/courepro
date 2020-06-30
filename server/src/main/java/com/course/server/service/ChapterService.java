package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;

import java.util.List;

/**
 * @author jiange
 * @date 2020/6/29 16:45
 */
public interface ChapterService {

    /**
     * 分页查询
     * @param pageDto 分页对象
     * @return
     */
    void list(PageDto pageDto);

    /**
     * 新增
     * @param chapterDto
     */
    void save(ChapterDto chapterDto);
}
