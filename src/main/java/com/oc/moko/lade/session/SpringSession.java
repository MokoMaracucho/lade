package com.oc.moko.lade.session;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="spring_session")
public class SpringSession {
	
	@Id
	@NotEmpty
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="primary_id", updatable=false)
	private Long primaryId;
	
	@NotEmpty
	@Column(name="session_id")
	private String session_id;

	@NotEmpty
	@Column(name="creation_time")
	private BigInteger creationTime;

	@NotEmpty
	@Column(name="last_access_time")
	private BigInteger lastAccesTime;

	@NotEmpty
	@Column(name="max_inactive_interval")
	private int maxInactiveInterval;

	@NotEmpty
	@Column(name="principal_name")
	private String principalName;
}
