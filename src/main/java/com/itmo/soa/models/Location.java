package com.itmo.soa.models;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

/**
 * @program: SOA-Lab2
 * @author: Siyuan
 * @create: 2022-10-08 17:54
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "location")
@XmlAccessorType(FIELD)
public class Location {
    private int x;
    private float y;
    private Long z; //Поле не может быть null
    private String name; //Поле не может быть null
}
