FROM httpd:alpine 

RUN mkdir /usr/share/git
RUN apk update && apk upgrade && apk add git git-gitweb
COPY apacheGitServer.xml  /usr/local/apache2/conf/
RUN cat /usr/local/apache2/conf/apacheGitServer.xml >> /usr/local/apache2/conf/httpd.conf
#RUN a2enmod cgi env alias

COPY DynamicDockerTesting.git /usr/share/git/DynamicDockerTesting.git


