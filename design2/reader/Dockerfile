FROM java:8
ADD ReadFromMongo.java ReadFromMongo.java
COPY /dependencies /dependencies
RUN javac -cp '/dependencies/*' ReadFromMongo.java
RUN java -cp '.:/dependencies/*' ReadFromMongo file1.txt
