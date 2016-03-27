package com.ats.core.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.ats.core.control.service.SearchService;

@Test(priority = 1)
@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class hibernateSearchTest extends AbstractTestNGSpringContextTests {

	@Autowired
	SearchService searchService;

	@Test
	public void testSearch() {
		searchService.search("B58F939ABF5A7393A2A07BC9FD94EF1E");
	}

	public SearchService getSearchService() {
		return searchService;
	}

}
