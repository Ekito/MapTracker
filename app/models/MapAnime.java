package models;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.Logger;
import play.libs.Akka;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import play.libs.Json;
import play.mvc.WebSocket;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * The moves on the map.
 * 
 * @author ndeverge
 * 
 */
public class MapAnime extends UntypedActor {

	static ActorRef actor = Akka.system().actorOf(new Props(MapAnime.class));

	/**
	 * The registred clients.
	 */
	Map<String, WebSocket.Out<JsonNode>> registrered = new HashMap<String, WebSocket.Out<JsonNode>>();

	/**
	 * 
	 * @param id
	 * @param in
	 * @param out
	 * @throws Exception
	 */
	public static void register(final String id,
			final WebSocket.In<JsonNode> in, final WebSocket.Out<JsonNode> out)
			throws Exception {

		actor.tell(new RegistrationMessage(id, out));

		// For each event received on the socket,
		in.onMessage(new Callback<JsonNode>() {
			@Override
			public void invoke(JsonNode event) {
				// nothing to do
			}
		});

		// When the socket is closed.
		in.onClose(new Callback0() {
			@Override
			public void invoke() {
				actor.tell(new UnregistrationMessage(id));
			}
		});
	}

	public static void moveTo(String id, long timestamp, float longitude,
			float latitude) {

		actor.tell(new MoveMessage(id, timestamp, longitude, latitude));

	}

	@Override
	public void onReceive(Object message) throws Exception {

		if (message instanceof RegistrationMessage) {

			// Received a Join message
			RegistrationMessage registration = (RegistrationMessage) message;

			Logger.info("Registering " + registration.id + "...");
			registrered.put(registration.id, registration.channel);

		} else if (message instanceof MoveMessage) {

			// Received a Move message
			MoveMessage move = (MoveMessage) message;

			for (WebSocket.Out<JsonNode> channel : registrered.values()) {

				ObjectNode event = Json.newObject();
				event.put("id", move.id);
				event.put("timestamp", move.timestamp);
				event.put("longitude", move.longitude);
				event.put("latitude", move.latitude);

				channel.write(event);
			}

		} else if (message instanceof UnregistrationMessage) {

			// Received a Unregistration message
			UnregistrationMessage quit = (UnregistrationMessage) message;

			Logger.info("Unregistering " + quit.id + "...");
			registrered.remove(quit.id);

		} else {
			unhandled(message);
		}

	}

	public static class RegistrationMessage {
		public String id;
		public WebSocket.Out<JsonNode> channel;

		public RegistrationMessage(String id, WebSocket.Out<JsonNode> channel) {
			super();
			this.id = id;
			this.channel = channel;
		}
	}

	public static class UnregistrationMessage {
		public String id;

		public UnregistrationMessage(String id) {
			super();
			this.id = id;
		}
	}

	public static class MoveMessage {

		public String id;

		public long timestamp;

		public float longitude;

		public float latitude;

		public MoveMessage(String id, long timestamp, float longitude,
				float latitude) {
			this.id = id;
			this.timestamp = timestamp;
			this.longitude = longitude;
			this.latitude = latitude;
		}

	}

}
