package com.ci.bean;

public class Category {
	
	String id;
	String name;
	String parent;
	boolean isAbstract;
	
	public Category() {
		super();
	}

	public Category(String id, String name, String parent, boolean isAbstract) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.isAbstract = isAbstract;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

}
