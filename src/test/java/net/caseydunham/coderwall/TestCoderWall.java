package net.caseydunham.coderwall;

import net.caseydunham.coderwall.data.User;
import net.caseydunham.coderwall.exception.CoderWallException;
import net.caseydunham.coderwall.service.CoderWall;
import net.caseydunham.coderwall.service.impl.CoderWallImpl;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.omg.CORBA.TIMEOUT;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestCoderWall {

    private static final long TIMEOUT = 5000L;

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

    @Test(timeout = TIMEOUT)
    public void userWithFullDetailsContainsTwitterHandle() throws CoderWallException {
        CoderWall cw = new CoderWallImpl();
        User bjoern = cw.getUser("bkimminich");
        assertThat(bjoern.getAccounts().getTwitter(), is("bkimminich"));
    }

    @Test(timeout = TIMEOUT)
    public void userWithNoDetailsDoesNotContainTwitterHandle() throws CoderWallException {
        CoderWall cw = new CoderWallImpl();
        User bjoern = cw.getUser("bkimminich", false);
        assertThat(bjoern.getAccounts().getTwitter(), is(nullValue()));
   }

}
