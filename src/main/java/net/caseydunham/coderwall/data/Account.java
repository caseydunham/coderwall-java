package net.caseydunham.coderwall.data;

@SuppressWarnings("unused")
public class Account {

	private String github;
	private String twitter;

	public Account() {
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("\nGithub: ").append(getGithub())
				.append("\nTwitter: ").append(getTwitter());
		return sb.toString();
	}

}
