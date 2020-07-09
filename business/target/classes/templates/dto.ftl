package ${dtoPackageUrl};

import lombok.Data;

import java.io.Serializable;
<#if typeSet?? && typeSet?size gt 0>
    <#list typeSet as type>
        <#if type=='BigDecimal'>
import java.math.BigDecimal;
        </#if>
        <#if type=='Date'>
import java.util.Date;
        </#if>
    </#list>
</#if>

@Data
public class ${entityName} implements Serializable {

    private static final long serialVersionUID = 1L;

    <#if columns??>
        <#--循环生成变量-->
    <#list columns as col>
    /**
     * ${col["columnName"]}
     */
    private ${col["columnType"]} ${col["entityColumnNo"]};
    </#list>
</#if>
}
