# Workshop4

Presented by: Daniel Jaraba

Integrate microservices to:

- Consul

---

## Steps:

1. Run Consul microservice and check if is running.
2. Install dnsmasq and configure to include the following path in the configuration file:

```
server=/consul/127.0.0.1#8600
```

3. Modify resolv.conf to add ip loopback as DNS resolver.
4. Modify microservice app-config to provide configuration files from a own repository.
5. Modify the configuration files from the own repository to include the following configuration for all microservices:
```
# Consul
spring.cloud.consul.host=consul
spring.cloud.consul.port=8500
spring.cloud.consul.discovery.health-check-interval=5s
spring.cloud.consul.discovery.prefer-ip-address=true
```
7. Add the following dependencies for the microservices app-invoice, app-pay, app-transaction:
```
implementation 'org.springframework.cloud:spring-cloud-starter-consul-discovery'
implementation 'org.springframework.boot:spring-boot-starter-actuator'
```
8. Run all the microservices, databases and Kafka in the correct order.

## Proofs:

![Consul](/assets/consul.png)
![App Config](/assets/app-config.png)
![App Pay](/assets/app-pay.png)
![App Transaction](/assets/app-transaction.png)
![App Invoice](/assets/app-invoice.png)

