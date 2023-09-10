package PasswordStorageComponents;
import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Arrays;

public class SecureFileEncryptionWithAuthExample {
    private static final String KEY_ALIAS = "myEncryptionKey";
    private static final String KEYSTORE_PATH = "keystore.jks";
    private static final char[] KEYSTORE_PASSWORD = "keystorePass".toCharArray();
    private static final int TAG_LENGTH_BIT = 128;

    public static SecretKey generateAESKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // Using a 256-bit AES key
        return keyGen.generateKey();
    }

    public static void encryptFile(File inputFile, File encryptedFile, SecretKey secretKey) throws
            NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[12];
        random.nextBytes(iv);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_LENGTH_BIT, iv);
    //    cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(encryptedFile);
             CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                cipherOutputStream.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void decryptFile(File encryptedFile, File decryptedFile, SecretKey secretKey) throws
            NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
        try (FileInputStream inputStream = new FileInputStream(encryptedFile);
             FileOutputStream outputStream = new FileOutputStream(decryptedFile)) {

            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_LENGTH_BIT, new byte[12]);
          //  cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(cipher.update(buffer, 0, bytesRead));
            }
          //  outputStream.write(cipher.doFinal());
        }
    }

    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        FileInputStream keyStoreInputStream = new FileInputStream(KEYSTORE_PATH);
        keyStore.load(keyStoreInputStream, KEYSTORE_PASSWORD);

        KeyStore.SecretKeyEntry secretKeyEntry = (KeyStore.SecretKeyEntry) keyStore.getEntry(KEY_ALIAS, new KeyStore.PasswordProtection(KEYSTORE_PASSWORD));
        SecretKey secretKey = secretKeyEntry.getSecretKey();

        Console console = System.console();
        char[] password = console.readPassword("Enter decryption password: ");

        if (Arrays.equals(KEYSTORE_PASSWORD, password)) {
            File encryptedFile = new File("encrypted_passwords.enc");
            File decryptedFile = new File("decrypted_passwords.txt");

            decryptFile(encryptedFile, decryptedFile, secretKey);

            System.out.println("File decrypted successfully.");
        } else {
            System.out.println("Invalid password.");
        }
    }
}
