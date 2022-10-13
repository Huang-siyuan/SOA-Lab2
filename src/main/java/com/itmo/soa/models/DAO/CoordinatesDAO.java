package com.itmo.soa.models.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: SOA-Lab2
 * @description: We use this class to store and take the data from the database
 * @author: Siyuan
 * @create: 2022-10-08 19:32
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoordinatesDAO {
    private int id;
    private float x;
    private Integer y;
}
