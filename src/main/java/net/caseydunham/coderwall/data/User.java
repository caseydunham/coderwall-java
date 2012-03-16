package net.caseydunham.coderwall.data;

import java.util.Set;

public class User {
  
  private String username;
  private String location;
  private Integer endorsements;
  private Set<Badge> badges;

  public User() {}

  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }

  public String getLocation() { return location;}
  public void setLocation(String location) { this.location = location; }

  public Integer getEndorsements() { return endorsements; }
  public void setEndorsements(Integer endorsements) { this.endorsements = endorsements; }

  public Set<Badge> getBadges() { return badges; }
  public void setBadges(Set<Badge> badges) { this.badges = badges; }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Name: ").append(getUsername())
      .append("\nLocation: ").append(getLocation())
      .append("\nEndorsements: ").append(getEndorsements());
    for (final Badge b : getBadges()) {
      sb.append("\n").append(b);
    }
    return sb.toString();
  }
  
}
