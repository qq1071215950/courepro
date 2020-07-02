package ${servicePackageUrl};

<#if Domain??>
import com.course.server.dto.${Domain}Dto;
</#if>
import com.course.server.dto.PageDto;

<#if Domain??>
public interface ${Domain}Service {

    /**
     * 列表查询
     */
    public void list(PageDto pageDto);

    /**
     * 保存，id有值时更新，无值时新增
     */
    void save(${Domain}Dto ${domain}Dto);

    /**
    * 删除
    */
    void delete(String id);
}
</#if>
