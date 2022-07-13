package itheima;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();
        while (true){
        System.out.println("—————————学生管理系统—————————");
        System.out.println("|   1.添加学生               |");
        System.out.println("|   2.删除学生               |");
        System.out.println("|   3.修改学生               |");
        System.out.println("|   4.查看学生               |");
        System.out.println("|   5.exit                  |");
        System.out.println("—————————————————————————————");
        System.out.println("        请输入您的选择：");



        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        switch (line) {
            case "1":
               addStudent(array);
                break;
            case "2":
                deleteStudent(array);
                break;
            case "3":
                setStudent(array);
                break;
            case "4":
                findStudent(array);
                break;
            case "5":
                System.out.println("谢谢使用本软件！");
                System.exit(0);

             }
        }

    }

    public static void addStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        String sid;
        while (true) {
            System.out.println("请输入学生学号：");
            sid = sc.nextLine();
            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("您输入的学号已存在，请重新输入");
            }else {
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生地址：");
        String address = sc.nextLine();

        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        array.add(s);
        System.out.println("添加学生成功！");
    }//添加


    public  static boolean isUsed(ArrayList<Student> array,String sid){
        boolean flag = false;
        for (int i = 0;i<array.size();i++){
            Student s = array.get(i);
            if (s.getSid().equals(sid)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void deleteStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要删除对象的学号：");
        String sid = sc.nextLine();
            int index = -1;
        for (int i = 0; i< array.size();i++){
            Student s = array.get(i);
            if (s.getSid().equals(sid)){
               index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("该信息不存在，请重新输入");
        }else {
            array.remove(index);
            System.out.println("该学生信息已删除");
        }
    }//删除


    public static void setStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号：");
        String sid = sc.nextLine();

        System.out.println("请输入学生新姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生新年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生新地址：");
        String address = sc.nextLine();

        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        for (int i = 0;i<array.size();i++){
            Student student = array.get(i);
            if (student.getSid().equals(sid)){
                array.set(i,s);
                break;
            }
        }
        System.out.println("修改学生信息成功！");
    }//修改

    public static void findStudent(ArrayList<Student> array){
        if (array.size()==0){
            System.out.println("查询失败，请先添加数据后再查询");
            return;
        }

        System.out.println("学号\t\t\t姓名\t\t年龄\t\t地址");
        for (int i = 0;i<array.size();i++){
            Student s = array.get(i);
            System.out.println(s.getSid()+"\t"+s.getName()+"\t\t"+s.getAge()+"岁\t"+s.getAddress());
        }
    }//查询
}
