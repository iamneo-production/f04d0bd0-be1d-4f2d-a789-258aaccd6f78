package controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IMovie;
import model.Movie;

@RestController
public class MovieController {

	@Autowired
	IMovie movie;
	
	
	
	@GetMapping("admin")
	public List<Movie>  welcome() {
		return movie.findAll();
	}
	@GetMapping("allMovie")
	public List<Movie> allmovie(){
		
		return movie.findAll();
		
	}
	
	@GetMapping("movie/{id}")
	public  Optional<Movie> specificMovie(@PathVariable("id") int id){
		return movie.findById(id);
	}
	
	@PostMapping("admin/movie")
	public String addmovie(@RequestBody Movie m) {
		movie.save(m);
		return "Movie added";
		
	}
	
	@DeleteMapping("admin/movie/{id}")
	public String deleteMovie(@PathVariable("id") int id) {
		movie.deleteById(id);
		return "Movie deleted";
	}
	@PutMapping("admin/movie/{id}")
	public void updateService1(@RequestBody Movie m, @PathVariable("id")int id) {
		movie.findById(id).map(update -> {
			update.setId(m.getId());
			update.setMname(m.getMname());
			return movie.save(update);});
		
	
		}
	
	
}


public class MovieController {
    
}
