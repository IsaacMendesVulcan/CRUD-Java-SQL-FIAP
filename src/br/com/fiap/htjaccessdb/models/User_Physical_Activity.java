package br.com.fiap.htjaccessdb.models;

import java.sql.Date;

public class User_Physical_Activity {
	
	
	
	private int totalTimeMin;
	private	float totalKcals; 
	private	String activity;
	private	Date createdAt;
	
	
	public int getTotalTimeMin() {
		return totalTimeMin;
	}
	public void setTotalTimeMin(int totalTimeMin) {
		this.totalTimeMin = totalTimeMin;
	}
	public float getTotalKcals() {
		return totalKcals;
	}
	public void setTotalKcals(float totalKcals) {
		this.totalKcals = totalKcals;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "User_Physical_Activity [totalTimeMin=" + totalTimeMin + ", totalKcals=" + totalKcals + ", activity="
				+ activity + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	
}
