package com.example.demo.transformer;

import com.example.demo.Cylinder;
import com.example.demo.entity.CylinderEntity;

public class CylinderTransformer {
	public static CylinderEntity transformCylinder(Cylinder cylinder) {
		if(cylinder != null) {
			CylinderEntity entity = new CylinderEntity();
			entity.setCylinderId(cylinder.getCylinderId());
			entity.setType(cylinder.getType());
			entity.setStrapecolour(cylinder.getStrapecolour());
			entity.setWeigth(cylinder.getWeigth());
			entity.setPrice(cylinder.getPrice());
			
			return entity;
		}
		return null;
	}
	
	
	public static Cylinder transformCylinderEntity(CylinderEntity entity) {
		if(entity != null) {
			Cylinder cylinder = new Cylinder();
			cylinder.setCylinderId(entity.getCylinderId());
			cylinder.setType(entity.getType());
			cylinder.setStrapecolour(entity.getStrapecolour());
			cylinder.setWeigth(entity.getWeigth());
			cylinder.setPrice(entity.getPrice());
			
			return cylinder;
		}
		return null;
	}
}
