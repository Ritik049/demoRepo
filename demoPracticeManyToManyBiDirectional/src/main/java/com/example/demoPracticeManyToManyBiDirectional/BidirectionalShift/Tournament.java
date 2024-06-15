package com.example.demoPracticeManyToManyBiDirectional.BidirectionalShift;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.*;

@Entity
public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	private String name;
	private String country;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinTable(
			name = "tournament_categories",
			joinColumns = @JoinColumn(name = "tournament_id"),
			inverseJoinColumns = @JoinColumn(name = "catgory_id"))
	@JsonIgnoreProperties("Tournament")
	private List<Category>categories;
	
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void addCategory(Category category)
	{
		if(categories==null)
		{
			categories = new ArrayList<>();
		}
		
		categories.add(category);
	}
	
	public void removeCategory(Category category)
	{
		if(categories==null) return;
		
		categories.remove(category);
	}
	
	public void removeCategoryAll()
	{
		categories = null;
	}
	
	public Tournament() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tournament(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
