package jdk8.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * description: ReflectTest <br>
 * date: 2021/4/13 下午1:41 <br>
 * author: kuan <br>
 * version: 1.0 <br>
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {

        Person person = new Person();
        Class clazz = person.getClass();
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.toString());
        }

        Person p = (Person) clazz.newInstance();
        p.setId(1);
        p.setName("wink");
        p.setAge(18);
        System.out.println(p.toString());

        System.out.println("===================");
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.toString());
        }

        Constructor<Person> constructor = personClass.getConstructor(int.class, String.class, int.class);
        Person person1 = constructor.newInstance(2, "wink2", 19);
        System.out.println(person1.toString());

        System.out.println("===================");
        Class<?> forName = Class.forName("jdk8.reflect.Person");
        Method[] methods = forName.getMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
        }

        Object object = forName.newInstance();
        Method method = forName.getMethod("setName", String.class);
        method.invoke(object,"wink3");
        System.out.println(object.toString());

        System.out.println("===================");

    }
}
