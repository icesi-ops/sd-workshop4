FROM ubuntu:14.04

RUN apt-get update && apt-get upgrade -y
RUN apt-get install -y apache2
RUN echo "ServerName localhost" >> /etc/apache2/apache2.conf
RUN apt-get install -y wget
RUN rm /var/www/html/index.html
WORKDIR /var/www/html

RUN wget -O index.html www.javeriana.edu.co/inicio

EXPOSE 80
CMD ["-D","FOREGROUND"]
ENTRYPOINT ["/usr/sbin/apache2ctl"]
