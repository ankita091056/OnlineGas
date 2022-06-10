package com.example.demo.entity;
	import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

	@Entity
	@Table(name = "cylinder2")
	@Data
	@ToString
	public class CylinderEntity {


		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name="cylinderId")
		    private int cylinderId;

		    @Column(name="type")
		    private String type;

		    @Column(name= "weigth")
		    private float weigth;

		    @Column(name="strapecolour")
		    private String strapecolour;
  
		    @Column(name="price")
		    private float price;
	}
