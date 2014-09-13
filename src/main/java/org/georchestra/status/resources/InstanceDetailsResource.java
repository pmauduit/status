package org.georchestra.status.resources;

import java.util.Set;

import org.apache.log4j.Logger;
import org.georchestra.status.HibernateUtil;
import org.georchestra.status.entities.Instance;
import org.georchestra.status.entities.Service;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.representation.Variant;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class InstanceDetailsResource extends ServerResource {

    private final Logger  LOG = Logger.getLogger(this.getClass());

    public InstanceDetailsResource() {
      super();
    }

    public InstanceDetailsResource(Context context, Request request, Response response) {
      getVariants().add(new Variant(MediaType.APPLICATION_JSON));
    }

    @Override
    protected Representation get() throws ResourceException {
      JSONObject ret = new JSONObject();

      int rid = -1;
      try {
          rid = Integer.parseInt((String) this.getRequestAttributes().get("instanceId"));
      } catch (NumberFormatException e) {
          LOG.error("Unable to cast instance id to integer");
          this.setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
      }
      Session s = HibernateUtil.getSessionFactory().openSession();

      Instance curI = (Instance) s.get(Instance.class, rid);
      ret.put("instance", curI.toJSON());
      JSONArray services = new JSONArray();

      Set<Service> ls = curI.getServices();
      for (Service ss: ls) {
          services.put(ss.toJSON());
      }
      ret.put("services", services);



      return new StringRepresentation(ret.toString(4), MediaType.APPLICATION_JSON);
    }

  }