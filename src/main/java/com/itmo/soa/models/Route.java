package com.itmo.soa.models;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

/**
 * @program: SOA-Lab2
 * @author: Siyuan
 * @create: 2022-10-08 17:53
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "route")
@XmlAccessorType(FIELD)
public class Route {
    private long id; // The value of the field must be greater than 0, The value of this field must be unique, The value of this field must be generated automatically
    private String name; // Field cannot be null, String cannot be empty
    private Coordinates coordinates; // Field cannot be null
    private java.time.LocalDateTime creationDate; // The field cannot be null, the value of this field must be generated automatically
    private Location from; // Field can be null
    private Location to; // Field can be null
    private Integer distance; // The field can be null, the field value must be greater than 1

    public Route(String name, Coordinates coordinates, Location from, Location to, Integer distance) {
        this.name = name;
        this.coordinates = coordinates;
        this.from = from;
        this.to = to;
        this.distance = distance;

        this.creationDate = java.time.LocalDateTime.now();
    }
}
