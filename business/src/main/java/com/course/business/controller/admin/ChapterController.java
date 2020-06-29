package com.course.business.controller.admin;

import com.course.server.domain.Chapter;
import com.course.server.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/list")
    public List<Chapter> chapter() {
        return chapterService.list();
    }
}
