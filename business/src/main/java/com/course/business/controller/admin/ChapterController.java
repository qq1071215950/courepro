package com.course.business.controller.admin;


import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.service.ChapterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 大章接口服务
 * @author jiange
 * @date 2020/6/29 16:43
 */
@RestController
@RequestMapping("/chapter")
public class ChapterController {

    private static final Logger log = LoggerFactory.getLogger(ChapterController.class);
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/list")
    public PageDto list(@RequestBody PageDto pageDto) {
        log.info("pageDto: {}", pageDto);
        chapterService.list(pageDto);
        return pageDto;
    }
}
