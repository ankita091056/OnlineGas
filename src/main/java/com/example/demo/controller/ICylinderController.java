package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Cylinder;
import com.example.demo.Response;
import com.example.demo.service.ICyclinderService;

@RestController
@RequestMapping("/cylinder2")
public class ICylinderController {
	
@Autowired
private ICyclinderService cyclinderService;

@PostMapping(value="/save",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public Response<Cylinder> addCylinders(@RequestBody Cylinder cylinder){
	return cyclinderService.addCylinders(cylinder);
}

@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public Response<Cylinder> updateCylinder(@RequestBody Cylinder cylinder){
	return cyclinderService.updateCylinder(cylinder);
}

@GetMapping(value="/{cylinderId}", produces = MediaType.APPLICATION_JSON_VALUE)
public Response<Cylinder> getCylinderId(@PathVariable("cylinderId") Integer cylinderId){
	return cyclinderService.getCylinderId(cylinderId);
}


@DeleteMapping(value="/{cylinderId}", produces = MediaType.APPLICATION_JSON_VALUE)
public Response<Boolean> deleteCylinder(@PathVariable("cylinderId") Integer cylinderId){
	return cyclinderService.deleteCylinder(cylinderId);
}

}


