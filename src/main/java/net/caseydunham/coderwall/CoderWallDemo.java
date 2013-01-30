package net.caseydunham.coderwall;

import net.caseydunham.coderwall.data.User;
import net.caseydunham.coderwall.exception.CoderWallException;
import net.caseydunham.coderwall.service.CoderWall;
import net.caseydunham.coderwall.service.impl.CoderWallImpl;

public class CoderWallDemo {

	public static void main(final String[] args) throws CoderWallException {
		System.out.println("[*] coderwall api java client ");
		if (args.length != 1) {
			System.out.println("usage: java -jar coderwall.jar [username]");
			System.exit(1);
		}

		final String username = args[0];
		final CoderWall cw = new CoderWallImpl();
		final User user = cw.getUser(username, true);
		System.out.println(user);
	}

}
