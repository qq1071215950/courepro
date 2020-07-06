package com.course.business.controller.admin;

import com.course.server.service.TeacherService;
import com.course.server.dto.TeacherDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;

import com.course.server.utils.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private static final Logger LOG = LoggerFactory.getLogger(TeacherController.class);

    @Resource
    private TeacherService teacherService;

     /**
     * 列表查询
     */
     @PostMapping("/list")
     public ResponseDto list(@RequestBody PageDto pageDto) {
         ResponseDto responseDto = new ResponseDto();
         teacherService.list(pageDto);
         responseDto.setContent(pageDto);
         return responseDto;
     }

    /**
    * 保存，id有值时更新，无值时新增
    */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody TeacherDto teacherDto) {
        ValidatorUtil.require(teacherDto.getName(), "name");
        ValidatorUtil.length(teacherDto.getName(), "name", 1, 50);
        ValidatorUtil.length(teacherDto.getNickname(), "nickname", 1, 50);
        ValidatorUtil.length(teacherDto.getImage(), "image", 1, 100);
        ValidatorUtil.length(teacherDto.getPosition(), "position", 1, 50);
        ValidatorUtil.length(teacherDto.getMotto(), "motto", 1, 50);
        ValidatorUtil.length(teacherDto.getIntro(), "intro", 1, 500);
        ResponseDto responseDto = new ResponseDto();
        teacherService.save(teacherDto);
        responseDto.setContent(teacherDto);
        return responseDto;
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        teacherService.delete(id);
        return responseDto;
    }
}
