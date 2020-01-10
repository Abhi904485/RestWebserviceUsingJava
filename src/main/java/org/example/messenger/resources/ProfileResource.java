package org.example.messenger.resources;

import org.example.messenger.model.Profile;
import org.example.messenger.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profiles")
public class ProfileResource {

    private ProfileService profileService = new ProfileService();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getAllProfile() {
        return profileService.getAllProfile();
    }

    @GET
    @Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile getProfile(@PathParam("profileName") String profileName) {
        return profileService.getProfile(profileName);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Profile addProfile(Profile profile) {
        return profileService.addProfile(profile);
    }

    @PUT
    @Path("/{profileName}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
        profile.setProfileName(profileName);
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
    public String deleteProfile(@PathParam("profileName") String profileName) {
        return profileService.removeProfile(profileName);
    }


}
