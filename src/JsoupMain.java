import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupMain {

	public static void main(String[] args) throws MalformedURLException,
			IOException, JSONException {

		String url = "http://internalapi.csdn.net/dg/batch/content?x-acl-token=GwQitTY2mF/Hp2LiZ7BcEdBYn34K&ids=05D580150A4D1D704F5A14DA96BC34F6_1_IPHONE_APP&fields=body&type=content_center";
		HttpURLConnection connection = (HttpURLConnection) new URL(url)
				.openConnection();
		connection.connect();
		InputStream in = connection.getInputStream();
		String s = convertStreamToString(in);
		JSONArray ja = new JSONArray(s);
		String body = ja.getJSONObject(0).getString("body");
		System.out.println(body);
		
		Document d = Jsoup.parseBodyFragment(body);
		
//		System.out.println(d.body().html());
	}

	public static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		StringBuilder sb = new StringBuilder();

		String line = null;

		try {

			while ((line = reader.readLine()) != null) {

				sb.append(line + "/n");

			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				is.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

		return sb.toString();

	}

}
