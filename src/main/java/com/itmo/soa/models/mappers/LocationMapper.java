package com.itmo.soa.models.mappers;

import com.itmo.soa.models.DAO.LocationDAO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LocationMapper {
    @Insert("insert into location(x, y, z, name) values (#{x}, #{y}, #{z}, #{name})")
    int insertLocation(LocationDAO location);

    @Select("select * from location where id = #{id}")
    LocationDAO findLocationDAOById(int id);

    @Select("select * from location")
    LocationDAO[] findAllLocationDAO();

    @Update("update location set x = #{x}, y = #{y}, z = #{z}, name = #{name} where id = #{id}")
    int updateLocation(LocationDAO location);

    @Delete("delete from location where id = #{id}")
    int deleteLocation(int id);
}
