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

		int cpt = 0;

		// we store the old location for the chaser vehicle
		List<String> cache = new ArrayList<String>();

		String line;
		while ((line = br.readLine()) != null) {
			String[] split = line.split(";");
			if (split.length > 1) {

				cache.add(line);

				move("Oh no, I'm being followed !!", split);

				// move the second vehicle ("the chaser")
				// we let 20 steps ahead
				if (cpt > 20) {
					String chaserPosition = cache.get(cpt - 20);
					move("I'll catch you !!", chaserPosition.split(";"));
				}

				Thread.sleep(100);
			}
			cpt++;

		}

	}

	/**
	 * Move a vehicle
	 * 
	 * @param vehicleId
	 *            the vehicle to move
	 * @param longLat
	 *            the new position
	 */
	private void move(String vehicleId, String[] longLat) {

		String longitude = longLat[0];
		String latitude = longLat[1];

		// Since logger are disable in Play! tests
		// (https://groups.google.com/forum/#!msg/play-framework/ydU081RerA8/zueBL2ePJgcJ)
		// we use a System.out.println
		System.out.println("Moving '" + vehicleId + "' to " + longitude + ", "
				+ latitude);

		HttpClient client = new DefaultHttpClient();

		HttpPost post = new HttpPost("http://localhost:9000/moveTo");
		try {
			// move the first vehicle ("the victim")
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("id", vehicleId));
			nameValuePairs.add(new BasicNameValuePair("timestamp", String
					.valueOf(System.currentTimeMillis())));
			nameValuePairs.add(new BasicNameValuePair("longitude", longitude));
			nameValuePairs.add(new BasicNameValuePair("latitude", latitude));

			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			client.execute(post);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
