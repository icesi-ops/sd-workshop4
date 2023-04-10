# Workshop4

Realizar la integración de Consul con un balanceador de carga para la automatización de la creación de plantillas.

## Entrega Juan Fernando Angulo

Tenemos un Vagranfile con 4 máquinas, un reverse proxy de nginx, un balanceador de carga y dos servidores web.<br>
El balanceador de carga actuará como el consul-server, mientras que los servidores web serán los consul-agent.<br>

Para la instalación de Consul dentro de las máquinas se usaron inline shells dentro del Vagrantfile, y para la configuración del onsul-server y los consul-agent se escribieron playbooks separados de Ansible.

### Loadbalancer:
```bash
lb.vm.provision "shell", inline: <<-SHELL
  yum install -y unzip
  yum install -y wget
  wget https://releases.hashicorp.com/consul-template/0.30.0/consul-template_0.30.0_linux_amd64.zip -P /tmp 
  unzip /tmp/consul-template_0.30.0_linux_amd64.zip -d /tmp
  mv /tmp/consul-template /usr/bin
  mkdir /etc/consul-template
SHELL

lb.vm.provision "shell", inline: <<-SHELL
  wget https://releases.hashicorp.com/consul/1.15.1/consul_1.15.1_linux_amd64.zip -P /tmp
  unzip /tmp/consul_1.15.1_linux_amd64.zip -d /tmp
  mv /tmp/consul /usr/bin
  mkdir /etc/consul.d
  mkdir -p /etc/consul/data
SHELL
```
Y su playbook está en `playbooks/consul/consul_server.yml`

### Webservers:
```bash
web.vm.provision "shell", inline: <<-SHELL
  yum install -y unzip
  yum install -y wget
  wget https://releases.hashicorp.com/consul/1.15.1/consul_1.15.1_linux_amd64.zip -P /tmp
  unzip /tmp/consul_1.15.1_linux_amd64.zip -d /tmp
  mv /tmp/consul /usr/bin
  mkdir /etc/consul.d
  mkdir -p /etc/consul/data
SHELL
```
Y su playbook está en `playbooks/consul/consul_agent.yml`

## Ejecución:
Para correr el workshop solo hay que ejecutar el comando `vagrant up`.

## Evidencia:
### Load balancer:
![image](https://user-images.githubusercontent.com/54970187/231011960-04015544-fdea-4d6e-993a-9a6a707b2926.png)

### Web-1:
![image](https://user-images.githubusercontent.com/54970187/231012818-b21f6a6f-e419-42b0-a803-575dc19c43fb.png)

### Web-2:
![image](https://user-images.githubusercontent.com/54970187/231012901-66e5adbd-ba79-47fe-9469-16fb10cfd253.png)

Y al hacer `consul members` en el loadbalancer:
![image](https://user-images.githubusercontent.com/54970187/231013082-8893e82e-4c2a-4e8b-85b6-2dd97c6ff761.png)



