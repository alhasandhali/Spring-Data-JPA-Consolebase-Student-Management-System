package com.spring.jpa.crud;

import com.spring.jpa.crud.entity.Student;
import com.spring.jpa.crud.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class SpringJpaCrudApplication {
    public static Scanner sc = new Scanner(System.in);
    public static StudentRepository studentRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJpaCrudApplication.class, args);

        studentRepository = context.getBean(StudentRepository.class);

        System.out.println("1. Add Student");
        System.out.println("2. Update Student");
        System.out.println("3. Search Student");
        System.out.println("4. Find All Students");
        System.out.println("5. Remove a Students");
        System.out.println("6. Find Student by Name");
        System.out.println("7. Find Student by Email");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
        int option = sc.nextInt();
        System.out.println();

        switch (option) {
            case 1:
                addStudent();
                break;
            case 2:
                updateStudent();
                break;
            case 3:
                searchStudent();
                break;
            case 4:
                getAllStudent();
                break;
            case 5:
                deleteStudent();
                break;
            case 6:
                getByName();
                break;
            case 7:
                getByEmail();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void addStudent() {
        sc.nextLine();

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Student Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Student Program: ");
        String program = sc.nextLine();

        System.out.print("Enter Student Batch: ");
        int batch = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student password: ");
        String password = sc.nextLine();

        System.out.print("Enter Student Date of Birth: ");
        String dob = sc.nextLine();

        Student student = new Student(id, name, email, phone, program, batch, password, dob);

        Student result = studentRepository.save(student);

        System.out.println("\n--- Student Added Successfully ---");
        System.out.println(result);
    }

    public static void searchStudent() {
        sc.nextLine();
        System.out.print("Enter Student ID to search: ");
        String searchId = sc.nextLine();

        Optional<Student> student = studentRepository.findById(searchId);

        if (student.isPresent()) {
            Student result = student.get();
            System.out.println(result);
        } else {
            System.out.println("Student not found");
        }
    }

    public static void getAllStudent() {

        Iterable<Student> students = studentRepository.findAll();

        students.forEach(System.out::println);
    }

    public static void deleteStudent() {
        sc.nextLine();
        System.out.print("Enter Student ID to search: ");
        String searchId = sc.nextLine();

        Optional<Student> student = studentRepository.findById(searchId);

        if (student.isPresent()) {
            studentRepository.deleteById(searchId);
            System.out.println("\n--- Student Deleted Successfully ---");
        } else {
            System.out.println("Student not found");
        }
    }

    public static void updateStudent() {
        sc.nextLine();
        System.out.print("Enter Student ID: ");
        String studentId = sc.next();

        Optional<Student> checkStudent = studentRepository.findById(studentId);

        if (checkStudent.isPresent()) {
            Student student = checkStudent.get();
                System.out.println(student);
                System.out.print(
                        "Choose an option to change: \n1. Name\n2. Email\n3. Phone\n4. Program\n5. Batch\n6. DOB\nChoose an option: ");
                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1 -> {
                        System.out.print("Enter New Name: ");
                        student.setStudentName(sc.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Enter New Email: ");
                        student.setStudentEmail(sc.nextLine());
                    }
                    case 3 -> {
                        System.out.print("Enter New Phone: ");
                        student.setStudentPhone(sc.nextLine());
                    }
                    case 4 -> {
                        System.out.print("Enter New Program: ");
                        student.setProgram(sc.nextLine());
                    }
                    case 5 -> {
                        System.out.print("Enter New Batch: ");
                        student.setBatch(sc.nextInt());
                    }
                    case 6 -> {
                        System.out.print("Enter New DOB: ");
                        student.setDob(sc.nextLine());
                    }
                    default -> System.out.println("Invalid Option");
                }

                // When we commit, Hibernate sees the object state changed and syncs it.
                student = studentRepository.save(student);
                System.out.println("Update successful: " + student);

            } else {
                System.out.println("Student not found.");
            }
    }

    public static void getByName() {
        sc.nextLine();
        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        List<Student> student = studentRepository.findByStudentName(studentName);

        if (student.isEmpty()) {
            System.out.println("Student not found");
        } else {
            student.forEach(System.out::println);
        }
    }

    public static void getByEmail() {
        sc.nextLine();
        System.out.print("Enter Student Email: ");
        String studentEmail = sc.nextLine();

        List<Student> student = studentRepository.findByStudentEmail(studentEmail);

        if (student.isEmpty()) {
            System.out.println("Student not found");
        } else {
            student.forEach(System.out::println);
        }
    }
}
