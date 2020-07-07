package com.course.file.controller.admin;

import com.course.server.dto.FileDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.FileService;
import com.course.server.utils.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger LOG = LoggerFactory.getLogger(FileController.class);

    @Resource
    private FileService fileService;

     /**
     * 列表查询
     */
     @PostMapping("/list")
     public ResponseDto list(@RequestBody PageDto pageDto) {
         ResponseDto responseDto = new ResponseDto();
         fileService.list(pageDto);
         responseDto.setContent(pageDto);
         return responseDto;
     }
}
