package net.caseydunham.coderwall.service;

import net.caseydunham.coderwall.data.User;
import net.caseydunham.coderwall.exception.CoderWallException;

public interface CoderWall {

  User getUser(final String username, final boolean full) throws CoderWallException;

}

