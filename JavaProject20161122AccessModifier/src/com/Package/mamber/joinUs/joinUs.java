package com.Package.mamber.joinUs;

public abstract class joinUs {
	
	public abstract boolean checkId(String id);
	public abstract boolean checkAge(int age);
	public abstract boolean checkName(String name);
	
	public boolean CheckEmail(String email) {
		if(email.contains("@")){
			return true;
		}
		return false;
	}
	
}
