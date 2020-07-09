package com.course.server.service;

import com.course.server.dto.FileDto;
import com.course.server.dto.PageDto;

public interface FileService {

    /**
     * 列表查询
     */
    void list(PageDto pageDto);

    /**
     * 保存，id有值时更新，无值时新增
     */
    void save(FileDto fileDto);

    /**
    * 删除
    */
    void delete(String id);

    FileDto findByKey(String key);
}
