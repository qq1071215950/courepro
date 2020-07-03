package com.course.business.controller;

import com.course.generator.util.DbUtil;
import com.course.generator.util.Field;
import com.course.business.config.FreeMarkerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author jiange
 * @date 2020/7/1 17:25
 */
@RestController
@RequestMapping("/fm")
public class FreeMarkerController {

    @Autowired
    private FreeMarkerUtil freeMarkerUtil;

    /**
     * 模块名
     */
    private static String MODULE = "business";

    /**
     * dto的存放路径
     */
    private static String toDtoPath = "server\\src\\main\\java\\com\\course\\server\\dto\\";

    private static String toDtoPackagePath = "com.course.server.dto";

    /**
     * service接口的存放路径
     */
    private static String toServicePath = "server\\src\\main\\java\\com\\course\\server\\service\\";
    /**
     * service接口包路径
     */
    private static String toServicePackagePath = "com.course.server.service";

    /**
     * serviceImpl接口实现的存放路径
     */
    private static String toServiceImplPath = "server\\src\\main\\java\\com\\course\\server\\service\\impl\\";
    /**
     * service接口实现包路径
     */
    private static String toServiceImplPackagePath = "com.course.server.service.impl";

    /**
     * controller的存放路径
     */
    private static String toControllerPath = MODULE + "\\src\\main\\java\\com\\course\\" + MODULE + "\\controller\\admin\\";
    private static String toControllerPackagePath =   "com.course." + MODULE + ".controller.admin";

    private static String tableName = "course";

    private static String saveUrl = "D:\\IDEAWorkSpace\\courepro\\";

    @RequestMapping("/ge")
    public String createEntity( ) throws Exception {
        //生成路径，根据实际情况修改即可
        //生成文件包名，根据实际情况修改即可
        //domain类名 主要是配置文件
        String module = MODULE;
        String entityName = freeMarkerUtil.getEntityName(tableName);
        String domain = entityName.substring(0, 1).toLowerCase() + entityName.substring(1);

        // 包路径
        //封装参数
        Map<String, Object> root = new HashMap<>();
        root.put("dtoPackageUrl", toDtoPackagePath);
        root.put("servicePackageUrl", toServicePackagePath);
        root.put("serviceImplPackageUrl", toServiceImplPackagePath);
        root.put("controllerPackageUrl", toControllerPackagePath);
        //表参数
        root.put("tableName", tableName);
        root.put("entityName", entityName+"Dto");
        root.put("Domain", entityName);
        root.put("domain", domain);
        root.put("entityNameLower", freeMarkerUtil.getEntityNameLower(tableName));
        List<Map<String, Object>> mapList = freeMarkerUtil.getDataInfo(tableName);
        root.put("columns", mapList);
        root.put("typeSet", getJavaTypes(mapList));
        // 生成dto
        freeMarkerUtil.generate(root, "dto.ftl", saveUrl+toDtoPath, entityName + "Dto.java");
        // 生成service
        freeMarkerUtil.generate(root, "service.ftl", saveUrl+toServicePath, entityName + "Service.java");
        // 生成serviceImpl
        freeMarkerUtil.generate(root, "serviceImpl.ftl", saveUrl+toServiceImplPath, entityName + "ServiceImpl.java");
        // 生成controller
        freeMarkerUtil.generate(root, "controller.ftl", saveUrl+toControllerPath, entityName + "Controller.java");
        return "生成成功";
    }

    /**
     * 获取所有的Java类型，使用Set去重
     */
    private Set<String> getJavaTypes(List<Map<String, Object>> fieldList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < fieldList.size(); i++) {
            String field = String.valueOf(fieldList.get(i).get("columnType"));
            set.add(field);
        }
        return set;
    }
}

