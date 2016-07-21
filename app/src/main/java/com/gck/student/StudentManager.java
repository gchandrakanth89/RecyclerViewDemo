package com.gck.student;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pervacio on 19-07-2016.
 */
public class StudentManager {

    private static StudentManager studentManager;
    private ArrayList<Student> list;

    private StudentManager() {
        list = new ArrayList<>(33);
        Student student1 = new Student(1, "Srikanth Vodapalli", "http://placehold.it/120x120&text=image1");
        Student student2 = new Student(2, "Ambedkar Gandham", "http://placehold.it/120x120&text=image2");
        Student student3 = new Student(3, "Priyank Joshi", "http://placehold.it/120x120&text=image3");
        Student student4 = new Student(4, "Rajkumar Anugu", "http://placehold.it/120x120&text=image4");
        Student student5 = new Student(5, "Komal Gundavarapu", "http://placehold.it/120x120&text=image5");
        Student student6 = new Student(6, "Sandeep Padala", "http://placehold.it/120x120&text=image6");
        Student student7 = new Student(7, "Chakravarthy SDMN", "http://placehold.it/120x120&text=image7");
        Student student8 = new Student(8, "Gopal Rao Gadadasu", "http://placehold.it/120x120&text=image8");
        Student student9 = new Student(9, "Raghava Burugadda", "http://placehold.it/120x120&text=image9");
        Student student10 = new Student(10, "Adi Lakshmi Chaitanya Konduru", "http://placehold.it/120x120&text=image10");
        Student student11 = new Student(11, "Anusha Tallapalli", "http://placehold.it/120x120&text=image11");
        Student student12 = new Student(12, "Satya Veera Lakshmi Perabathula", "http://placehold.it/120x120&text=image12");
        Student student13 = new Student(13, "Chandrakanth Guggilla", "http://placehold.it/120x120&text=image13");
        Student student14 = new Student(14, "Sandeep Kumar Gurram", "http://placehold.it/120x120&text=image14");
        Student student15 = new Student(15, "Moulali Noorbasha", "http://placehold.it/120x120&text=image15");
        Student student16 = new Student(16, "Vinod Sonawale", "http://placehold.it/120x120&text=image16");
        Student student17 = new Student(17, "Digish R Gabhawala", "http://placehold.it/120x120&text=image17");
        Student student18 = new Student(18, "Bhosale Avdhoot Eshwar", "http://placehold.it/120x120&text=image18");
        Student student19 = new Student(19, "Polasanapalli N Surya Prasanna Babu", "http://placehold.it/120x120&text=image19");
        Student student20 = new Student(20, "Prem Raj", "http://placehold.it/120x120&text=image20");
        Student student21 = new Student(21, "Balram Kola", "http://placehold.it/120x120&text=image21");
        Student student22 = new Student(22, "Satyam Gajula", "http://placehold.it/120x120&text=image22");
        Student student23 = new Student(23, "Vilas Ramchandra Kharatmal", "http://placehold.it/120x120&text=image23");
        Student student24 = new Student(24, "Ravi Kumar Devarala", "http://placehold.it/120x120&text=image24");
        Student student25 = new Student(25, "Ankit Kshatriya", "http://placehold.it/120x120&text=image25");
        Student student26 = new Student(26, "Darpan Dodiya", "http://placehold.it/120x120&text=image26");
        Student student27 = new Student(27, "Shweta Kumar", "http://placehold.it/120x120&text=image27");
        Student student28 = new Student(28, "Shweta Chaurasia", "http://placehold.it/120x120&text=image28");
        Student student29 = new Student(29, "Bhavya Tiruvaipati", "http://placehold.it/120x120&text=image29");
        Student student30 = new Student(30, "Meharbabu Savalam", "http://placehold.it/120x120&text=image30");
        Student student31 = new Student(31, "Ravi Banuri", "http://placehold.it/120x120&text=image31");
        Student student32 = new Student(32, "Venkat Ramu Edulakanti", "http://placehold.it/120x120&text=image32");
        Student student33 = new Student(33, "Swathi Daruri", "http://placehold.it/120x120&text=image33");
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        list.add(student6);
        list.add(student7);
        list.add(student8);
        list.add(student9);
        list.add(student10);
        list.add(student11);
        list.add(student12);
        list.add(student13);
        list.add(student14);
        list.add(student15);
        list.add(student16);
        list.add(student17);
        list.add(student18);
        list.add(student19);
        list.add(student20);
        list.add(student21);
        list.add(student22);
        list.add(student23);
        list.add(student24);
        list.add(student25);
        list.add(student26);
        list.add(student27);
        list.add(student28);
        list.add(student29);
        list.add(student30);
        list.add(student31);
        list.add(student32);
        list.add(student33);

    }

    public static StudentManager getInstance() {
        if (studentManager == null) {
            studentManager = new StudentManager();
        }
        return studentManager;
    }

    public List<Student> getData() {
        return list;
    }

    public List<Student> getData(String search) {

        if (TextUtils.isEmpty(search)) {
            return list;
        }

        List<Student> searchList = new ArrayList<>();
        for (Student student : list) {
            if (student.getName().toLowerCase().contains(search.toLowerCase())) {
                searchList.add(student);
            }
        }

        return searchList;
    }
}
