package com.hagan.models;

public class Process {

	String username;
	int formId;
	String supervisorApprove;
	String headApprove;
	String supReason;
	String headReason;

	public Process() {
		super();
	}

	@Override
	public String toString() {
		return "Process [username=" + username + ", formId=" + formId + ", supervisorApprove=" + supervisorApprove
				+ ", headApprove=" + headApprove + ", supReason=" + supReason + ", headReason=" + headReason + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public String getSupervisorApprove() {
		return supervisorApprove;
	}

	public void setSupervisorApprove(String supervisorApprove) {
		this.supervisorApprove = supervisorApprove;
	}

	public String getHeadApprove() {
		return headApprove;
	}

	public void setHeadApprove(String headApprove) {
		this.headApprove = headApprove;
	}

	public String getSupReason() {
		return supReason;
	}

	public void setSupReason(String supReason) {
		this.supReason = supReason;
	}

	public String getHeadReason() {
		return headReason;
	}

	public void setHeadReason(String headReason) {
		this.headReason = headReason;
	}

	public Process(String username, int formId, String supervisorApprove, String headApprove, String supReason,
			String headReason) {
		super();
		this.username = username;
		this.formId = formId;
		this.supervisorApprove = supervisorApprove;
		this.headApprove = headApprove;
		this.supReason = supReason;
		this.headReason = headReason;

	}
}
