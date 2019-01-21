package com.lee;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user_tb where id=#{id}")
    public Map<String,String> getById(Integer id);
}
