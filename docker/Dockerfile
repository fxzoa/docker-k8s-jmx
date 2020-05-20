FROM fxzoa/api-base

WORKDIR /app

ARG jar_path=build/libs/demo-1.0.0.jar
COPY ${jar_path} ${jar_path}
RUN echo "jarPath: ${jar_path}"

ENV APP_JAR=${jar_path}

COPY endpoint.sh endpoint.sh
RUN chmod 775 endpoint.sh

EXPOSE 8080
EXPOSE 9010

ENTRYPOINT ["./endpoint.sh"]
