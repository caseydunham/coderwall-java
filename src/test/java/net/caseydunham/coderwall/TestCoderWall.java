package net.caseydunham.coderwall;

import net.caseydunham.coderwall.data.User;
import net.caseydunham.coderwall.exception.CoderWallException;
import net.caseydunham.coderwall.service.CoderWall;
import net.caseydunham.coderwall.service.impl.CoderWallImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCoderWall {

	@Test(expected = CoderWallException.class)
	public void testGetUserThrowsExceptionWhenUsernameIsNull() throws CoderWallException {
		CoderWall cw = new CoderWallImpl();
		cw.getUser(null);
	}

	@Test(expected = CoderWallException.class)
	public void testGetUserThrowsExceptionWhenUsernameIsEmpty() throws CoderWallException {
		CoderWall cw = new CoderWallImpl();
		cw.getUser("");
	}

	@Test(expected = CoderWallException.class)
	public void testGetUserThrowsExceptionWhenUserIsNotFound() throws CoderWallException {
		CoderWall cw = new CoderWallImpl();
		cw.getUser("this is not a valid user");
	}

	@Test(expected = CoderWallException.class)
	public void testGetUserThrowsExceptionOnInvalidURL() throws CoderWallException {
		CoderWall cw = new CoderWallImpl();
		cw.setBaseUrl("ht//www.coderwall.com");
		cw.getUser("caseydunham");
	}

}
