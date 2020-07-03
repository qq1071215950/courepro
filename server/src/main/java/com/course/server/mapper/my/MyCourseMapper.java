package com.course.server.mapper.my;

import com.course.server.dto.CourseDto;
import com.course.server.dto.CoursePageDto;
import com.course.server.dto.SortDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 更新课程时长
 * @author jiange
 * @date 2020/7/3 16:57
 */
public interface MyCourseMapper {

    List<CourseDto> list(@Param("pageDto") CoursePageDto pageDto);

    /**
     * 更新课程时长
     * @param courseId
     * @return
     */
    int updateTime(@Param("courseId") String courseId);

    int updateSort(SortDto sortDto);

    int moveSortsBackward(SortDto sortDto);

    int moveSortsForward(SortDto sortDto);
}
