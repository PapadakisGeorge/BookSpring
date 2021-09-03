package com.springBook.springBook;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.springBook.springBook.models.Card;
import com.springBook.springBook.repositories.CardRepository;



@Component
public class InitialData implements ApplicationRunner {

    private CardRepository cardRepository;
    
    public void run(ApplicationArguments args) {	
    	cardRepository.save(new Card("Cloud Seeding","Requires 3 ocean tiles. Decrease your MC production 1 step and any heat production 1 step. Increase your Plant production 2 steps. ","Automated"));
    	cardRepository.save(new Card("Asteroid Mining Consortium","Requires that you have titanium production. Decrease any titanium production 1 step and increase your own 1 step.","Automated"));
    	cardRepository.save(new Card("Martian Rails","Action: Spend 1 Energy to gain 1 MC for each City tile ON MARS.","Action"));

    }
    
    
    @Autowired
	public InitialData(CardRepository cardRepository) {
		super();
		this.cardRepository = cardRepository;
	}



}

