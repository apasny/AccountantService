FROM openjdk:16
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
RUN javac AccountantServiceRestApplication.java
CMD ["java", "AccountantServiceRestApplication"]