-- Default SQL data
INSERT INTO status.instances VALUES (1, 'sdi.georchestra.org', false);

INSERT INTO status.services (id, class, uri_path, instance_id) VALUES (nextval('status.service_id_seq'), 'org.georchestra.status.services.GeonetworkServiceType', 'geonetwork', 1);
INSERT INTO status.services (id, class, uri_path, instance_id) VALUES (nextval('status.service_id_seq'), 'org.georchestra.status.services.AnalyticsServiceType', 'analytics', 1);
INSERT INTO status.services (id, class, uri_path, instance_id) VALUES (nextval('status.service_id_seq'), 'org.georchestra.status.services.ExtractorappServiceType', 'extractorapp', 1);
INSERT INTO status.services (id, class, uri_path, instance_id) VALUES (nextval('status.service_id_seq'), 'org.georchestra.status.services.GeofenceServiceType', 'geofence', 1);
INSERT INTO status.services (id, class, uri_path, instance_id) VALUES (nextval('status.service_id_seq'), 'org.georchestra.status.services.GeoserverServiceType', 'geoserver', 1);
INSERT INTO status.services (id, class, uri_path, instance_id) VALUES (nextval('status.service_id_seq'), 'org.georchestra.status.services.GeowebcacheServiceType', 'gwc', 1);
INSERT INTO status.services (id, class, uri_path, instance_id) VALUES (nextval('status.service_id_seq'), 'org.georchestra.status.services.LdapadminServiceType', 'ldapadmin', 1);
INSERT INTO status.services (id, class, uri_path, instance_id) VALUES (nextval('status.service_id_seq'), 'org.georchestra.status.services.MapfishappServiceType', 'mapfishapp', 1);



INSERT INTO status.services (class, uri_path, instance_id) VALUES ('org.georchestra.status.services.MapfishappServiceType', 'mapfishapp', 1);