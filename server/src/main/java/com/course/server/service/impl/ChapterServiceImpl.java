package com.course.server.service.impl;

import com.course.server.domain.Chapter;
import com.course.server.domain.ChapterExample;
import com.course.server.mapper.ChapterMapper;
import com.course.server.service.ChapterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiange
 * @date 2020/6/29 16:45
 */
@Service
public class ChapterServiceImpl implements ChapterService {

    @Resource
    private ChapterMapper chapterMapper;
    @Override
    public List<Chapter> list() {
        ChapterExample example = new ChapterExample();
        return chapterMapper.selectByExample(example);
    }
}
