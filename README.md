# Workshop4

Realizar la integración de Consul con un balanceador de carga para la automatización de la creación de plantillas.

## Entrega Juan Fernando Angulo

Tenemos un Vagranfile con 4 máquinas, un reverse proxy de nginx, un balanceador de carga y dos servidores web.\n
El balanceador de carga actuará como el consul-server, mientras que los servidores web serán los consul-agent.



Para la instalación de Consul dentro de las máquinas se usaron inline shells dentro del Vagrantfile, y para la configuración del onsul-server y los consul-agent se escribieron playbooks separados de Ansible.



Para correr el workshop solo hay que ejecutar el comando `vagrant up`.
