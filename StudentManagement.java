public class StudentManagement {

    public static void main(String[] args) {

        StudentController controller =
            new StudentController();

        StudentView view =
            new StudentView();

        while(true) {

            view.showMenu();

            int choice = view.getChoice();

            switch(choice) {

                case 1:

                    int id = view.getId();
                    String name = view.getName();
                    int marks = view.getMarks();

                    controller.addStudent(id, name, marks);

                    break;

                case 2:

                    controller.displayStudents();

                    break;

                case 3:

                    int searchId = view.getId();

                    controller.searchStudent(searchId);

                    break;

                case 4:

                    int updateId = view.getId();
                    int newMarks = view.getMarks();

                    controller.updateMarks(updateId, newMarks);

                    break;

                case 5:

                    int deleteId = view.getId();

                    controller.deleteStudent(deleteId);

                    break;

                case 6:

                    System.out.println("Exiting...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}