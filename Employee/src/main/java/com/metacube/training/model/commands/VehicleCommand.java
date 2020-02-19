package com.metacube.training.model.commands;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class VehicleCommand {

	private int Eid;

	@NotNull
	private int vehicleNumber;

	@NotBlank
	// @Pattern(regexp="/^[a-zA-Z]+ [a-zA-Z]+$/",message="invalid vehicle name")
	private String vehicleName;

	@NotBlank
	// @Pattern(regexp="/^[a-zA-Z]+ [a-zA-Z]+$/",message="Bad Identification")
	private String identification;

	@NotBlank
	private String type;

	public int getEid() {
		return Eid;
	}

	public void setEid(int Eid) {
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
