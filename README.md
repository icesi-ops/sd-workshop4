# Workshop4

By: Samuel Guerrero

## Integrate microservices with consul:

---

1. Run Consul microservice with.
```
docker run -d -p 8500:8500 -p 8600:8600/udp --network distribuidos --name consul consul:1.15 agent -server -bootstrap-expect 1 -ui -data-dir /tmp -client=0.0.0.0
```
2. Install dnsmasq and configure to include the following path in the configuration file:

```
server=/consul/127.0.0.1#8600
```

3. Modify resolv.conf to add ip loopback as DNS resolver.
4. Modify microservice app-config to provide configuration files from a own repository.
5. Modify the configuration files from the own repository to include the following configuration for all 3 microservices:
```
# Consul
spring.cloud.consul.host=consul
spring.cloud.consul.port=8500
spring.cloud.consul.discovery.health-check-interval=5s
spring.cloud.consul.discovery.prefer-ip-address=true
```
7. Add the following dependencies for the 3 other microservices:
```
implementation 'org.springframework.cloud:spring-cloud-starter-consul-discovery'
implementation 'org.springframework.boot:spring-boot-starter-actuator'
```
8. Run all the microservices, databases and Kafka in the correct order.

## Evidence

![Consul](/assets/todo.png)
![Consul](/assets/consul.png)
![Consul](/assets/config.png)
![Consul](/assets/invoice.png)
![Consul](/assets/pay.png)
![Consul](/assets/transaction.png)
