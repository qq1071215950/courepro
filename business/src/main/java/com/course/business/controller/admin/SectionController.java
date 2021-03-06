package com.course.business.controller.admin;

import com.course.server.dto.SectionPageDto;
import com.course.server.service.SectionService;
import com.course.server.dto.SectionDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;

import com.course.server.utils.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/section")
public class SectionController {

    private static final Logger LOG = LoggerFactory.getLogger(SectionController.class);

    @Resource
    private SectionService sectionService;

     /**
      * 列表查询
      */
     @PostMapping("/list")
     public ResponseDto list(@RequestBody SectionPageDto sectionPageDto) {
         ResponseDto responseDto = new ResponseDto();
         ValidatorUtil.require(sectionPageDto.getCourseId(), "课程ID");
         ValidatorUtil.require(sectionPageDto.getChapterId(), "大章ID");
         sectionService.list(sectionPageDto);
         responseDto.setContent(sectionPageDto);
         return responseDto;
     }

    /**
    * 保存，id有值时更新，无值时新增
    */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody SectionDto sectionDto) {
        ValidatorUtil.require(sectionDto.getTitle(), "title");
        ValidatorUtil.length(sectionDto.getTitle(), "title", 1, 50);
        ValidatorUtil.length(sectionDto.getVideo(), "video", 1, 200);
        ResponseDto responseDto = new ResponseDto();
        sectionService.save(sectionDto);
        responseDto.setContent(sectionDto);
        return responseDto;
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        sectionService.delete(id);
        return responseDto;
    }
}
