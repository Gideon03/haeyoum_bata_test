package com.haeyoum.error;

public class LoginError {
    boolean idError = false;
    boolean pwError = false;
    boolean notConfirmUser = false;
	
    public LoginError() {
	}
	public boolean isIdError() {
		return idError;
	}
	public void setIdError(boolean idError) {
		this.idError = idError;
	}
	public boolean isPwError() {
		return pwError;
	}
	public void setPwError(boolean pwError) {
		this.pwError = pwError;
	}
	public boolean isNotConfirmUser() {
		return notConfirmUser;
	}
	public void setNotConfirmUser(boolean notConfirmUser) {
		this.notConfirmUser = notConfirmUser;
	}
}
