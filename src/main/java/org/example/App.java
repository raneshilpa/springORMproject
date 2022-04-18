package org.example;

import org.example.dao.StudentDao;
import org.example.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Hello world!
 *1
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("classpath:config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student student = new Student(1111,"pritam","london");
//        int insert = studentDao.insert(student);
//        System.out.println("Done "+insert);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while(go) {
            System.out.println("Press 1 for add new student");
            System.out.println("Press 2 for display all student");
            System.out.println("Press 3 for get details for single student");
            System.out.println("Press 4 for delete student");
            System.out.println("Press 5 for update student");
            System.out.println("Press 6 for exit");

            try
            {
                int input = Integer.parseInt(br.readLine());

                switch(input)
                {
                    case 1:
                        //add new student
                        System.out.println("Enter studentID");
                        int studid = Integer.parseInt(br.readLine());
                        System.out.println("Enter Student Name");
                        String studName=br.readLine();
                        System.out.println("Enter Student City");
                        String studcity=br.readLine();
//                        Student student = new Student(studid,studName,studcity);
////                        int insert = studentDao.insert(student);
//                        System.out.println("student record added "+insert);

                        //creating student object & setting values
                        Student s = new Student();
                        s.setStudID(studid);
                        s.setStudName(studName);
                        s.setStudCity(studcity);
                        int insert = studentDao.insert(s);
                        System.out.println(insert+" student added");
                        System.out.println("************************************");

                        break;
                    case 2:
                        //display all student
                        System.out.println("************************************");
                        List<Student> students = studentDao.getallStudent();
                        for(Student st:students)
                        {
                            System.out.println("student ID "+st.getStudID());
                            System.out.println("Student Name "+st.getStudName());
                            System.out.println("student City "+st.getStudCity());
                            System.out.println("------------------------------------");
                        }
                        System.out.println("***********************************");
                        break;
                    case 3:
                        //get details for student
                        System.out.println("***********************************");
                        System.out.println("Enter studentID");
                        int id = Integer.parseInt(br.readLine());
                        Student s1 = studentDao.getStudent(id);
                        System.out.println("student ID "+s1.getStudID());
                        System.out.println("Student Name "+s1.getStudName());
                        System.out.println("student City "+s1.getStudCity());
                        System.out.println("------------------------------------");


                        break;
                    case 4:
                        //delete student
                        System.out.println("************************************");
                        System.out.println("Enter studentID");
                        int s2 = Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(s2);
                        System.out.println("Student Id record deleted "+s2);
                        break;
                    case 5:
                        //update student
                        System.out.println("Enter student Id for which you want to update information.(User Id can not be changed) ");
                        int sid = Integer.parseInt(br.readLine());

                        System.out.println("Enter new name for the student");
                        String newname = br.readLine();
                        System.out.println("Enter new city name for the student");
                        String newcity = br.readLine();
                        Student student= new Student();
                        student.setStudID(sid);
                        student.setStudCity(newcity);
                        student.setStudName(newname);
                        studentDao.updateStudent(student);
                        System.out.println("Record updated successfully");

                        break;
                    case 6:
                        go= false;
                        break;

                }

            }
            catch (Exception e)
            {
                System.out.println("Invalid input try it another one.");
                System.out.println(e.getMessage());
            }


        }
        System.out.println("Thank you for using application");


    }
}
