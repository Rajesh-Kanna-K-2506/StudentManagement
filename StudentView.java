import java.util.Scanner;
class StudentView{
    Scanner sc = new Scanner(System.in);
    void showMenu(){
        System.out.println("\n--- Student Management Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Marks");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }
    int getChoice(){
        System.out.print("Enter choice: ");
        return sc.nextInt();
    }
    int getId(){
        System.out.print("Enter Student ID: ");
        return sc.nextInt();
    }
    String getName(){
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        return sc.nextLine();
    }
    int getMarks(){
        System.out.print("Enter Marks: ");
        return sc.nextInt();
    }
    void displayStudents(Student[] students, int count){
        System.out.println("\nStudent Records:");
        for(int i = 0; i < count; i++){
            System.out.println(
                    students[i].id + " - " +
                    students[i].name + " - " +
                    students[i].marks);
        }
    }
    void showMessage(String msg){
        System.out.println(msg);
    }
}