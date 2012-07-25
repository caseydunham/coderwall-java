package net.caseydunham.coderwall.data;

public class Badge {

  private String name;

  private String badge;
  private String description;
  private String created;

  public Badge() {}

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getBadge() { return badge; }
  public void setBadge(String badge) { this.badge = badge; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  
  public String getCreated() { return created; }
  public void setCreated(String created) { this.created = created; }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("\nBadge: ").append(getName())
      .append("\nDescription: ").append(getDescription())
      .append("\nCreated: ").append(getCreated())
      .append("\nURL: ").append(getBadge());
    return sb.toString();
  }

}
