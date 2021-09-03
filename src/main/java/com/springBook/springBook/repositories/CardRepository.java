package com.springBook.springBook.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springBook.springBook.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
	List<Card> getAllByCategory(String category);

}