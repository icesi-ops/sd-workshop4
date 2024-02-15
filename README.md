
# <b> *Workshop 4* </b>



## <b> STEPS </b> 📄

- *git clone* https://github.com/icesi-ops/training_microservices.git

- sudo su

- systemctl stop systemd-resolved

- systemctl disable systemd-resolved

- cd /

- sudo vim /etc/resolv.conf

- edit file with nameserver=127.0.0.1

- cd dnsmasq.d

- sudo vim 10-consul

-  edit with server=/consul/127.0.0.1#8600

- sudo systemctl restart dnsmasq

- dig app-config.service.consul

- dig app-invoice.service.consul

- dig app-pay.service.consul

- dig app-transaction.service.consul






<br>

