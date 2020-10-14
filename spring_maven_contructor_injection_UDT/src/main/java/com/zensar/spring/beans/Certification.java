package com.zensar.spring.beans;

public class Certification {
	private int certificationId;
	private String certificationName;
	public int getCertificationId() {
		return certificationId;
	}
	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}
	public String getCertificationName() {
		return certificationName;
	}
	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}
	@Override
	public String toString() {
		return "Certification [certificationId=" + certificationId + ", certificationName=" + certificationName + "]";
	}

}
