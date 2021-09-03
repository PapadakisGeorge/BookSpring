package com.springBook.springBook.models;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the cards database table.
 * 
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cards")
@NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c")
public class Card implements Serializable {
	public Card(String name, String description, String category) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Integer cartId;

	private String name;

	@Column(name = "description", length = 67108)
	private String description;

	private String category;

}
