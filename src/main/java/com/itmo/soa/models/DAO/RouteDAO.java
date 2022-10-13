package com.itmo.soa.models.DAO;

import com.itmo.soa.models.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @program: SOA-Lab2
 * @description: We use this class to store and take the data from the database
 * @author: Siyuan
 * @create: 2022-10-08 19:27
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDAO {
    private long id;
    private String name;
    private int coordinates_id;
    private java.time.LocalDateTime creationDate;
    private int from_id;
    private int to_id;
    private Integer distance;

    public RouteDAO(String name, int coordinates_id, int from_id, int to_id, Integer distance) {
        this.name = name;
        this.coordinates_id = coordinates_id;
        this.from_id = from_id;
        this.to_id = to_id;
        this.distance = distance;

        this.creationDate = java.time.LocalDateTime.now();
    }

    public LocalDateTime getcreation_date() {
        return creationDate;
    }
}
