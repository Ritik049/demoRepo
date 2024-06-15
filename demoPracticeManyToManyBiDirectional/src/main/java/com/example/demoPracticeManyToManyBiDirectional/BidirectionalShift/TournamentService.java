package com.example.demoPracticeManyToManyBiDirectional.BidirectionalShift;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {
      
	@Autowired
	TournamentRepository repo;
	
	@Autowired
	CategoryRepository  catRepo;
	
	//CRUD
	
	public List<Tournament> getAll()
	{
		return repo.findAll();
	}
	
	public Tournament getById(Long id)
	{
		return repo.findById(id).get();
	}
	
	
     public Tournament createTournament(Tournament tournament)
     {
    	 return repo.save(tournament);
     }
     
     public Tournament updateTournament(Long id, Tournament tournament)
     {
    	 Tournament tr = repo.findById(id).get();
    	  tr.setName(tournament.getName());
    	  tr.setCountry(tournament.getCountry());
    	  
    	  return repo.save(tr);
     }
     
     public  String deleteTournament(Long id)
     {  repo.findById(id).get().removeCategoryAll();
    	 repo.deleteById(id);
    	 
    	 return "Successfully Deleted";
     }
     
     public Tournament addCategory(Long id,Category category)
     {
    	 Tournament tr = repo.findById(id).get();
    	 category.addTournament(tr);
    	 
    	 tr.addCategory(category);
    	 
    	 
    	 return repo.save(tr);
    	  
     }
     
     public Tournament removeCategory(Long id, Category category)
     {
    	 Tournament tr = repo.findById(id).get();
    	 
    	 tr.removeCategory(category);
    	 
    	 return repo.save(tr);
     }
     
     
}

