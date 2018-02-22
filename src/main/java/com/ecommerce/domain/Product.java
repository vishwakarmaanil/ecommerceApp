package com.ecommerce.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product
{
	private Long id;
	private Byte[] image;
	private Double price;
	private String description;
	private String shortDescription;

	private User user;
	private Set<Review> reviews = new HashSet<>();
	private Set<Cart> carts = new HashSet<>();

	@Id
	@GeneratedValue
	public Long getId()
	{
		return id;
	}

	public Byte[] getImage()
	{
		return image;
	}

	public void setImage(Byte[] image)
	{
		this.image = image;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getShortDescription()
	{
		return shortDescription;
	}

	public void setShortDescription(String shortDescription)
	{
		this.shortDescription = shortDescription;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@ManyToOne
	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	// Since product is owning side to Review, so cascade so that if no parent then
	// no orphans child
	// mapped by specifies = birection
	// What is the product instance inside child review ( Review.java )= add that instance in mappedBy
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	public Set<Review> getReviews()
	{
		return reviews;
	}

	public void setReviews(Set<Review> reviews)
	{
		this.reviews = reviews;
	}

	//It is birectional so declare join by table on the child side program
	@ManyToMany(cascade= CascadeType.ALL, mappedBy= "products")
	public Set<Cart> getCarts()
	{
		return carts;
	}

	public void setCarts(Set<Cart> carts)
	{
		this.carts = carts;
	}
}
