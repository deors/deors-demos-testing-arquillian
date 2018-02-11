# deors-demos-testing-arquillian

Demonstration of Java in-container tests with Arquillian, showing configuration options for popular containers (Weld, Tomcat, GlassFish, JBoss, WildFly).

In general, for each container there are three possible profiles one for each type of container management approach - managed, on-demand and remote - and for some of them (Glassfish-Weld, Tomcat) also exist a fourth approach - embedded:

* _Managed_: The container runtime exists locally, in a given folder, and Arquillian will manage its lifecycle, including start, stop and deployments.

* _On-demand_: The container runtime is not installed, and is downloaded and unzipped by maven-dependency-plugin before being used by Arquillian as a managed container.

* _Remote_: The container runtime exists remotely, in a different computer, and Arquillian will manage its lifecycle, including start, stop and deployments.

* _Embedded_: The container runtime runs in the same JVM process, and is provisioned as Maven
dependencies before Arquillian runs the tests.
