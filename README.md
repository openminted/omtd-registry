# omtd-registry

## Maven

### Build

Built with `mvn clean install package`. Add the the download latest snapshots with `-U` flag if in development

## Properties

The properties that need to be configured to point to the correct services.

The configuration file that overrides the `application.properties` needs to be found in the classpath of the application.

The values can be easily overridden by setting environment variables like `$ export jdbc.username=admin` for example.  
```properties

jdbc.url = jdbc:postgresql://{{db}}:5432/registry
jdbc.username = {{username}}
jdbc.password = {{password}}

elasticsearch.url = {{elastic}}
elasticsearch.port = 9300

oidc.issuer = https://aai.openminted.eu/oidc/
oidc.id = {{id}}
oidc.secret = {{secret}}

jms.host = tcp://{{jms}}:61616
jms.prefix = registry

services.store.ip = {{store}}
```

## Docker 

1. Build the docker with `docker build . -t omtd-registry`
2. Tag the image docker with another more useful tag with `docker tag omtd-registry <new_tag_name>`
    - Tag the image `with <docker_registry_host>:<port>/omtd-registry` to use it across multiple docker machines.
3. Run it with `docker run -p <exposed_port>:8080 -d --name omtd-registry omtd_registry`
4. Deploy it to a docker swarm with `docker service create --publish <publish_port>:8080 --name omtd-registry <docker_registry_host>:<port>/omtd-registry`. This requires the image to be pushed in a registry.

### Add insecure registry


1. Create a new docker registry

    ```bash
    docker run -d -p 5000:5000 --restart=always --name registry \
    -v `pwd`/data:/var/lib/registry \
    registry:2
    ```

2. Add/Modify the following json file `/etc/docker/daemon.json` with the proper values to each docker machine.

    ```json
    {
        "insecure-registries" : ["{{registry_host}}:{{registry:port}}"]
    }
    ```
