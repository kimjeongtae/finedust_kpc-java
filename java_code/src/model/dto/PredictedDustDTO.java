package model.dto;

public class PredictedDustDTO {
	private String refTime;
	private String location;
	private Integer miseAfter1;
	private Integer miseAfter2;
	private Integer miseAfter3;
	private Integer chomiseAfter1;
	private Integer chomiseAfter2;
	private Integer chomiseAfter3;
	
	public PredictedDustDTO(String refTime, String location) {
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

	public Integer getMiseAfter1() {
		return miseAfter1;
	}

	public void setMiseAfter1(Integer miseAfter1) {
		this.miseAfter1 = miseAfter1;
	}

	public Integer getMiseAfter2() {
		return miseAfter2;
	}

	public void setMiseAfter2(Integer miseAfter2) {
		this.miseAfter2 = miseAfter2;
	}

	public Integer getMiseAfter3() {
		return miseAfter3;
	}

	public void setMiseAfter3(Integer miseAfter3) {
		this.miseAfter3 = miseAfter3;
	}

	public Integer getChomiseAfter1() {
		return chomiseAfter1;
	}

	public void setChomiseAfter1(Integer chomiseAfter1) {
		this.chomiseAfter1 = chomiseAfter1;
	}

	public Integer getChomiseAfter2() {
		return chomiseAfter2;
	}

	public void setChomiseAfter2(Integer chomiseAfter2) {
		this.chomiseAfter2 = chomiseAfter2;
	}

	public Integer getChomiseAfter3() {
		return chomiseAfter3;
	}

	public void setChomiseAfter3(Integer chomiseAfter3) {
		this.chomiseAfter3 = chomiseAfter3;
	}
}
