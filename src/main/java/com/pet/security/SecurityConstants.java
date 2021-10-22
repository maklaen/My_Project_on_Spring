package com.pet.security;

public class SecurityConstants {

    public static final String SIGN_UP_URL = "/api/auth/*";
    public static final String ANONIM = "/anonim/*";
    public static final String ADMIN_URL = "/admin/*";
    public static final String SECRET = "OJHnjgfio8889hfpudsifher4t5545641b46sby164h86b4h548j1chgivbpdih";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String CONTENT_TYPE = "application/json";
    public static final long EXPIRATION_TIME = 600_000; //10min

}
