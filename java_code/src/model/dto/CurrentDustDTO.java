package model.dto;

public class CurrentDustDTO {
	private String refTime;
	private String location;
	private Integer mise;
	private Integer chomise;
	
	public CurrentDustDTO(String refTime, String location) {
		super();
		this.refTime = refTime;
		this.location = location;
	}

	public String getRefTime() {
		return refTime;
	}

	public void setRefTime(String refTime) {
		this.refTime = refTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getMise() {
		return mise;
	}

	public void setMise(Integer mise) {
		this.mise = mise;
	}

	public Integer getChomise() {
		return chomise;
	}

	public void setChomise(Integer chomise) {
		this.chomise = chomise;
	}
}
