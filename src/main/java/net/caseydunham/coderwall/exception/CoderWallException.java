package net.caseydunham.coderwall.exception;

public class CoderWallException extends Exception {

  public CoderWallException() {
    super();    
  }
  
  public CoderWallException(final String msg) {
    super(msg);
  }
  
  public CoderWallException(final String msg, final Throwable t) {
    super(msg, t);
  }

  public CoderWallException(final Throwable t) {
    super(t);
  }

}
