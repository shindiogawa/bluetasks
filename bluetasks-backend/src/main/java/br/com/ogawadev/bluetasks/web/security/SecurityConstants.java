package br.com.ogawadev.bluetasks.web.security;

public class SecurityConstants {
	
	public static final long EXPIRATION_TIME = 86400000; // 1 dia
	public static final String SECRET_KEY = "tHeSeCrEtKeY";
	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";
}
