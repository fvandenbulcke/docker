FROM mariadb:latest

ENV MYSQL_ROOT_PASSWORD library

COPY init-tab.sql ./docker-entrypoint-initdb.d/init-tab.sql

# Remove the temporary folders
RUN rm -f ./scripts_sql/init-tab.sql