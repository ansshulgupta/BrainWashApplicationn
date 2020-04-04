package com.BrainWash.businesslogicinterface;

import java.util.List;

import com.BrainWash.model.SpellingBook;

public interface InterfaceForAdminSpelling {
	
	
	public String insertSpelling(SpellingBook spellingBook);
	
	public List<SpellingBook> getSpellingBySpellingName(String spellingName);
	
	public List<SpellingBook> getAllSpellingNames();
	
	
	/*
	 * public void editRegisterUser(String email);
	 * public void editSpellingName(String email);
	 * public void deleteRegisterUser(String email);
	 * 
	 * 
	 * 

	 */
	

}
