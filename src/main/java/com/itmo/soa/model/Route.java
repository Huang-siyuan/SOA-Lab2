package com.itmo.soa.model;

/**
 * @program: SOA-Lab2
 * @author: Siyuan
 * @create: 2022-10-08 17:53
 **/
public class Route {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле может быть null
    private Integer distance; //Поле может быть null, Значение поля должно быть больше 1
}
