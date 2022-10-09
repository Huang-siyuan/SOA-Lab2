package com.itmo.soa.models.mappers;

import com.itmo.soa.models.DAO.CoordinatesDAO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CoordinatesMapper {

    @Insert("insert into coordinates(x, y) values (#{x}, #{y})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertCoordinates(CoordinatesDAO coordinates);

    @Select("select * from coordinates where id = #{id}")
    CoordinatesDAO findCoordinatesDAOById(int id);

    @Select("select * from coordinates where x = #{x} and y = #{y}")
    CoordinatesDAO findCoordinatesDAOByXAndY(float x, Integer y);

    @Select("select * from coordinates")
    CoordinatesDAO[] findAllCoordinatesDAO();

    @Update("update coordinates set x = #{x}, y = #{y} where id = #{id}")
    int updateCoordinates(CoordinatesDAO coordinates);

    @Delete("delete from coordinates where id = #{id}")
    int deleteCoordinates(int id);
}
