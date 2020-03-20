package com.metacube.training.model.commands;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="veichle")
public class VehicleCommand {

	@Id
	@Column(name="rid")
	private long Eid;

	@Column(name="vnum")
	@NotNull
	private int vehicleNumber;

	@Column(name="vname")
	@NotBlank
	// @Pattern(regexp="/^[a-zA-Z]+ [a-zA-Z]+$/",message="invalid vehicle name")
	private String vehicleName;

	@Column(name="identify")
	@NotBlank
	// @Pattern(regexp="/^[a-zA-Z]+ [a-zA-Z]+$/",message="Bad Identification")
	private String identification;

	@NotBlank
	private String type;

	public long getEid() {
		return Eid;
	}

	public void setEid(long Eid) {
		this.Eid = Eid;
	}

	public int getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
