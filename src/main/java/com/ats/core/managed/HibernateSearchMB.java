package com.ats.core.managed;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.ats.core.control.entity.CtlLogin;
import com.ats.core.control.service.SearchService;

@ManagedBean(name = "hibernateSearchMB")
@ViewScoped
public class HibernateSearchMB {

	@ManagedProperty(value = "#{SearchService}")
	private SearchService searchService;

	public String searchStr;

	private List<CtlLogin> loginList;

	@PostConstruct
	private void init() {
		loginList = new ArrayList<CtlLogin>();
	}

	public void search() {
		loginList = searchService.search(searchStr);
	}

	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	public String getSearchStr() {
		return searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

	public List<CtlLogin> getLoginList() {
		return loginList;
	}

	public void setLoginList(List<CtlLogin> loginList) {
		this.loginList = loginList;
	}
}
