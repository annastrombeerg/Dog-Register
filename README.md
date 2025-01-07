The `Dog Register` program is a Java-based system designed to manage a registry of dogs and their owners. It provides various functions to add, remove, and update information about dogs and owners, as well as to list and sort them. 
This program was done as a part of a Java-course.

If you want to compile the program you are going to "run" the DogRegister.java-file. 
Here’s a summary of what the program does:

### Key Functions:
1. **Register New Dog**  
   Users can add a new dog by entering its name, breed, age, and weight.

2. **List Dogs**  
   The program lists all registered dogs with a tail length above a specified value. The dogs are sorted by tail length (ascending), and if the tail lengths are the same, they are sorted alphabetically by name.

3. **Increase Dog’s Age**  
   Users can increase the age of a specific dog by one year.

4. **Remove Dog from Register**  
   A dog can be removed by specifying its name.

5. **Register New Owner**  
   Users can add a new owner by entering their name.

6. **Give a Dog to an Owner**  
   A dog can be assigned to an owner, provided the dog does not already have one.

7. **List Owners**  
   The program lists all owners along with the dogs they own.

8. **Remove Owned Dog**  
   Users can remove a dog that already has an owner.

9. **Remove Owner**  
   Owners can be removed from the register. Any dogs owned by that person are also removed from the system.

10. **Exit Program**  
   The program runs continuously until the user chooses to exit by entering the "exit" command.

### Technical Details:
- **Data Storage**: Two lists (`ArrayList`) are used to store dogs and owners.
- **Sorting and Filtering**: Dogs are sorted based on tail length and name, using a custom comparison method.
- **Error Handling**: The program provides clear error messages if, for example, dogs or owners cannot be found, or if input is invalid.

### Purpose:
The program serves as a simple registry system to manage and organize information about dogs and their owners. It could be useful for dog clubs, kennels, or similar organizations.
