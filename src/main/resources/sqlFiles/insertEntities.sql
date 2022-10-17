insert into coordinates (x, y)
values (1, 2);
insert into coordinates (x, y)
values (2,3);

insert into location (x, y, z, name)
values (1, 2, 3, 'Test!');

insert into location (x, y, z, name)
values (1, 2, 3, 'Test2!');

insert into route (name, creation_date, distance, coordinates_id, from_id, to_id) VALUES ('test_route', '2018-01-01', 100, 1, 1, 2);