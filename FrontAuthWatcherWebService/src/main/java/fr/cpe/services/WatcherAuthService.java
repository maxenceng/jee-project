package fr.cpe.services;

import fr.cpe.models.UserModel;
import fr.cpe.utils.AuthResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

// Webservice
@Path("/WatcherAuth")
public interface WatcherAuthService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    AuthResponse get();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    AuthResponse post(UserModel user);
}
