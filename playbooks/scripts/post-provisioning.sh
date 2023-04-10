#!/bin/bash

if [ $(vagrant status | grep "not created" | wc -l) -ge 1 ]
then
  echo "[!] Aún no están corriendo ni han sido provisionadas todas la maquinas"
else
  echo -e "[+] Todas las maquinas han sido provisionadas y están corriendo\n\nEjecutando playbook para configurar el consul-template..."
  # Ejecutar playbook consul-template.yml
  ansible-playbook -v playbooks/consul/consul_template.yml
  echo -e "\n\n[+] Script de post-provisionamiento ejecutado correctamente :)"
fi
