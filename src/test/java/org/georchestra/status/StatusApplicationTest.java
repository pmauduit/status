package org.georchestra.status;

import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Status;

public class StatusApplicationTest {

    private StatusApplication statusApp;

    @Before
    public void setUp() {
        statusApp = new StatusApplication();
    }

    /**
     *  Tests the statusApplication
     *
     */
    @Test
    public void testStatusApplication() {
        Request req = new Request();
        req.setMethod(Method.GET);
        req.setResourceRef("/instances");

        Response r = statusApp.handle(req);

        assertTrue(r.getStatus() == Status.SUCCESS_OK);

        // it must return an object with an empty array
        assertTrue(new JSONObject(r.getEntityAsText()).getJSONArray("instances").length() == 0);
    }

}