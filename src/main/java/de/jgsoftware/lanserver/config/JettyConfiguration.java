package de.jgsoftware.lanserver.config;



import org.eclipse.jetty.http3.server.HTTP3ServerConnector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.ssl.DefaultSslBundleRegistry;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Configuration;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.http3.server.HTTP3ServerConnectionFactory;

@Configuration
public class JettyConfiguration {
        //implements WebServerFactoryCustomizer<JettyServletWebServerFactory> {

    //@Autowired
    //private DefaultSslBundleRegistry defaultSslBundleRegistry;

    @Value("${server.port}")
    private Integer serverPort;

    JettyServerCustomizer jettyServerCustomizer;
  
    

    public JettyConfiguration()
    {
          org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server();
        try {
            customize();
            server.start();
           
        } catch (Exception ex) {
            System.getLogger(JettyConfiguration.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
       
        
    }
    
    
    public void customize() {

        jettyServerCustomizer = new JettyServerCustomizer() 
        {
            @Override
            public void customize(Server server) 
            {
                //var keyStore = defaultSslBundleRegistry.getBundle("server").getStores().getKeyStore();

                
                SslContextFactory.Server sslContextFactory = new SslContextFactory.Server();
                //sslContextFactory.setKeyStore(keyStore);
                //sslContextFactory.setKeyStorePassword(""); // Must be set for Jetty

                HttpConfiguration httpConfig = new HttpConfiguration();
                httpConfig.addCustomizer(new SecureRequestCustomizer());
                //httpConfig.setIdleTimeout(idleTimeout);

                HTTP3ServerConnector connector = new HTTP3ServerConnector(server, sslContextFactory, new HTTP3ServerConnectionFactory(httpConfig));
                //connector.getQuicConfiguration().setPemWorkDirectory( // Must be set for Jetty
                //        Paths.get(System.getProperty("java.io.tmpdir"))); // Default system temp directory

                System.out.print("Jetty HTTP3ServerConnector" + " on port" + serverPort + "\n");
                
                
                connector.setPort(serverPort);
                server.addConnector(connector);
                
            }
        };

        //factory.addServerCustomizers(jettyServerCustomizer);
    }
    
  
}
