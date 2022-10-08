create table coordinates
(
    id serial
        constraint coordinates_pk
            primary key,
    x  float not null,
    y  INTEGER not null
);

create table location
(
    id   serial
        constraint location_pk
            primary key,
    x    int      not null,
    y    float    not null,
    z    int8     not null,
    name char(64) not null
);

create table route
(
    id             serial8
        constraint route_pk
            primary key,
    name           varchar(64) not null,
    creation_date  timestamp  not null,
    distance       int,
    coordinates_id int         not null
        constraint coordinates_id
            references coordinates,
    from_id        int
        constraint from_id
            references location,
    to_id          int
        constraint to_id
            references location
);


