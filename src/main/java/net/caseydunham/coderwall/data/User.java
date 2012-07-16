package net.caseydunham.coderwall.data;

import java.util.Set;

public class User {
  
  private String username;
  private String name;
  private String location;
  private String team;
  private Integer endorsements;
  private Set<Badge> badges;
  private Account accounts; // labeled as "accounts" in the api although there is only the github account

  public User() {}

  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }
  
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  
  public String getTeam() { return team; }
  public void setTeam(String team) { this.team = team; }

  public String getLocation() { return location;}
  public void setLocation(String location) { this.location = location; }

  public Integer getEndorsements() { return endorsements; }
  public void setEndorsements(Integer endorsements) { this.endorsements = endorsements; }

  public Set<Badge> getBadges() { return badges; }
  public void setBadges(Set<Badge> badges) { this.badges = badges; }
  
  public Account getAccounts() { return accounts; }
  public void setAccounts(Account accounts) { this.accounts = accounts; }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Username: ").append(getUsername())
      .append("\nName: ").append(getName())
      .append("\nTeam: ").append(getTeam())
      .append("\n").append(getAccounts())
      .append("\nLocation: ").append(getLocation())
      .append("\nEndorsements: ").append(getEndorsements());
    for (final Badge b : getBadges()) {
      sb.append("\n").append(b);
    }
    return sb.toString();
  }
  
}
