package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Cylinder;
import com.example.demo.Response;

@Service
public interface ICyclinderService {
public Response<Cylinder> addCylinders(Cylinder cylinder);
public Response<Cylinder> updateCylinder(Cylinder cylinder);
public Response<Boolean> deleteCylinder(Integer cylinderId);
public Response<Cylinder> getCylinderId(Integer cylinderId);
	
	
}

