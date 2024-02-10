package java12;

import java12.configs.HibernateConfig;
import java12.entities.Course;
import java12.entities.Lesson;
import java12.entities.Student;

import java12.service.CourseService;
import java12.service.LessonService;
import java12.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        CourseService courseService = context.getBean(CourseService.class);
        LessonService lessonService = context.getBean(LessonService.class);
        StudentService studentService = context.getBean(StudentService.class);
        while (true) {
            System.out.println("""
                                       COURSE
                    1.T save(T entity);
                    2.T findById(ID id);
                    3.List<T> getAll();
                    4.T updateById(ID id,T newEntity);
                    5void deleteByID(ID id);
                        
                             LESSON
                             
                    6.T save(T entity);
                    7.T findById(ID id);
                    8.List<T> getAll();
                    9.T updateById(ID id,T newEntity);
                    10.void deleteByID(ID id);
                           
                            STUDENT
                    11.T save(T entity);
                    12.T findById(ID id);
                    13.List<T> getAll();
                    14.T updateById(ID id,T newEntity);
                    15.void deleteByID(ID id);
                            ASSIGN
                    16.Assign Student to Course       
                    17.Assign Lesson to Course       
                    """);
            int action = new Scanner(System.in).nextInt();
            switch (action) {
                case 1 -> {
                    System.out.println("Write name :");
                    String name = new Scanner(System.in).nextLine();
                    Course course = new Course();
                    course.setName(name);
                    System.out.println("Write price :");
                    course.setPrice(new Scanner(System.in).nextInt());
                    course.setDateOfStart(LocalDate.now());
                    course.setStudent(new ArrayList<>());
                    course.setLessons(new ArrayList<>());
                    System.out.println(courseService.save(course));
                }
                case 2 -> {
                    System.out.println(courseService.findById(new Scanner(System.in).nextLong()));
                }
                case 3 -> {
                    System.out.println(courseService.getAll());
                }
                case 4 -> {
                    System.out.println("Write id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Write name :");
                    String name = new Scanner(System.in).nextLine();
                    Course course = new Course();
                    course.setName(name);
                    System.out.println("Write price :");
                    course.setPrice(new Scanner(System.in).nextInt());
                    course.setDateOfStart(LocalDate.now());
                    System.out.println(courseService.updateById(id, course));
                }
                case 5 -> {
                    courseService.deleteByID(new Scanner(System.in).nextLong());
                }
                case 6 -> {
                    System.out.println("Write title");
                    Lesson lesson = new Lesson();
                    lesson.setName(new Scanner(System.in).nextLine());
                    System.out.println("Write description");
                    lesson.setDescription(new Scanner(System.in).nextLine());
                    System.out.println("Write url");
                    lesson.setPublishedDate(LocalDate.now());
                    lesson.setPresentation(true);
                    lesson.setVideoLink(new Scanner(System.in).nextLine());
                    System.out.println(lessonService.save(lesson));
                }
                case 7 -> {
                    System.out.println(lessonService.findById(new Scanner(System.in).nextLong()));
                }
                case 8 -> {
                    System.out.println(lessonService.getAll());
                }
                case 9 -> {
                    System.out.println("Write id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Write title");
                    Lesson lesson = new Lesson();
                    lesson.setName(new Scanner(System.in).nextLine());
                    System.out.println("Write description");
                    lesson.setDescription(new Scanner(System.in).nextLine());
                    System.out.println("Write url");
                    lesson.setPublishedDate(LocalDate.now());
                    lesson.setPresentation(true);
                    lesson.setVideoLink(new Scanner(System.in).nextLine());
                    System.out.println(lessonService.updateById(id, lesson));
                }
                case 10 -> {
                    lessonService.deleteByID(new Scanner(System.in).nextLong());
                }
                case 11 -> {
                    Student student = new Student();
                    System.out.println("Write email");
                    student.setEmail(new Scanner(System.in).nextLine());
                    System.out.println("Write name");
                    student.setName(new Scanner(System.in).nextLine());
                    System.out.println("Write date year");
                    student.setYearOfBirth(new Scanner(System.in).nextInt());
                    System.out.println(studentService.save(student));
                }
                case 12 -> {
                    System.out.println(studentService.findById(new Scanner(System.in).nextLong()));
                }
                case 13 -> {
                    System.out.println(studentService.getAll());
                }
                case 14 -> {
                    System.out.println("Write id");
                    Long id = new Scanner(System.in).nextLong();
                    Student student = new Student();
                    System.out.println("Write email");
                    student.setEmail(new Scanner(System.in).nextLine());
                    System.out.println("Write name");
                    student.setName(new Scanner(System.in).nextLine());
                    System.out.println("Write date year");
                    student.setYearOfBirth(new Scanner(System.in).nextInt());
                    System.out.println(studentService.updateById(id, student));
                }
                case 15 -> {
                    studentService.deleteByID(new Scanner(System.in).nextLong());
                }
                case 16 -> {
                    System.out.println("Write id Student");
                    Long studentId = new Scanner(System.in).nextLong();
                    System.out.println("Write id course");
                    System.out.println(courseService.assignStudentToCourse(studentId, new Scanner(System.in).nextLong()));
                }
                case 17 -> {
                    System.out.println("Write lesson id");
                    Long lessonId = new Scanner(System.in).nextLong();
                    System.out.println("Write courseID");
                    courseService.assignLessonToCourse(lessonId, new Scanner(System.in).nextLong());
                }
            }
        }
    }
}
