package com.ci.dao;

import java.util.List;

import com.ci.bean.Category;


public interface CategoryDao {
	
	public void create(Category category);

	public void update(Category category);

	public void delete(Category category);

	public void deleteAll();

	public Category find(Category category);

	public List<Category> findAll();

}
