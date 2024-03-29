package org.georchestra.status.resources;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class RunJobResource extends ServerResource {

    private final Logger  LOG = Logger.getLogger(this.getClass());

    public RunJobResource() {
      super();
    }

    public RunJobResource(Context context, Request request, Response response) {
      getVariants().add(new Variant(MediaType.APPLICATION_JSON));
    }

    @Override
    protected Representation get() throws ResourceException {
        JSONObject ret = new JSONObject();

        return new StringRepresentation(ret.toString(4), MediaType.APPLICATION_JSON);
    }
}
