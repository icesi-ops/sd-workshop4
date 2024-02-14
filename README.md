# Workshop 4

In this micro-workshop, the `consul` service was enabled, and the `dns` service was configured with `dnsmasq` to obtain a reverse DNS that resolves the domains of the microservices registered on the consul server.

## Microservices registered in Consul
![alt text](/images/image_consul.png)

## Active and functioning DNS with dnsmasq
![alt text](/images/image_dnsmasq.png)

## Active and functioning DNS with dnsmasq
The command `dig` resolves the DNS of each of the services.

`App-Config and App-Invoice`
![alt text](/images/image_dns_resolve1.png)

`App-Pay and App-Transaction`
![alt text](/images/image_dns_resolve2.png)