# Registry

* This application is a client-side service discovery service.
* It is a service registry meaning that it is responsible for keeping up downstream microservice instances and their locations.
* Service instances are registered with the service registry on startup and deregistered on shutdown.
* A service registry might invoke a service instance’s health check API to verify that it is able to handle requests