package com.itmo.soa.models.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
