# sd-workshop4

# <b> *Training Microservices* </b>



## <b> STEPS </b> 📄

dnsmasq Installation and Port 53 Issue Resolution
If you encounter a problem with port 53, as depicted in the image, it likely stems from a conflict because systemd-resolved also manages DNS resolutions and listens on port 53. This can lead to conflicts when both dnsmasq and systemd-resolved are running simultaneously.

To address this issue, follow these steps:

Stop the systemd-resolved service using the following commands:


-sudo systemctl stop systemd-resolved
-sudo systemctl disable systemd-resolved
Next, modify the resolv.conf file using the Vim editor. This file configures the DNS server in the local environment. Change the nameserver line to point locally, specifically to 127.0.0.1.

Navigate to the dnsmasq directory and edit the configuration file dnsmasq.d. Add a file named 10-consul. This file is used to define how the names of services registered in Consul will be resolved. In this file, add the line:


-server=/consul/127.0.0.1#8600
This redirects DNS requests for the consul domain to the local DNS server at IP address 127.0.0.1 with port 8600.

Restart dnsmasq and check its status.

After completing these steps, you can verify the setup by running the following commands:


-dig app-config.service.consul
-dig app-invoice.service.consul
-dig app-pay.service.consul
-dig app-transaction.service.consul


## <b> Built with </b> 🛠


+ [Docker](https://www.docker.com/) - Docker is an open platform for developing, shipping, and running applications.


## **Versioned** 📌

<div style="text-align: left">
    <a href="https://git-scm.com/" target="_blank"> <img src="https://raw.githubusercontent.com/devicons/devicon/2ae2a900d2f041da66e950e4d48052658d850630/icons/git/git-original.svg" height="60" width = "60" alt="Git"></a> 
    <a href="https://github.com/" target="_blank"> <img src="https://img.icons8.com/fluency-systems-filled/344/ffffff/github.png" height="60" width = "60" alt="GitHub"></a>
</div>


## <b> Overview </b> 💻🕹



<br></br>

![image](https://github.com/icesi-ops/training_IaC/assets/69222739/c387a2d2-cd10-4363-9914-bf249926b191)



## <b> Made by </b>


+ [Camilo González Velasco](https://github.com/camilogonzalez7424 "Camilo G.")
+ [Icesi-Ops](https://github.com/icesi-ops")




<br>



[![forthebadge](https://forthebadge.com/images/badges/docker-container.png)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)

