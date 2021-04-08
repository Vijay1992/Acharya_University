package com.au.dto;

import com.au.model.FeeTemplate;
import com.au.model.FeeTemplateSubAmount;

public class FeeTemplateAmount {
	
	FeeTemplate ft;
	
	FeeTemplateSubAmount ftsa;

	public FeeTemplate getFt() {
		return ft;
	}

	public void setFt(FeeTemplate ft) {
		this.ft = ft;
	}

	public FeeTemplateSubAmount getFtsa() {
		return ftsa;
	}

	public void setFtsa(FeeTemplateSubAmount ftsa) {
		this.ftsa = ftsa;
	}
	
	
	

}
