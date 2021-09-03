package com.springBook.springBook.api;



import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBook.springBook.models.Card;
import com.springBook.springBook.repositories.CardRepository;


@RestController
class CardController {

	private final CardRepository repository;

	CardController(CardRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/cards")
	List<Card> all() {
		return repository.findAll();
	}

	@PostMapping("/cards")
	Card newCard(@RequestBody Card newCard) {
		return repository.save(newCard);
	}

	@GetMapping("/cards/{id}")
	Optional<Card> one(@PathVariable Integer id) {

		return repository.findById(id)
				  //.orElseThrow(() -> new CardDoesNotExistException(id));
		;
	}
	
	@GetMapping("/cardsByCategory/{category}")
	List<Card> cardByCategory(@PathVariable String category) {
		return repository.getAllByCategory(category);
	}

	@DeleteMapping("/cards/{id}")
	void deleteCard(@PathVariable Integer id) {
		repository.deleteById(id);
	}
}
