package com.ats.core.control.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ats.core.control.entity.CtlLogin;

@Service("SearchService")
public class SearchService {

	@PersistenceContext
	private EntityManager entityManager;

	private FullTextEntityManager fullTextEntityManager;

	@Transactional(readOnly = false)
	public List search(String srchStr) {
		// initSearch();

		// create native Lucene query unsing the query DSL
		// alternatively you can write the Lucene query using the Lucene query parser
		// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
		QueryBuilder qb = getFullTextEntityManager().getSearchFactory().buildQueryBuilder().forEntity(CtlLogin.class).get();
		org.apache.lucene.search.Query luceneQuery = qb.keyword().onFields("sessionId", "clientIp").matching(srchStr).createQuery();

		// wrap Lucene query in a javax.persistence.Query
		javax.persistence.Query jpaQuery = getFullTextEntityManager().createFullTextQuery(luceneQuery, CtlLogin.class);

		// execute search
		List<?> qResult = jpaQuery.getResultList();

		System.out.println(qResult);

		return qResult;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public FullTextEntityManager getFullTextEntityManager() {

		fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

		if (fullTextEntityManager == null) {
			try {
				fullTextEntityManager.createIndexer().startAndWait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return fullTextEntityManager;
	}

	public void setFullTextEntityManager(FullTextEntityManager fullTextEntityManager) {
		this.fullTextEntityManager = fullTextEntityManager;
	}

}
