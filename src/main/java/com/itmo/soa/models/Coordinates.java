package com.itmo.soa.models;

import lombok.*;

/**
 * @program: SOA-Lab2
 * @author: Siyuan
 * @create: 2022-10-08 17:54
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinates {
    private float x;
    private Integer y; //Поле не может быть null
}
