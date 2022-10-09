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
public class Location {
    private int x;
    private float y;
    private Long z; //Поле не может быть null
    private String name; //Поле не может быть null
}
