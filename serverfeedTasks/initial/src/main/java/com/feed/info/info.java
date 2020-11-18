package com.feed.info;

import java.util.LinkedList;

public class info {
	
	private LinkedList<String> title =  new LinkedList<String>();
	private LinkedList<String> description =  new LinkedList<String>();
	private LinkedList<String> urlImage =  new LinkedList<String>();
	private LinkedList<String> urlLink =  new LinkedList<String>();
	
	info(){}
	
	public void setTitle(LinkedList<String> title) {
		this.title = title;
	}
	
	public void setDescription(LinkedList<String> description) {
		this.description = description;
	}
	
	public void setUrlImage(LinkedList<String> urlImage) {
		this.urlImage = urlImage;
	}
	
	public void setUrlLink(LinkedList<String> urlLink) {
		this.urlLink = urlLink;
	}
	
	
	
	public LinkedList<String> getTitle() {
		return this.title;
	}
	
	public LinkedList<String> getDescription() {
		return this.description;
	}
	
	public LinkedList<String> getUrlImage() {
		return this.urlImage;
	}
	
	public LinkedList<String> getUrlLink() {
		return this.urlLink;
	}

}