package ${controllerPackageUrl};

<#if Domain??>
import ${servicePackageUrl}.${Domain}Service;
import ${dtoPackageUrl}.${Domain}Dto;
</#if>
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;

import com.course.server.utils.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
<#if domain??>
@RequestMapping("/${domain}")
public class ${Domain}Controller {

    private static final Logger LOG = LoggerFactory.getLogger(${Domain}Controller.class);

    @Resource
    private ${Domain}Service ${domain}Service;

     /**
     * 列表查询
     */
     @PostMapping("/list")
     public ResponseDto list(@RequestBody PageDto pageDto) {
         ResponseDto responseDto = new ResponseDto();
         ${domain}Service.list(pageDto);
         responseDto.setContent(pageDto);
         return responseDto;
     }

    /**
    * 保存，id有值时更新，无值时新增
    */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ${Domain}Dto ${domain}Dto) {
    <#if columns??>
        <#list columns as col>
            <#if col.entityColumnNo !='id' && col.entityColumnNo !='createdAt' && col.entityColumnNo !='updatedAt' && col.entityColumnNo !='sort'>
                <#if col.nullAble == 'NO'>
        ValidatorUtil.require(${domain}Dto.get${col.nameBigHump}(), "${col.nameCn}");
                </#if>
                <#if (col.length > 0)>
        ValidatorUtil.length(${domain}Dto.get${col.nameBigHump}(), "${col.nameCn}", 1, ${col.length?c});
                </#if>
            </#if>
        </#list>
    </#if>
        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.save(${domain}Dto);
        responseDto.setContent(${domain}Dto);
        return responseDto;
    }

    /**
    * 删除
    */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.delete(id);
        return responseDto;
    }
}
</#if>
