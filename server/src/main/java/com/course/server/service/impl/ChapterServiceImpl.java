package com.course.server.service.impl;

import com.course.server.domain.Chapter;
import com.course.server.domain.ChapterExample;
import com.course.server.dto.ChapterDto;
import com.course.server.mapper.ChapterMapper;
import com.course.server.service.ChapterService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiange
 * @date 2020/6/29 16:45
 */
@Service
public class ChapterServiceImpl implements ChapterService {

    @Resource
    private ChapterMapper chapterMapper;
    @Override
    public List<ChapterDto> list() {
        ChapterExample example = new ChapterExample();
        List<Chapter> chapters = chapterMapper.selectByExample(example);
        List<ChapterDto> chapterDtos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(chapters)){
            chapterDtos = chapters.stream().map(x ->{
                ChapterDto chapterDto = new ChapterDto();
                BeanUtils.copyProperties(x, chapterDto);
                return chapterDto;
            }).collect(Collectors.toList());
        }
        return chapterDtos;
    }
}
