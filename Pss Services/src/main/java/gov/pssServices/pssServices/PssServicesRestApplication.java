package gov.pssServices.pssServices;

import io.helidon.microprofile.server.Server;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;


/**
 *
 */
@ApplicationPath("/pss/v1.0/")
@ApplicationScoped
public class PssServicesRestApplication extends Application {
    public PssServicesRestApplication(){}

    public static void main(final String[] args) throws IOException {




        Server server = startServer();
        System.out.println("http://localhost:" + server.port());
    }
    static Server startServer() {
        return Server.create().start();
    }

}
