package com.ci.services;
 
import java.util.List;

import com.ci.bean.Category;
 
public interface CategoryService {
 
    public void create(Category category);
 
    public void update(Category category);
 
    public void delete(Category category);
 
    public void deleteAll();
 
    public Category find(Category category);
 
    public List<Category> findAll();
}