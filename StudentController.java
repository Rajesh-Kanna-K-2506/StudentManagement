import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class StudentController {

    // ADD STUDENT
    void addStudent(int id, String name, int marks) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                "INSERT INTO students VALUES (?, ?, ?)";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, marks);

            ps.executeUpdate();

            System.out.println("Student Added Successfully");

            con.close();
        }
        catch(Exception e) {

            System.out.println(e);
        }
    }

    // DISPLAY STUDENTS
    void displayStudents() {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs =
                st.executeQuery("SELECT * FROM students");

            System.out.println("\nStudent Records:");

            while(rs.next()) {

                System.out.println(
                    rs.getInt(1) + " - " +
                    rs.getString(2) + " - " +
                    rs.getInt(3)
                );
            }

            con.close();
        }
        catch(Exception e) {

            System.out.println(e);
        }
    }

    // SEARCH STUDENT
    void searchStudent(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                "SELECT * FROM students WHERE id=?";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                System.out.println(
                    rs.getInt(1) + " - " +
                    rs.getString(2) + " - " +
                    rs.getInt(3)
                );
            }
            else {

                System.out.println("Student Not Found");
            }

            con.close();
        }
        catch(Exception e) {

            System.out.println(e);
        }
    }

    // UPDATE MARKS
    void updateMarks(int id, int marks) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                "UPDATE students SET marks=? WHERE id=?";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setInt(1, marks);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Marks Updated");
            else
                System.out.println("Student Not Found");

            con.close();
        }
        catch(Exception e) {

            System.out.println(e);
        }
    }

    // DELETE STUDENT
    void deleteStudent(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
                "DELETE FROM students WHERE id=?";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Student Deleted");
            else
                System.out.println("Student Not Found");

            con.close();
        }
        catch(Exception e) {

            System.out.println(e);
        }
    }
}