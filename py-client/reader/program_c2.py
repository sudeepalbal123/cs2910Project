# Read the file created by first container

input_file = open("out.txt","r")
output_file = open("output.txt","w+")


# Read the file and count the unique letters from that file
while True:
    line = input_file.readline()
    
    if not line:
        break
    
    output_file.write(line)
    output_file.write("\n")
    

