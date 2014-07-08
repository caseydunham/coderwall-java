package net.caseydunham.coderwall.data;

import java.util.Set;

@SuppressWarnings("unused")
public class User {

	private String username;
	private String name;
	private String team;
	private String location;
	private String company;
	private String title;
	private String thumbnail;
	private Integer endorsements;
	private Set<Badge> badges;
	private String[] specialities;
	private String[] accomplishments;
	private Account accounts;

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Integer getEndorsements() {
		return endorsements;
	}

	public void setEndorsements(Integer endorsements) {
		this.endorsements = endorsements;
	}

	public Set<Badge> getBadges() {
		return badges;
	}

	public void setBadges(Set<Badge> badges) {
		this.badges = badges;
	}

	public String[] getSpecialities() {
		return specialities;
	}

	public void setSpecialities(String[] specialities) {
		this.specialities = specialities;
	}

	public String[] getAccomplishments() {
		return accomplishments;
	}

	public void setAccomplishments(String[] accomplishments) {
		this.accomplishments = accomplishments;
	}

	public Account getAccounts() {
		return accounts;
	}

	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Username: ").append(getUsername())
				.append("\nName: ").append(getName())
				.append("\nTeam: ").append(getTeam())
				.append("\nLocation: ").append(getLocation())
				.append("\nCompany: ").append(getCompany())
				.append("\nTitle: ").append(getTitle())
				.append("\nThumbnail: ").append(getThumbnail())
				.append("\nEndorsements: ").append(getEndorsements())
				.append("\nAccounts: ").append(getAccounts());
		for (final Badge b : getBadges()) {
			sb.append("\n").append(b);
		}
		for (final String s : getSpecialities()) {
			sb.append("\n").append(s);
		}
		for (final String a : getAccomplishments()) {
			sb.append("\n").append(a);
		}
		return sb.toString();
	}

}
