package com.example.rideshare.service;

import com.example.rideshare.dto.CreateRideRequest;
import com.example.rideshare.model.Ride;

import java.util.List;

public interface RideService {
    Ride createRide(String username, CreateRideRequest request);

    List<Ride> getUserRides(String username);

    List<Ride> getPendingRides();

    Ride acceptRide(String username, String rideId);

    Ride completeRide(String username, String rideId);
}
