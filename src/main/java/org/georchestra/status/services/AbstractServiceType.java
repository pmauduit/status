package org.georchestra.status.services;

/**
 *
 * The purpose of this class is to describe a service type and the default
 * behaviour to test it.
 *
 * By default, a HTTP hit is made onto the entry point, ensuring the HTTP return
 * code is 200 OK.
 *
 * for daughter classes, it is possible to override the default methods so that
 * they can return extra information (by default, only the time needed to fire
 * the HTTP query is returned), like number of objects returned by the service,
 * ...
 *
 *
 * @author pmauduit
 *
 */
public abstract class AbstractServiceType {

}
