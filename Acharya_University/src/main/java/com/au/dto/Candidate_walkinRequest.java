package com.au.dto;

import com.au.model.ApplicantDetails;
import com.au.model.Candidate_Walkin;
import com.au.model.PGApplicable;
import com.au.model.StudentAttachments;

public class Candidate_walkinRequest {
	private Candidate_Walkin cd;
	private StudentAttachments stu_attach;
	private PGApplicable pgapp;
	private ApplicantDetails ad;

	
	public Candidate_Walkin getCd() {
		return cd;
	}

	public void setCd(Candidate_Walkin cd) {
		this.cd = cd;
	}

	
	public StudentAttachments getStu_attach() {
		return stu_attach;
	}

	public void setStu_attach(StudentAttachments stu_attach) {
		this.stu_attach = stu_attach;
	}

	public PGApplicable getPgapp() {
		return pgapp;
	}

	public void setPgapp(PGApplicable pgapp) {
		this.pgapp = pgapp;
	}

	public ApplicantDetails getAd() {	
//		System.out.println(cd.getCandidate_id());
		return ad;
	}

	public void setAd(ApplicantDetails ad) {
		this.ad = ad;
	}

	@Override
	public String toString() {
		return "Candidate_walkinRequest [cd=" + cd + ", stu_attach=" + stu_attach + ", pgapp=" + pgapp + ", ad=" + ad
				+ "]";
	}
}
