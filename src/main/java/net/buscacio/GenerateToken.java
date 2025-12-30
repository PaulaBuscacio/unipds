package net.buscacio;

import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;

// Classe utilitaria para gerar tokens JWT para testes
public class GenerateToken {
  static void main() throws IOException {

    try (InputStream is = GenerateToken.class.getResourceAsStream("/privateKey.pem")) {
      if (is == null) {
        throw new IllegalStateException("Coloque privateKey.pem em src/main/resources");
      }

      byte[] bytes = is.readAllBytes();
      String pem = new String(bytes, StandardCharsets.UTF_8).trim();

      System.setProperty("smallrye.jwt.sign.key", pem);
      String token = Jwt.issuer("https://quarkus.io/using-jwt-rbac")
          .upn("jdoe@quarkus.io")
          .preferredUserName("jdoe")
          .groups(new HashSet<>(Arrays.asList("Subscriber","User", "Admin")))
          .claim(Claims.birthdate.name(), "2001-07-13")
          .sign();
      System.out.println(token);
      System.exit(0);
    }
  }
}
