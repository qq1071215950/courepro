package com.course.file.test;

import com.course.file.annotion.Person;

/**
 * @author jiange
 * @date 2020/7/13 19:14
 */
@Person(name = "jiange", age = 22)
public class test3 {
    public static void print(Class c) {
        System.out.println(c.getName());

        //java.lang.Class的getAnnotation方法，如果有注解，则返回注解。否则返回null
        Person person = (Person) c.getAnnotation(Person.class);

        if (person != null) {
            System.out.println("name:" + person.name() + " age:" + person.age());
        } else {
            System.out.println("person unknown!");
        }
    }

    public static void main(String[] args) {
        test3.print(test3.class);
    }

}
