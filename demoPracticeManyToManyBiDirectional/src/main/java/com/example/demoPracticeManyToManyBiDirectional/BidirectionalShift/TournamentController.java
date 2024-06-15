package com.example.demoPracticeManyToManyBiDirectional.BidirectionalShift;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bidirectional/tournament")
public class TournamentController {
    
	@Autowired
	TournamentService tournamentService;
	
	@Autowired
	CategoryService categoryService;
	
	
	//GetAll
	@GetMapping("/")
	public ResponseEntity<List<Tournament>> getAll()
	{
		List<Tournament> lst = tournamentService.getAll();
		
		return new ResponseEntity<>(lst,HttpStatus.FOUND);
	}
	
	//getById
	@GetMapping("/{id}")
	public ResponseEntity<Tournament>getById(@PathVariable Long id)
	{
		return new ResponseEntity<>(tournamentService.getById(id),HttpStatus.FOUND);
	}
	
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<Tournament> create(@RequestBody Tournament tournament)
	{
		return  new ResponseEntity<>(tournamentService.createTournament(tournament),HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/update/{id}")
	public ResponseEntity<Tournament> update(@PathVariable Long id,@RequestBody Tournament tournament)
	{
		return new ResponseEntity<>(tournamentService.updateTournament(id,tournament),HttpStatus.CREATED);
	}
	
	//update Category
	@PutMapping("{id}/addCategory/{reg_id}")
	public ResponseEntity<Tournament> addCategory(@PathVariable Long id, @PathVariable Long reg_id)
	{   
		Category reg = categoryService.getById(reg_id);
		Tournament tr = tournamentService.addCategory(id, reg);
		
		return new ResponseEntity<>(tr,HttpStatus.ACCEPTED);
	}
	
	//removeRegistration
	@PutMapping("{id}/removeCategory/{reg_id}")
	public ResponseEntity<Tournament> removeRegistration(@PathVariable Long id, @PathVariable Long reg_id)
	{   
		Category reg = categoryService.getById(reg_id);
		Tournament tr = tournamentService.removeCategory(id, reg);
		
		return new ResponseEntity<>(tr,HttpStatus.ACCEPTED);
	}
	
	
	//delete 
	@DeleteMapping("/delete/{id}")
	public String deleteTournament(@PathVariable Long id)
	{
           tournamentService.deleteTournament(id);
		
		return "Successfully Deleted";
		
	}
}
