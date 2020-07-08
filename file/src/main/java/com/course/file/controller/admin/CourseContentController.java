package com.course.file.controller.admin;

import com.course.server.dto.CourseContentDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.CourseContentService;
import com.course.server.utils.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseContentController.class);

    @Resource
    private CourseContentService courseContentService;

     /**
     * 列表查询
     */
     @PostMapping("/list")
     public ResponseDto list(@RequestBody PageDto pageDto) {
         ResponseDto responseDto = new ResponseDto();
         courseContentService.list(pageDto);
         responseDto.setContent(pageDto);
         return responseDto;
     }

    /**
    * 保存，id有值时更新，无值时新增
    */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody CourseContentDto courseContentDto) {
        ValidatorUtil.require(courseContentDto.getContent(), "content");
        ResponseDto responseDto = new ResponseDto();
        courseContentService.save(courseContentDto);
        responseDto.setContent(courseContentDto);
        return responseDto;
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        courseContentService.delete(id);
        return responseDto;
    }
}
