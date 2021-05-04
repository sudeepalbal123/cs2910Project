FROM java:8
ADD FileStoreMongo.java FileStoreMongo.java
COPY /dependencies /dependencies
RUN javac -cp '/dependencies/*' FileStoreMongo.java
