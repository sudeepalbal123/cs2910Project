# Do some operation and write the results to output_file for container 2

input_file = open("filename.txt","r")
output_file = open("out.txt","w+")

print("Reading and writing file linewise for next container")

# Itearte the file line wise
while True:
    line = input_file.readline()
    print(type(line))
    if not line:
        break
    
    output_file.write(line)
    output_file.write("\n")

input_file.close()
output_file.close()

# File creted now trigger the container

print("File out.txt is created for next container")
    

