package controllers;

import models.MapAnime;
import models.Move;

import org.codehaus.jackson.JsonNode;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;

public class Application extends Controller {

	public static Result index() {
		return redirect(routes.Application.showMap());
	}

	public static Result showMap() {
		return ok(views.html.map.render());

	}

	public static Result moveTo() {
		Form<Move> moveForm = form(Move.class);

		Move move = moveForm.bindFromRequest().get();

		MapAnime.moveTo(move.longitude, move.latitude);

		return ok(String.valueOf(move.latitude));

	}

	/**
	 * Handle the map websocket.
	 */
	public static WebSocket<JsonNode> mapsocket() {
		return new WebSocket<JsonNode>() {

			// Called when the Websocket Handshake is done.
			@Override
			public void onReady(WebSocket.In<JsonNode> in,
					WebSocket.Out<JsonNode> out) {

				try {

					MapAnime.register(java.util.UUID.randomUUID().toString(),
							in, out);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
	}

}