# Workshop4

Integrate microservice app-pay to:
- Consul
- Modify LoadBalancer to support path /pay pointing to app-pay microservice 
- Modify API GW to support redirect to app-pay microservice

#CONSUL IMPLEMENTATION:

First we change the Application.properties of app-config as follows:
 
![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/cc78b210-2282-42c0-8bdb-c6fa0745c636)
![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/f5249970-6af0-4957-90f1-cfbfb26550c7)

 
Then we add the corresponding dependencies to the Build.gradle, cloud-starter-consul-discovery:

![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/229d703f-a5ef-41da-9162-bc3d4ffb38ac)

 
The above dependency is added in all projects:

![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/40c0b95e-91bb-4a61-81a2-764ca841307a)


In addition, we add the starter actuator dependency to all applications except app-config. 

![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/f396e05f-b224-46d8-beb7-5b35ccabbdcb)

 
We make sure that the configuration of the applications is as follows:

![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/cf3ecfd5-0bdf-44ad-86ea-3a7f5ef8dd54)

 
Now, let's install dnsmasq:

![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/06f8d80f-26e5-46d6-90b0-793971df8b2c)

 
We open the address /etc/dnsmasq.d/ and create a configuration file in which we will do the following:
 
![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/dcca9ba4-1217-4897-be2e-03bcbc569ea3)

 
Then we must restart the dnsmasq service:

![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/af2d1453-3957-4ea9-8e4e-49dc3071a389)


We go back in the directory to find the resolv.conf file so that we can add a new nameserver to it:

![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/329ddc0b-da6d-4d01-a3ce-4b45ecf845ca)

 
At this point, we run the consul image as follows:

![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/90be008b-f309-4da1-be4d-f3ec269663fc)

 
Now we test if the service is running correctly:

![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/058c964a-4e53-4beb-831d-e69a25a8818f)

 
Having consul running correctly, we can build all the images and run them as the following images:

 ![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/b254e818-d053-4131-9cb4-da18710209b0)
![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/2baa0aa0-f4d9-400e-b741-243dd5e69f20)

Here we verify in the consul interface that indeed, all the applications are running correctly:

![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/7f81a6c2-4989-429c-acd4-33e7a67820ef)

  
Finally we must upload the changes to Dockerhub regarding the new images:
![image](https://github.com/SGutierrez-11/sd-workshop4/assets/69949511/472ed7c9-5d5b-45d7-99d1-ef323663d931)

