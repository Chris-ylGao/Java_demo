package com.newcastle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {


    public static void main(String[] args) throws Exception {
        /**
         * Three methods get class object
         *  * Class.forName("packageName + className")
         *  * className.class
         *  * object.getClass;
         * *.class can only load once, so methods above refer to the same reference.
         */

        Class cls1 = Class.forName("com.newcastle.Person");
        Class cls2 = Person.class;
        Person person = new Person();
        Class cls3 = person.getClass();

        System.out.println(cls1  == cls2); // true
        System.out.println(cls1 == cls3); //true

        /**
         * classObject.getFields(): get all field with public modifier
         * classObject.getField(String name): get public field with specified name
         */
        Field[] fields = cls1.getFields();
        for (Field f: fields) {
            System.out.println(f);
        }

        /**
         * classObject.getDeclaredField(): get all field (private, protected, public, no modifier)
         * classObject.getDeclaredField(String name): get field with specified name
         */
        Field[] declaredFields = cls1.getDeclaredFields();
        for (Field f: declaredFields) {
            System.out.println(f);
        }

        /**
         * classObject.getConstructors(): get all public constructors of this class object
         * classObject.getDeclaredConstructor(parameterType.class): get public constructor with specified type of parameter
         */
        Constructor[] constructors = cls3.getConstructors();
        for ( Constructor c: constructors) {
            System.out.println(c);
        }

        System.out.println(cls3.getDeclaredConstructor(String.class, int.class));

        /**
         * classObject.getMethods(): get all public methods of this class object() including methods of Object.class
         * classObject.getDeclaredMethod(String methodName, parameterType.class): get public methods with specified method name and parameter type.
         */
        Method[] methods = cls1.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println(cls1.getDeclaredMethod("changeName", String.class));

        /**
         * classObject.getName(): get name of object ---- "packageName + className"
         * classObject.getSimpleName(): get simple name of object ---- "className"
         */
        System.out.println(cls1.getName());
        System.out.println(cls1.getSimpleName());

        /**
         * throws IllegalAccessException if the field is not accessible or final
         */
        Field name = cls3.getDeclaredField("name");
        name.setAccessible(true); // make filed accessible regardless of declared modifier
        name.set(person, "Mike"); // set value of this filed of specified object;
        System.out.println(person);
        System.out.println(name.get(person)); // get value of this field of this specified object


        Constructor constructor = cls1.getDeclaredConstructor(String.class, int.class);
        Object p =  constructor.newInstance("Mike",20); // create a new object
        System.out.println(p);


        Method m = cls1.getDeclaredMethod("changeName", String.class);
        m.invoke(p,"Dan"); // invoke method
        System.out.println(p);
    }


}
