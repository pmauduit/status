package org.georchestra.status.resources;

import java.util.List;

import org.georchestra.status.HibernateUtil;
import org.georchestra.status.entities.Instance;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
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

public class InstancesResource extends ServerResource {

  public InstancesResource() {
    super();
  }
  public InstancesResource(Context context, Request request, Response response) {
    getVariants().add(new Variant(MediaType.APPLICATION_JSON));
  }

  @Override
  protected Representation get() throws ResourceException {
    JSONObject ret = new JSONObject();
    JSONArray instances = new JSONArray();


    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session s = sf.openSession();
    Criteria c = s.createCriteria(Instance.class);
    c.setMaxResults(50);

    List<Instance> list = c.list();
    for (Instance i : list) {
        instances.put(i.toJSON());
    }

    ret.put("instances", instances);
    return new StringRepresentation(ret.toString(4), MediaType.APPLICATION_JSON);
  }

}
