package com.challenge.StoreAPI.models;

public enum ProductCategory {

	PETS_AND_PLANTS("Pets and Plants"),
	APPS_AND_SOFTWARES("Apps and Softwares"),
	HOME_AND_CONSTRUCTION("Home and Construction"),
	COOKING_AND_GASTRONOMY("Cooking and Gastronomy"),
	PERSONAL_DEVELOPMENT("Personal Development"),
	DESIGN("Design"),
	LAW("Law"),
	ENVIRONMENT("Environment"),
	EDUCATION("Education"),
	SPIRITUALITY("Spirituality");
	
	
	private final String description;
	
	ProductCategory(String description){
		this.description = description;
	}	
	
}
