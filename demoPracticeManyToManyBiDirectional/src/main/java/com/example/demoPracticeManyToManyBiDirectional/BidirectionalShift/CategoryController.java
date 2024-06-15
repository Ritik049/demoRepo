package com.example.demoPracticeManyToManyBiDirectional.BidirectionalShift;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bidirectional/category")
public class CategoryController {
     
	
	@Autowired 
	CategoryService service;
	
	@GetMapping("/")
	public List<Category> getAll()
	{
		return service.getAll();
	}
	
	
	@GetMapping("/{id}")
	public Category getById(@PathVariable Long id)
	{
		return service.getById(id);
	}
	
	@PostMapping("/create")
	public Category create(@RequestBody Category category)
	{
		return service.create(category);
	}
	
	
	@PutMapping("/update/{id}")
	public Category update(@PathVariable Long id, @RequestBody Category category)
	{
		return service.update(id, category);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id)
	{
		return service.delete(id);
	}
}
