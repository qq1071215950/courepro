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

    /**
    * 保存，id有值时更新，无值时新增
    */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody FileDto fileDto) {
        ValidatorUtil.require(fileDto.getPath(), "path");
        ValidatorUtil.length(fileDto.getPath(), "path", 1, 100);
        ValidatorUtil.length(fileDto.getName(), "name", 1, 100);
        ValidatorUtil.length(fileDto.getSuffix(), "suffix", 1, 10);
        ValidatorUtil.length(fileDto.getKey(), "key", 1, 32);
        ResponseDto responseDto = new ResponseDto();
        fileService.save(fileDto);
        responseDto.setContent(fileDto);
        return responseDto;
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        fileService.delete(id);
        return responseDto;
    }
}
