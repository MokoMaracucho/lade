package com.oc.moko.lade.session;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.mysql.cj.jdbc.Blob;

@Entity
@Table(name="spring_session_attributes")
public class SpringSessionAttributes {
	
	@Id
	@NotEmpty
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="session_primary_id", updatable=false)
	private Long sessionPrimaryId;

	@NotEmpty
	@Column(name="attribute_name")
	private String attributeName;

	@NotEmpty
	@Column(name="attribute_bytes")
	private Blob attributeBytes; 
}
