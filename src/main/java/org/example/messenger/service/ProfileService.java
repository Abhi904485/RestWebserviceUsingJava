package org.example.messenger.service;

import org.example.messenger.database.DatabaseClass;
import org.example.messenger.model.Profile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProfileService {
    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
        profiles.put("profile1", new Profile(1L, "profile1", "Abhishek", "Singh"));
        profiles.put("profile2", new Profile(2L, "profile2", "Shivendra", "Singh"));
    }

    public List<Profile> getAllProfile() {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(String profileKey) {
        return profiles.get(profileKey);
    }

    public Profile addProfile(Profile profile) {
        profile.setProfileName(profile.getProfileName());
        profile.setCreatedBy(new Date());
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getId() <= 0) {
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public String removeProfile(String profileKey) {
        profiles.remove(profileKey);
        return "deleted " + profileKey;
    }


}
