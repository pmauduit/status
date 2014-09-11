package org.georchestra.status;

import org.junit.Before;
import org.junit.Test;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Status;

public class StatusApplicationTest {

    private StatusApplication statusApp;

    @Before
    public void setUp() {
        statusApp = new StatusApplication();

    }
    @Test
    public void testStatusApplication() {
        assert statusApp != null;
        Request req = new Request();
        req.setResourceRef("/instances");
        Response r = statusApp.handle(req);
        // TODO: better testing objects instantiation
        assert r.getStatus() == Status.SERVER_ERROR_INTERNAL;
    }

}