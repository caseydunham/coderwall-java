package net.caseydunham.coderwall.service.impl;

import com.google.gson.Gson;
import net.caseydunham.coderwall.data.User;
import net.caseydunham.coderwall.exception.CoderWallException;
import net.caseydunham.coderwall.service.CoderWall;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class CoderWallImpl implements CoderWall {

	private String baseUrl;

	public CoderWallImpl() {
		setBaseUrl(API_URL);
	}

	public User getUser(final String username) throws CoderWallException {
		return getUser(username, true);
	}

	public User getUser(final String username, final boolean full) throws CoderWallException {
		if (username == null || username.isEmpty()) {
			throw new CoderWallException("invalid username");
		}

		try {
			final String url = getBaseUrl() + username + FORMAT + (full ? "?full=true" : "");
			final HttpsURLConnection conn = getConnection(url);
			int respCode = conn.getResponseCode();
			if (respCode != HttpURLConnection.HTTP_OK) {
				throw new CoderWallException(respCode + " " + conn.getResponseMessage());
			}
			String response = getResponseBody(conn.getInputStream());
			return new Gson().fromJson(response, User.class);
		} catch (final MalformedURLException ex) {
			throw new CoderWallException(ex);
		} catch (final IOException ex) {
			throw new CoderWallException(ex);
		}
	}

	private HttpsURLConnection getConnection(final String url) throws IOException {
		HttpsURLConnection connection = null;
		try {
			connection = (HttpsURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("GET");
			return connection;
		} catch (ProtocolException ex) {
			throw new IOException(ex);
		} catch (MalformedURLException ex) {
			throw new IOException(ex);
		} catch (IOException ex) {
			throw new IOException(ex);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	private String getResponseBody(InputStream is) throws IOException {
		String s = new Scanner(is, "utf-8").useDelimiter("\\A").next();
		is.close();
		return s;
	}

	public String getBaseUrl() { return baseUrl; }
	public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }

}
