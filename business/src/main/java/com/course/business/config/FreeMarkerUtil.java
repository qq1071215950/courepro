package com.course.business.config;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 1. 用来判断包路径是否存在，若不存在，即创建文件夹；
 * 2. 将配好的模板文件写出到指定路径下的文件
 * 3. 一些名字的处理
 * 4. 从数据库获取表信息
 * @author jiange
 * @date 2020/7/1 17:18
 */
@Component
public class FreeMarkerUtil {
    @Autowired
    Configuration freeMarker;

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 判断包路径是否存在
     */
    private void pathJudgeExist(String path){
        File file = new File(path);
        if(!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 输出到文件
     */
    public  void printFile(Map<String, Object> root, Template template, String filePath, String fileName) throws Exception  {
        pathJudgeExist(filePath);
        File file = new File(filePath, fileName );
        if(!file.exists()) {
            file.createNewFile();
        }
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        template.process(root,  out);
        out.close();
    }

    /**
     * 首字母大写
     */
    public  String capFirst(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1).toLowerCase();
    }

    /**
     * 下划线命名转为驼峰命名
     */
    public String underlineToHump(String para){
        StringBuilder result=new StringBuilder();
        String a[]=para.split("_");
        for(String s:a){
            if(result.length()==0){
                result.append(s);
            }else{
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /**
     * 获取类名
     */
    public String getEntityName(String tableName){
        return underlineToHump(capFirst(tableName.toLowerCase()));
    }

    /**
     * 获取首字母小写类名
     */
    public String getEntityNameLower(String tableName){
        return underlineToHump(tableName.toLowerCase());
    }

    /**
     * 将[数据库类型]转换成[Java类型],如果遇到没有写的类型,会出现Undefine,在后面补充即可
     */
    public  String convertToJava(String columnType){
        String result;
        switch (columnType){
            case "VARCHAR":{
                result = "String";
                break;
            }
            case "CHAR":{
                result = "String";
                break;
            }
            case "INT":{
                result = "Integer";
                break;
            }
            case "BIGINT":{
                result = "Long";
                break;
            }
            case "FLOAT":{
                result = "Float";
                break;
            }
            case "DOUBLE":{
                result = "Double";
                break;
            }
            case "DATETIME":{
                result = "Date";
                break;
            }
            case "BIT":{
                result = "Boolean";
                break;
            }
            case "DECIMAL":{
                result = "BigDecimal";
                break;
            }
            default:{
                result = "Undefine";
                break;
            }
        }
        return result;
    }

    /**
     * 获取表信息
     */
    public  List<Map<String, Object>> getDataInfo(String tableName){
        // mysql查询表结构的语句,如果是其他数据库,修改此处查询语句
        String sql = "show columns from "+tableName;
        List<Map<String, Object>> sqlToMap = jdbcTemplate.queryForList(sql);
        System.out.println(sqlToMap.toString());
        List<Map<String, Object>> columns = new LinkedList<>();
        for (Map map : sqlToMap) {
            Map<String, Object> columnMap = new HashMap<>(16);
            // 字段名称
            String columnName = map.get("Field").toString();
            // 字段名称
            columnMap.put("columnName", columnName);
            columnMap.put("name",columnName);
            // 字段类型
            String columnType = map.get("Type").toString().toUpperCase();
            if (columnType.toUpperCase().contains("varchar".toUpperCase())) {
                String lengthStr = columnType.substring(columnType.indexOf("(") + 1, columnType.length() - 1);
                columnMap.put("length",Integer.valueOf(lengthStr));
            } else {
                columnMap.put("length",0);
            }

            columnMap.put("nameCn",underlineToHump(columnName));
            if (columnType.contains("(")){
                columnType=columnType.substring(0,columnType.lastIndexOf("(")).trim();
            }
            columnType = convertToJava(columnType);
            columnMap.put("columnType", columnType);
            // 成员名称
            columnMap.put("entityColumnNo", underlineToHump(columnName));
            columnMap.put("nullAble",map.get("Null").toString());
            // 驼峰名称
            columnMap.put("nameHump",lineToHump(columnName));
            columnMap.put("nameBigHump",lineToBigHump(columnName));

            columns.add(columnMap);
        }
        return columns;
    }
    /**
     * 下划线转小驼峰
     */
    public static String lineToHump(String str){
        Pattern linePattern = Pattern.compile("_(\\w)");
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 下划线转大驼峰
     */
    public static String lineToBigHump(String str){
        String s = lineToHump(str);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    /**
     * 生成代码
     */
    public void generate(Map<String, Object> root,String templateName,String saveUrlCont,String entityName) throws Exception {
        Template templateCont = freeMarker.getTemplate(templateName);

        printFile(root, templateCont, saveUrlCont, entityName);
    }
}
