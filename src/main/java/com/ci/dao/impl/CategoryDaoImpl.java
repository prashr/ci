package com.ci.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ci.bean.Category;
import com.ci.dao.CategoryDao;


@Repository
@Qualifier("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
    MongoTemplate mongoTemplate;
	
	final String COLLECTION = "categories";
	
	@Override
	public void create(Category category) {
		 mongoTemplate.insert(category);
		
	}

	@Override
	public void update(Category category) {
		mongoTemplate.save(category);
	}

	@Override
	public void delete(Category category) {
		 mongoTemplate.remove(category);		
	}

	@Override
	public void deleteAll() {
		mongoTemplate.remove(new Query(), COLLECTION);
	}

	@Override
	public Category find(Category category) {
		Query query = new Query(Criteria.where("empId").is(category.getId()));
        return mongoTemplate.findOne(query, Category.class, COLLECTION);
	}

	@Override
	public List<Category> findAll() {
		return (List <Category> ) mongoTemplate.findAll(Category.class);
	}

}
