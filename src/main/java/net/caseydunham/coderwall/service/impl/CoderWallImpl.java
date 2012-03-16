package net.caseydunham.coderwall.service.impl;

import com.google.gson.Gson;
import net.caseydunham.coderwall.data.User;
import net.caseydunham.coderwall.exception.CoderWallException;
import net.caseydunham.coderwall.service.CoderWall;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CoderWallImpl implements CoderWall {

  private static final String API_URL = "http://www.coderwall.com/";
  private static final String FORMAT = ".json";

  public CoderWallImpl() {}

  public User getUser(final String username) throws CoderWallException {
    if (username == null || username.isEmpty()) {
      throw new CoderWallException("invalid username");
    }

    try {
      final URL url = new URL(API_URL + username + FORMAT);
      final HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      int respCode = conn.getResponseCode();
      if (respCode != HttpURLConnection.HTTP_OK) {
        throw new CoderWallException(respCode + " " + conn.getResponseMessage());
      }
      return new Gson().fromJson(new InputStreamReader(conn.getInputStream()), User.class);
    } catch (final MalformedURLException ex) {
      throw new CoderWallException(ex);
    } catch (final IOException ex) {
      throw new CoderWallException(ex);
    }
  }

}
