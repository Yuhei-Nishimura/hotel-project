package com.example.hotelproject.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Value;

public class Singleton {
    @Value("${cloudinary.cloud_name}")
    private static String cloudName;

    @Value("${cloudinary.api_key}")
    private static String apiKey;

    @Value("${cloudinary.api_secret}")
    private static String apiSecret;

    private static Cloudinary cloudinary;

    public static void registerCloudinary(Cloudinary cloudinary) {
        Singleton.cloudinary = cloudinary;
    }

    public static void deregisterCloudinary() {
        cloudinary = null;
    }

    private static class DefaultCloudinaryHolder {
        public static final Cloudinary INSTANCE = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dvawvwy0u",
            "api_key", "262494797475916",
            "api_secret", "95_39LxVj1MBj9TKleoO56_UWC4"
        ));
    }

    public static Cloudinary getCloudinary() {
        if (cloudinary == null) {
            return DefaultCloudinaryHolder.INSTANCE;
        }
        return cloudinary;
    }
}