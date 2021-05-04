# CS 2910 Project

## Building Docker Images

`docker build -t [IMAGE_NAME] .`

## Run Docker Images

### Run with Bind Point

`docker run --name [CONTAINER_NAME] -it -v [HOST_DIR]:[CONTAINER_DIR] [IMAGE_NAME]`

### Run without Bind Point

`docker run --name [CONTAINER_NAME]`

### Run With Network and Network Alias

`docker run --network-alias [ALIAS_NAME] -network [NETWORK_NAME] -it [IMAGE_NAME]`

### Run with Network but without Network Alias

`docker run --network [NETWORK_NAME] -it [IMAGE_NAME]`

## Running Design 1

### Run Reader

1. Download the Design1 Sub Directory.
2. We need to run the program in reader first as it is a Server.
3. Create a docker network as mentioned above
4. Use the docker build command as mentioned above once inside the reader sub directory.
5. Once the image is build run the docker run command with  network alias option
6. Reader program will execute and show waiting for connection message
7. Now we will run the sender program. Program will fail without filename.txt in sender directory. 
8. Build the docker image using docker build command as mentioned above.
9. Run the program using docker run command.

## Running Design 2

1. Download the Design2 Sub Directory.
2. Run the writer program first as it reads the text file and writes it to MongoDB.
3. First go to writer folder and build the docker image using build image command mentioned above.
4. Use the docker run command with additional input parameters mentioned above
5. Now we can run reader program. Go to reader folder build the docker image and execute it using docker run command with additional options.



## Running Design 3

1. Download the py-client folder.
2. Then just run container1.py file. 