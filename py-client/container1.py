import docker
import os
import time

client = docker.from_env()

print("---------Current Containers-----------")
for c in client.containers.list():
    print(c)


client.images.build(path = "./",tag = 'writer',rm = True)


print('image build done')

print('Container1 starting')

start_time = time.time()

container1 = client.containers.run('writer',volumes = {r"C:\Users\sudeep\OneDrive - University of Pittsburgh\Desktop\py-client"
                                                     :{'bind':"/data",'mode':"rw"}})

print('Container1 finished')

print("---------Current Containers-----------")
for c in client.containers.list():
    print(c)

if(os.path.isfile('filename.txt')):
    os.chdir(r"C:\Users\sudeep\OneDrive - University of Pittsburgh\Desktop\py-client\reader")
    client.images.build(path = "./",tag = 'reader',rm = True)
    print('Starting container2')
    os.chdir(r"C:\Users\sudeep\OneDrive - University of Pittsburgh\Desktop\py-client")

    container2 = client.containers.run('reader',detach = True,stdout = True, stderr = True,volumes = {r"C:\Users\sudeep\OneDrive - University of Pittsburgh\Desktop\py-client"
                                                     :{'bind':"/data",'mode':"rw"}})
    print("---------Current Containers-----------")
    for c in client.containers.list():
        print(c)
        
    for line in container2.logs(stream=True):
        print(line.strip())
    
    #print(type(container2.logs()))
    
    container2.stop();
    print('Container2 stopped after reading the file')
    
    print('Execution time is:',time.time() - start_time)
else:
    print('No need to start container2')
    
print("---------Current Containers-----------")
for c in client.containers.list():
    print(c)




