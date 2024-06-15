package com.example.demoPracticeManyToManyBiDirectional.BidirectionalShift;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
	@Autowired 
	CategoryRepository repo;
	
	public List<Category> getAll()
	{
		return  repo.findAll();
	}
	
	public Category getById(Long id)
	{
		return repo.findById(id).get();
	}
	
	public Category create(Category category)
	{
		return repo.save(category);
	}
	
	public Category update(Long id,Category category)
	{
		Category ct = repo.findById(id).get();
		
		ct.setName(category.getName());
		
		return repo.save(ct);
		
		
	}
	
	public String delete(Long id)
	{   repo.findById(id).get().removeAllTournament();
		repo.deleteById(id);
		return "Successfully Deleted";
	}
	
	
}
