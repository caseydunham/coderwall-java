package net.caseydunham.coderwall.service;

import net.caseydunham.coderwall.data.User;
import net.caseydunham.coderwall.exception.CoderWallException;

public interface CoderWall {

	String API_URL = "https://www.coderwall.com/";
	String FORMAT = ".json";

	User getUser(final String username) throws CoderWallException;
	User getUser(final String username, final boolean full) throws CoderWallException;
	void setBaseUrl(String baseUrl);
	String getBaseUrl();

}

