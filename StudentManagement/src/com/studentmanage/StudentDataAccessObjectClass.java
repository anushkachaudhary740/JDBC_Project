package com.studentmanage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDataAccessObjectClass {
    public static boolean insertStudentToDB(Student st){
        boolean f=false;
        try{
            //jdbc code;
            Connection con=ConnectionProvider.createConnection();
            String q="insert into students(sname,sphone,scity) values(?,?,?)";
            //PreparedStatement
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setString(1,st.getStudentName());
            pstmt.setString(2,st.getStudentPhone());
            pstmt.setString(3,st.getStudentCity());
            //execute....
            pstmt.executeUpdate();
            f=true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteStudent(int userId) {
        boolean f=false;
        try{
            //jdbc code;
            Connection con=ConnectionProvider.createConnection();
            String q="Delete from students where sid=?";
            //PreparedStatement
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setInt(1,userId);

            //execute....
            pstmt.executeUpdate();
            f=true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static void showAllStudent() {
        //boolean f=false;
        try{
            //jdbc code;
            Connection con=ConnectionProvider.createConnection();
            String q="select * from students";
            Statement stmt=con.createStatement();
            ResultSet set=stmt.executeQuery(q);

            while(set.next()){
                int id=set.getInt(1);
                String name=set.getString(2);
                String phone=set.getString(3);
                String city=set.getString(4);

                System.out.println("ID : "+id);
                System.out.println("Name : "+name);
                System.out.println("Phone Number : "+phone);
                System.out.println("City : "+city);
                System.out.println("..........................");

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static boolean updateStudentToDB(Student st) {
        boolean f=false;
        try{
            //jdbc code;
            Connection con=ConnectionProvider.createConnection();
            String q="UPDATE students SET sname =?, sphone = ?,scity=? WHERE sid = ?";
            //PreparedStatement
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setString(1,st.getStudentName());
            pstmt.setString(2,st.getStudentPhone());
            pstmt.setString(3,st.getStudentCity());
            pstmt.setInt(4,st.getStudentId());
            //execute....
            pstmt.executeUpdate();
            f=true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
