import com.studentmanage.Student;
import com.studentmanage.StudentDataAccessObjectClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {

        System.out.println("Welcome to Students Management App");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("Press 1 for add student");
            System.out.println("Press 2 for delete student");
            System.out.println("Press 3 for display student");
            System.out.println("Press 4 for update student");
            System.out.println("Enter 5 for exit ");
            int c = Integer.parseInt(br.readLine());
            int userId =0;
            if (c == 1) {
                //adding student
                System.out.println("Enter user name :");
                String name = br.readLine();

                System.out.println("Enter user phone : ");
                String phone = br.readLine();

                System.out.println("Enter user city : ");
                String city = br.readLine();

                Student st = new Student(name, phone, city);
                boolean answer = StudentDataAccessObjectClass.insertStudentToDB(st);
                if (answer) {
                    System.out.println("Student is added successfully....");
                } else {
                    System.out.println("Something went wrong try again..");
                }
                System.out.println(st);
            } else if (c == 2) {
                // delete student
                System.out.println("Enter student id to delete: ");
                 userId = Integer.parseInt(br.readLine());
                boolean f = StudentDataAccessObjectClass.deleteStudent(userId);
                if (f) {
                    System.out.println("Deleted....");
                } else {
                    System.out.println("Something went wrong....");
                }

            } else if (c == 3) {
                StudentDataAccessObjectClass.showAllStudent();

            }
            else if (c == 4) {
                //updating student
                System.out.println("Enter user id which you want to update :");
                int id=Integer.parseInt(br.readLine());

                System.out.println("Enter user name :");
                String name = br.readLine();

                System.out.println("Enter user phone : ");
                String phone = br.readLine();

                System.out.println("Enter user city : ");
                String city = br.readLine();

                Student st = new Student(id,name, phone, city);
                boolean answer = StudentDataAccessObjectClass.updateStudentToDB(st);
                if (answer) {
                    System.out.println("Student is added successfully....");
                } else {
                    System.out.println("Something went wrong try again..");
                }
                System.out.println(st);
            }

            else {
               break;
            }
        }

        System.out.println("....Exit....\nThank You ! " );
    }

}