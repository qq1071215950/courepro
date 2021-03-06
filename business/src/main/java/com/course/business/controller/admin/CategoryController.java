package com.course.business.controller.admin;

import com.course.server.annotion.MethodLog;
import com.course.server.service.CategoryService;
import com.course.server.dto.CategoryDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;

import com.course.server.utils.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    @Resource
    private CategoryService categoryService;

     /**
     * 列表查询
     */
     @MethodLog
     @PostMapping("/list")
     public ResponseDto list(@RequestBody PageDto pageDto) {
         ResponseDto responseDto = new ResponseDto();
         categoryService.list(pageDto);
         responseDto.setContent(pageDto);
         return responseDto;
     }

    /**
    * 保存，id有值时更新，无值时新增
    */
    @MethodLog
    @PostMapping("/save")
    public ResponseDto save(@RequestBody CategoryDto categoryDto) {
        ValidatorUtil.require(categoryDto.getParent(), "parent");
        ValidatorUtil.require(categoryDto.getName(), "name");
        ValidatorUtil.length(categoryDto.getName(), "name", 1, 50);
        ResponseDto responseDto = new ResponseDto();
        categoryService.save(categoryDto);
        responseDto.setContent(categoryDto);
        return responseDto;
    }

    /**
    * 删除
    */
    @MethodLog
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        categoryService.delete(id);
        return responseDto;
    }


    /**
     * 列表查询
     */
    @MethodLog
    @PostMapping("/all")
    public ResponseDto all() {
        ResponseDto responseDto = new ResponseDto();
        List<CategoryDto> categoryDtoList = categoryService.all();
        responseDto.setContent(categoryDtoList);
        return responseDto;
    }
}
