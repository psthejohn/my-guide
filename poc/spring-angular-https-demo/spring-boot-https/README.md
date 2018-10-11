the link for this guide is
	
	https://www.thomasvitale.com/https-spring-boot-ssl-certificate/

## Setting up HTTPS for Spring Boot requires two steps:

	Getting an SSL certificate;
	Configuring SSL in Spring Boot.

We can generate an SSL certificate ourselves (self-signed certificate). 
Its use is intended just for development and testing purposes. 
In production, you should use a certificate issued by a trusted Certificate Authority (CA).

#### Steps:

	1.Get an SSL certificate
		a.Generate a self-signed SSL certificate
		b.Use an existing SSL certificate
	2.Enable HTTPS in Spring Boot
	3.Redirect HTTP requests to HTTPS
	4.Distribute the SSL certificate to clients.

If you don’t already have a certificate, follow the step 1a. 
If you have already got an SSL certificate, you can follow the step 1b.

##### I’ll use the following technologies and tools:

	Java JDK 8
	Spring Boot
	keytool

Keytool is a certificate management utility provided together with the JDK, 
so if you have the JDK installed, you should already have keytool available.
To check it, try running the command keytool --help from your Terminal prompt. 


## 1a. Generate a self-signed SSL certificate

First of all, we need to generate a pair of cryptographic keys, used them to produce an SSL certificate and store it in a keystore. 
The keytool documentation defines a keystore as a database of “cryptographic keys, X.509 certificate chains, and trusted certificates”. 
To enable HTTPS, we’ll provide a Spring Boot application with this keystore containing the SSL certificate.

The two most common formats used for keystores are JKS, a proprietary format specific for Java, and PKCS12, an industry standard format. 
JKS used to be the default choice, but now Oracle recommends to adopt the PKCS12 format. I’ll show you how to use both.

#### Open your Terminal prompt and write the following command to create a JKS keystore:

	keytool -genkeypair -alias tomcat -keyalg RSA -keysize 2048 -keystore keystore.jks -validity 3650

#### If you want to create a PKCS12 keystore, and you should, the command is the following:

	keytool -genkeypair -alias tomcat -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -validity 3650

You then will be asked to enter a password for the keystore. It must have at least 6 characters.

Enter keystore password: 
Re-enter new password:

#### Finally, you will be asked to input some information, but you are free to skip all of it (just press Return to skip an option). In the place of the first and last name, you may want to insert the base name of your host (in my case it is localhost).

What is your first and last name?
  [Unknown]: localhost
What is the name of your organizational unit?
  [Unknown]: stackroute 
What is the name of your organization?
  [Unknown]:  stackroute
What is the name of your City or Locality?
  [Unknown]:  bangalore
What is the name of your State or Province?
  [Unknown]:  karnataka
What is the two-letter country code for this unit?
  [Unknown]:  91
Is CN=localhost, OU=Unknown, O=Unknown, L=Unknown, ST=Unknown, C=Unknown correct?
  [no]:  yes

Enter key password for <tomcat>
  (RETURN if same as keystore password):

At the end of this operation, we’ll get a keystore containing a brand new SSL certificate. To check the content of the keystore, we can use keytool again:

	keytool -list -v -keystore keystore.jks

To test the content of a keystore following the PKCS12 format, you can use the following command:

	keytool -list -v -storetype pkcs12 -keystore keystore.p12

If you have already created a JKS keystore and you want to migrate to PKCS12, keytool has a convenient command for that:

	keytool -importkeystore -srckeystore keystore.jks -destkeystore keystore.p12 -deststoretype pkcs12

## 1b. Use an existing SSL certificate

If you have already got an SSL certificate, you can import it into a keystore and use it to enable HTTPS in a Spring Boot application.

Using the following command, you’ll create a new keystore containing your certificate.

	keytool -import -alias tomcat -file myCertificate.crt -keystore keystore.p12 -storepass password

## 2. Enable HTTPS in Spring Boot

Whether your keystore contains a self-signed certificate or one issued by a trusted Certificate Authority, we can now set up Spring Boot to accept requests over HTTPS instead of HTTP by using that certificate.

The first thing to do is placing the keystore file inside the Spring Boot project. You may want to put it in the resources folder or the root folder.

All you need to do is open up your application.properties file (if you have an application.yaml file, it works in the same) and define the following properties:

# Define a custom port instead of the default 8080
server.port=8443

# Tell Spring Security (if used) to require requests over HTTPS
security.require-ssl=true

# The format used for the keystore 
server.ssl.key-store-type=PKCS12

# The path to the keystore containing the certificate
server.ssl.key-store=classpath:keystore.p12

# The password used to generate the certificate
server.ssl.key-store-password=password

# The alias mapped to the certificate
server.ssl.key-alias=tomcat

