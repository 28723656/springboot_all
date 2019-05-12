package com.java.springboot.mapper;

import com.java.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author 风往西边吹丶
 * @create 2019-05-12 12:05
 */

//指定这是一个操作数据库的mapper
// 因为有mapper扫描，这里就可以不用写mapper了
//@Mapper

public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName}) ")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);

}
