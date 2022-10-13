package com.itmo.soa.models.mappers;

import com.itmo.soa.models.DAO.RouteDAO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RouteMapper {
    @Insert("INSERT INTO route (name, creation_date, distance, coordinates_id, from_id, to_id) VALUES (#{name},#{creation_date}, #{distance},#{coordinates_id}, #{from_id}, #{to_id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertRoute(RouteDAO route);

    @Select("SELECT * FROM route WHERE id = #{id}")
    RouteDAO findRouteById(int id);

    @Select("SELECT * FROM route")
    RouteDAO[] findAllRoutes();

    @Update("UPDATE route SET name = #{name}, creation_date = #{creation_date}, distance = #{distance}, coordinates_id = #{coordinates_id}, from_id = #{from_id}, to_id = #{to_id} WHERE id = #{id}")
    int updateRouteById(RouteDAO route);

    @Delete("DELETE FROM route WHERE id = #{id}")
    int deleteRouteById(int id);

    @Select("select * from Route where distance = (select min(distance) from Route where from_id = #{fromId} and to_id = #{toId}) limit 1")
    RouteDAO findShortestRoute(int fromId, int toId);

    @Select("select * from Route where distance = (select max(distance) from Route where from_id = #{fromId} and to_id = #{toId}) limit 1")
    RouteDAO findLongestRoute(int fromId, int toId);
}
