package com.ci.rest;


import java.io.IOException;
import java.util.List;


import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ci.bean.Category;
import com.ci.configuration.ApplicationConfiguraion;
import com.ci.services.CategoryService;






@Path("category")
public class CategoryRest {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguraion.class);
	CategoryService categoryService = (CategoryService) context.getBean("categoryService");
	
	
	
	@GET
	@Path("/getall")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Category> getCategories() {
		List<Category> categories = categoryService.findAll();
		return categories;
	}
	
	@POST
	@Path("/create")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createEmployee(
			@FormParam("id") String id,
			@FormParam("name") String name,
			@FormParam("parent") String parent,
			@FormParam("abstract") Boolean isAbstract,
			@Context HttpServletResponse servletResponse) throws IOException{
		Category category  = new Category(id, name, parent, isAbstract);
		Category category1  = categoryService.find(category);
		if(category1!=null){
			servletResponse.sendRedirect("../../error.html");
			return;
		}
		categoryService.create(category);
		servletResponse.sendRedirect("../../success.html");
	}
	
	@POST
	@Path("/update")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateCategory(
			@FormParam("id") String id,
			@FormParam("name") String name,
			@FormParam("parent") String parent,
			@FormParam("abstract") Boolean isAbstract,
			@Context HttpServletResponse servletResponse) throws IOException{
		Category category  = new Category(id, name, parent, isAbstract);
		Category category1  = categoryService.find(category);
		if(category1==null){
			servletResponse.sendRedirect("../../error.html");
			return;
		}
		category.setId(category.getId());
		categoryService.update(category);
		servletResponse.sendRedirect("../../success.html");
	}
	
	@GET
	@Path("/del/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Category delEmployee(@PathParam("id") String id, 
			@Context HttpServletResponse servletResponse) throws IOException{
		Category cat = new Category();
		cat.setId(id);
		cat =categoryService.find(cat);
		categoryService.delete(cat);
		return cat;
	}
	
	@GET
	@Path("/find/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Category findEmployee(@PathParam("id") String id, 
			@Context HttpServletResponse servletResponse) throws IOException{
		Category cat = new Category();
		cat.setId(id);
		cat =categoryService.find(cat);
		return cat;
	}
}
