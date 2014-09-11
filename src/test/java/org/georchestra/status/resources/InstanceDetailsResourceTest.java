package org.georchestra.status.resources;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.georchestra.status.StatusApplication;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Status;

public class InstanceDetailsResourceTest {

    private StatusApplication statusApp;

    @Before
    public void setUp() {
        statusApp = new StatusApplication();
    }

    @Test
    public void testInstanceDetailsResource() throws IOException {
        Request req = new Request();
        req.setMethod(Method.GET);
        req.setResourceRef("/instance/1234");

        Response r = statusApp.handle(req);

        assertTrue(r.getStatus() == Status.SUCCESS_OK);
        assertTrue(new JSONObject(r.getEntityAsText()).getInt("instance_id") == 1234);
    }

    @Test
    public void testInstanceDetailsResourceFail() throws IOException {
        Request req = new Request();
        req.setMethod(Method.GET);
        req.setResourceRef("/instance/1234sdfsdh");

        Response r = statusApp.handle(req);

        assertTrue(r.getStatus() == Status.CLIENT_ERROR_BAD_REQUEST);
        assertTrue(new JSONObject(r.getEntityAsText()).getInt("instance_id") == -1);

    }
}
