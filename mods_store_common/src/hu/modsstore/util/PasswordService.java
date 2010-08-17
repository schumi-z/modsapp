package hu.modsstore.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import sun.misc.BASE64Encoder;

public final class PasswordService {

	private static final int SALT_LENGTH = 8;
	private static final String ALLOWED_SALT_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

	public PasswordService() {
	}

	/**
	 * * Generates a random String that can be used as a password salt. * @return
	 * a random String of length 8 using only alphanumeric characters.
	 */
	public final String generateSalt() {
		final SecureRandom random = new SecureRandom();
		final StringBuilder salt = new StringBuilder();
		for (int i = 0; i < SALT_LENGTH; i++) {
			salt.append(ALLOWED_SALT_CHARS.charAt(random
					.nextInt(ALLOWED_SALT_CHARS.length())));
		}
		return salt.toString();
	}

	/**
	 * * Encrypts the given plaintext password, using the given salt. The
	 * encrypted form is * a message digest generated with the SHA-1 algorithm,
	 * and rendered in String format using Base-64 * encoding. * * @param
	 * plaintext password to encrypt * @param salt salt to add to password to
	 * ensure encryption is secure * @return encrypted password * @throws
	 * NullPointerException if either plaintext or salt are null
	 */
	public final String encrypt(final String plaintext, final String salt) {
		if (plaintext == null) {
			throw new NullPointerException();
		}
		if (salt == null) {
			throw new NullPointerException();
		}

		try {
			final MessageDigest md = MessageDigest.getInstance("SHA");
			md.update((plaintext + salt).getBytes("UTF-8"));
			return new BASE64Encoder().encode(md.digest());
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptionException(e);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptionException(e);
		}
	}
	
	public final String decode(final String plaintext, final String salt) {
		return null;
	}

	

}