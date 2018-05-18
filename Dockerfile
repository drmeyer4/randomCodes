FROM httpd:alpine 

RUN mkdir -p /usr/local/apache2/git
RUN apk update && apk upgrade && apk add git git-gitweb apache2-utils apache2
COPY apacheGitServer.xml  /usr/local/apache2/
RUN cat /usr/local/apache2/apacheGitServer.xml >> /usr/local/apache2/conf/httpd.conf
RUN sed -i '/LoadModule alias_module modules\/mod_alias.so/aLoadModule cgi_module modules/mod_cgi.so' /usr/local/apache2/conf/httpd.conf
RUN chown -R apache:apache /usr/local/apache2/git


