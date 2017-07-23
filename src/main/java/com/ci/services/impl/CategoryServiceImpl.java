package com.ci.services.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.bean.Category;
import com.ci.dao.CategoryDao;
import com.ci.services.CategoryService;

 
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
 
    @Autowired
    CategoryDao categoryDao;
 
   
	@Override
	public void create(Category category) {
		categoryDao.create(category);
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	@Override
	public Category find(Category category) {
		return categoryDao.find(category);
	}

	@Override
	public void deleteAll() {
		categoryDao.deleteAll();
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
}
