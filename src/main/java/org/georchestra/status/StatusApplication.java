package org.georchestra.status;

import org.apache.log4j.Logger;
import org.georchestra.status.resources.StatusResource;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class StatusApplication extends Application {

  private final Logger  LOG = Logger.getLogger(this.getClass());
  public StatusApplication() {
    super();
  }

  public StatusApplication(Context parentContext) {
    super(parentContext);
  }

  public Restlet createInboundRoot() {
    Router router = new Router(getContext());

    router.attach("/status", StatusResource.class);

    LOG.warn("router created");
    return router;
  }

}
