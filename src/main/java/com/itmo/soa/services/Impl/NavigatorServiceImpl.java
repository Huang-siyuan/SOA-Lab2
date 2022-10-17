package com.itmo.soa.services.Impl;

import com.itmo.soa.models.Coordinates;
import com.itmo.soa.models.DAO.CoordinatesDAO;
import com.itmo.soa.models.DAO.LocationDAO;
import com.itmo.soa.models.DAO.RouteDAO;
import com.itmo.soa.models.Location;
import com.itmo.soa.models.Route;
import com.itmo.soa.models.mappers.CoordinatesMapper;
import com.itmo.soa.models.mappers.LocationMapper;
import com.itmo.soa.models.mappers.RouteMapper;
import com.itmo.soa.services.exceptions.InternalServerException;
import com.itmo.soa.services.exceptions.NoSuchObjException;
import com.itmo.soa.services.exceptions.ValidationException;
import com.itmo.soa.services.NavigatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @program: SOA-Lab2
 * @author: Siyuan
 * @create: 2022-10-08 21:59
 **/

@Service
@AllArgsConstructor
public class NavigatorServiceImpl implements NavigatorService {
    private final RouteMapper routeMapper;
    private final LocationMapper locationMapper;
    private final CoordinatesMapper coordinatesMapper;
    private final RestTemplate restTemplate; // We will use this to call first service.

    @Override
    public RouteDAO findShortestRoute(int fromId, int toId) {
        if(fromId <= 0 || toId <= 0) throw new ValidationException("Id must be greater than 0");
        RouteDAO routeDAO= routeMapper.findShortestRoute(fromId, toId); // We will use RestTemplate to call first service when we finish the first service.
        if (routeDAO == null) throw new NoSuchObjException("Not Found.");
        return routeDAO;
    }

    @Override
    public RouteDAO findLongestRoute(int fromId, int toId) {
        if (fromId <= 0 || toId <= 0) throw new ValidationException("Id must be greater than 0");
        RouteDAO routeDAO = routeMapper.findLongestRoute(fromId, toId);
        if (routeDAO == null) throw new NoSuchObjException("There is no route between them!");
        return routeDAO;
    }

    @Override
    public RouteDAO addRouteBetweenLocations(int fromId, int toId, Integer distance) {
        String defaultRouteName = UUID.randomUUID().toString().replace("-", "").toLowerCase(); // Cause the name shouldn't be null. But we don't need to know the name.

        LocationDAO locationFrom = locationMapper.findLocationDAOById(fromId);
        LocationDAO locationTo = locationMapper.findLocationDAOById(toId);
        if (locationFrom == null || locationTo == null)
            throw new NoSuchObjException("There is no location with such id!");

        RouteDAO routeDAO = new RouteDAO(defaultRouteName, 1, fromId, toId, distance); // We don't need to know the coordinates' id. So we set it to 0 as the default.
        int effectLines = routeMapper.insertRoute(routeDAO);
        if(effectLines == 0) throw new InternalServerException("Insert route failed."); // TODO: 2022-10-11 Need to create some exceptions classes.
        return routeDAO;
    }

    @Override
    public Route toRoute(RouteDAO routeDAO) {
        Route route = new Route(routeDAO.getId(),
                routeDAO.getName(),
                null,
                routeDAO.getCreationDate(),
                null,
                null,
                routeDAO.getDistance());

        Location fromLocation = toLocation(locationMapper.findLocationDAOById(routeDAO.getFrom_id()));
        Location toLocation = toLocation(locationMapper.findLocationDAOById(routeDAO.getTo_id()));
        Coordinates coordinates = toCoordinates(coordinatesMapper.findCoordinatesDAOById(routeDAO.getCoordinates_id()));

        route.setFrom(fromLocation);
        route.setTo(toLocation);
        route.setCoordinates(coordinates);

        return route;
    }

    @Override
    public Location toLocation(LocationDAO locationDAO) {
        return new Location(locationDAO.getX(), locationDAO.getY(), locationDAO.getZ(), locationDAO.getName());
    }

    @Override
    public Coordinates toCoordinates(CoordinatesDAO coordinatesDAO) {
        return new Coordinates(coordinatesDAO.getX(), coordinatesDAO.getY());
    }

    @Override
    public RouteDAO getRouteById(int id) {
        RouteDAO routeDAO = routeMapper.findRouteById(id);
        if (routeDAO == null) throw new NoSuchObjException("There is no route with such id!");
        return routeDAO;
    }
}
