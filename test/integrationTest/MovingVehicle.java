package integrationTest;

import static org.fest.assertions.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

public class MovingVehicle {

	@Test
	public void simulateMovingVehicle() throws Exception {

		InputStream testData = getClass().getResourceAsStream(
				"/integrationTest/testdata.txt");

		assertThat(testData).isNotNull();

		BufferedReader br = new BufferedReader(new InputStreamReader(testData));

		String line;
		while ((line = br.readLine()) != null) {
			String[] split = line.split(";");
			if (split.length > 1) {
				String longitude = split[0];
				String latitude = split[1];

				// Since logger are disable in Play! tests
				// (https://groups.google.com/forum/#!msg/play-framework/ydU081RerA8/zueBL2ePJgcJ)
				// we use a System.out.println
				System.out.println("Moving to " + longitude + ", " + latitude);

				HttpClient client = new DefaultHttpClient();

				HttpPost post = new HttpPost("http://localhost:9000/moveTo");
				try {
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
							1);
					nameValuePairs.add(new BasicNameValuePair("longitude",
							longitude));
					nameValuePairs.add(new BasicNameValuePair("latitude",
							latitude));

					post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

					client.execute(post);

				} catch (IOException e) {
					e.printStackTrace();
				}

				Thread.sleep(100);
			}

		}

	}

}
