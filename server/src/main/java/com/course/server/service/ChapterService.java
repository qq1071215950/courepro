package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.dto.ChapterDto;

import java.util.List;

/**
 * @author jiange
 * @date 2020/6/29 16:45
 */
public interface ChapterService {
    List<ChapterDto> list();
}
