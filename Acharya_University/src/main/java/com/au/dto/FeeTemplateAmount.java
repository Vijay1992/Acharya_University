package com.au.dto;

import java.util.List;
import com.au.model.FeeTemplate;
import com.au.model.FeeTemplateSubAmount;

public class FeeTemplateAmount {

	FeeTemplate ft;

	List<FeeTemplateSubAmount> ftsa;

	public FeeTemplate getFt() {
		return ft;
	}

	public void setFt(FeeTemplate ft) {
		this.ft = ft;
	}

	public List<FeeTemplateSubAmount> getFtsa() {
		return ftsa;
	}

	public void setFtsa(List<FeeTemplateSubAmount> ftsa) {
		this.ftsa = ftsa;
	}

}
