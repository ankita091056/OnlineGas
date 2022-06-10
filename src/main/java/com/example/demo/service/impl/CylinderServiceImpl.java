package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.AppError;
import com.example.demo.Cylinder;
import com.example.demo.Response;
import com.example.demo.dao.CylinderDAO;
import com.example.demo.entity.CylinderEntity;
import com.example.demo.service.ICyclinderService;
import com.example.demo.transformer.CylinderTransformer;


@Service
public class CylinderServiceImpl implements ICyclinderService {

@Autowired
private CylinderDAO cylinderDAO;


@Override
public Response<Cylinder> addCylinders(Cylinder cylinder) {
	Response<Cylinder> response = new Response<>();
	System.out.println(cylinder);
	//try {
		
		if (cylinderDAO.findById(cylinder.getCylinderId()).isPresent()) {
			System.out.println("If block execute");
			AppError error = new AppError();
			error.setCode("ERR_ADD_CYLINDER");
			error.setMessage("Cylinder already exists " + cylinder.getCylinderId());
			response.setError(error);
		} else {
			System.out.println("Else block execute");
			//cylinder.setCylinderId(0);
			CylinderEntity entity= CylinderTransformer.transformCylinder(cylinder);
			System.out.println(entity);
			cylinderDAO.save(entity);
			Cylinder newCate = CylinderTransformer.transformCylinderEntity(entity);
			response.setData(newCate);
		}
	//}
/*catch (Exception e) {
		AppError error = new AppError();
		error.setCode("ERR_ADD_CYLINDER");
		error.setMessage(e.getMessage());
		response.setError(error);
	}
	*/
	return response;
}


@Override
public Response<Cylinder> updateCylinder(Cylinder cylinder) {
	Response<Cylinder> response = new Response<>();
	try {
		CylinderEntity entity = CylinderTransformer.transformCylinder(cylinder);

		cylinderDAO.save(entity);

		Cylinder newCate = CylinderTransformer.transformCylinderEntity(entity);
		response.setData(newCate);
	} catch (Exception e) {
		AppError error = new AppError();
		error.setCode("ERR_UPDATING_CYLINDER");
		error.setMessage(e.getMessage());
		response.setError(error);
	}
	return response;
}

@Override
public Response<Boolean> deleteCylinder(Integer cylinderId) {
	Response<Boolean> response = new Response<>();
	try {
		cylinderDAO.deleteById(cylinderId);
		response.setData(true);
	} catch (Exception e) {
		AppError error = new AppError();
		error.setCode("ERR_GETTING_CYLINDER");
		error.setMessage(e.getMessage());
		response.setError(error);
	}
	return response;	
}


@Override
public Response<Cylinder> getCylinderId(Integer cylinderId) {
	Response<Cylinder> response = new Response<>();
	try {
		Optional<CylinderEntity> opEntity=cylinderDAO.findById(cylinderId);
				if (opEntity.isPresent()) {
			response.setData(CylinderTransformer.transformCylinderEntity(opEntity.get()));
		}
	} catch (Exception e) {
		AppError error = new AppError();
		error.setCode("ERR_GETTING_CYLINDER");
		error.setMessage(e.getMessage());
		response.setError(error);
	}
	return response;
}
}

