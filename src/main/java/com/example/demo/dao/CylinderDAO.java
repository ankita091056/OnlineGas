package com.example.demo.dao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CylinderEntity;

	@Repository
	public interface CylinderDAO extends JpaRepository<CylinderEntity, Integer> {
	@Query(value="select * from cylinder2 c where c.type=?1",nativeQuery=true)
	List<CylinderEntity>findAllCylindersByType(String type);

	
		
     
	}


	