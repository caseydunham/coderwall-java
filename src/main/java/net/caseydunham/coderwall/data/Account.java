package net.caseydunham.coderwall.data;

public class Account {

  private String github;
  
  public Account() {}
  
  public String getName() { return github; }
  public void setName(String github) { this.github = github; }
  
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("\nGithub: ").append(getName());
    return sb.toString();
  }
}
