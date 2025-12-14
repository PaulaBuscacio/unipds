package net.buscacio;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

// se quiser usar um application path, o que eh diferente do context path
@ApplicationPath("/api")
public class ApplicationDefault extends Application {
}