You can specify a custom port using the server.port property (by default it is 8080). If your project is using Spring Security, you should set the security.require-ssl property to true to automatically block any requests coming from HTTP, without explicitly touching your Spring Security configuration class.

The server.ssl.key-store-type property defines the format used for the keystore (either JKS or PKCS12) while the server.ssl.key-store property contains the path to the keystore file (either keystore.jks or keystore.p12). In this case, we want Spring Boot to look for it in the classpath.

	if its not working just find the keystore.p12 in your home directory and copy that in 
	resource folder . then run the program.

then in tomcat installation directory , in conf folder , server.xml
add this 

	<Connector port="8443" protocol="HTTP/1.1"
    		maxThreads="150" SSLEnabled="true" scheme="https" secure="true" 
         keystoreFile="keystore.p12" keystorePass="123456" clientAuth="false" sslProtocol="TLS">

also dont forget to add keystore.p12 in root tomcat directory
and comment 
	
	#server.ssl.key-alias=tomcat	 


For more information about how to configure SSL in Spring Boot, you can have a look at the 

	https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-configure-ssl
Reference Guide. 
If you want to find out which properties you can use to set SSL, you can refer to the definition.

Congratulations! You have successfully enabled HTTPS in your Spring Boot application! Give it a try: run the application, open your browser and check if everything works as it should.

## 3. Redirect HTTP requests to HTTPS

Now that we have enabled HTTPS in our Spring Boot application, we may want to redirect all traffic to HTTPS.

Spring allows defining just one network connector in the application.properties (or application.yaml) file. Since we have used it for HTTPS, we have to set the HTTP connector programmatically.

All we have to do is adding a new bean in a @Configuration class as shown in the following code.

	@Configuration
	public class ConnectorConfig {
	 
	 @Bean
	 public EmbeddedServletContainerFactory servletContainer() {
	 TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
	 @Override
	 protected void postProcessContext(Context context) {
	 SecurityConstraint securityConstraint = new SecurityConstraint();
	 securityConstraint.setUserConstraint("CONFIDENTIAL");
	 SecurityCollection collection = new SecurityCollection();
	 collection.addPattern("/*");
	 securityConstraint.addCollection(collection);
	 context.addConstraint(securityConstraint);
	 }
	 };
	 tomcat.addAdditionalTomcatConnectors(getHttpConnector());
	 return tomcat;
	 }
	 
	 private Connector getHttpConnector() {
	 Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	 connector.setScheme("http");
	 connector.setPort(8080);
	 connector.setSecure(false);
	 connector.setRedirectPort(8443);
	 return connector;
	 }
	}

## 4. Distribute the SSL certificate to clients

If you’re using a self-signed SSL certificate, your browser won’t trust your application and will warn the user that it’s not secure. And that’ll be the same no matter the client.

It’s possible to make a client trust your application by providing it with your certificate. Since you stored your certificate inside the keystore, you need to extract it. Again, keytool supports us very well:

	keytool -export -keystore keystore.jks -alias tomcat -file myCertificate.crt

To execute this command, keytool will ask you for the keystore password that you set at the beginning of this tutorial.

Now you can import your certificate into your client. In the next step, I’ll explain how to import the certificate into the JRE in case you need it to trust your application.

On the other hand, if you are using a keystore in PKCS12 format, you should be able to use it directly without extracting the certificate. I suggest you check the official guide on how to import a PKCS12 file into your browser. If you’re on macOS, you can directly import your certificate into the Keychain Access (which browsers like Safari, Chrome and Opera rely on to manage certificates).

If you deploy your application on your localhost, you may need to do a further step from your browser: enabling insecure connections with localhost. 
In Chrome, you do that by writing the following URL in the search bar: 

	chrome://flags/#allow-insecure-localhost 
and activating the relative option.

Import the certificate inside the JRE keystore
To make the JRE trust your certificate, you need to import it inside cacerts: the JRE keystore in charge of holding certificates.

To do that, you’ll need to know the path to your JDK home. A quick way to find it, if you are using Eclipse or STS as your IDE, is by going to Preferences > Java > Installed JREs. Here you can read information about your JDK location. If you are using IntelliJ IDEA, you can access this information by going to Project Structure > SDKs and look at the value of the JDK home path field. On macOS it could be something like /Library/Java/JavaVirtualMachines/jdk1.8.0_152.jdk/Contents/Home. In the following, we’ll refer to this location by using the placeholder $JDK_HOME.

From your Terminal prompt insert the following command (you might need to run it with administrator privileges by prefixing it with sudo):

	keytool -importcert -file myCertificate.crt -alias tomcat -keystore $JDK_HOME/jre/lib/security/cacerts
You’ll be asked to input the JRE keystore password. If you have never changed it, it should be the default one: changeit or changeme, depending on the operating system. Finally, keytool will ask if you want to trust this certificate: say yes.

If everything went right, you’d see the message Certificate was added to keystore.
