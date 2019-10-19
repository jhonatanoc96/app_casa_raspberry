package com.jhonatan.bombillos;

import org.json.JSONObject;
import org.restlet.data.MediaType;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class Pin17Controller extends ServerResource {
//Proporciona una representacion del servicio RESTful del estado del pin.
//Esta clase puede obtener o establecer el estado del LED por medio de objetos JSON.

    @Get("json")
    public Representation getState() {
        JSONObject result = new JSONObject();
        try {
            result.put("state", Pin17.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StringRepresentation(result.toString(), MediaType.APPLICATION_ALL_JSON);
    }

    @Post("json")
    public Representation postState(Representation entity) {
        JSONObject result = new JSONObject();
        try {
            JsonRepresentation json = new JsonRepresentation(entity);
            result = json.getJsonObject();
            boolean state = (boolean)result.get("state");
            Pin17.setState(state);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StringRepresentation(result.toString(), MediaType.APPLICATION_ALL_JSON);
    }
}
