package PublicCode.annotationTest;

import java.lang.reflect.Field;

import PublicCode.annotation.MyAnnotation;

public class TestDemo {
    public static void main(String[] args) throws Exception {
        Class<Demo> clazz = Demo.class;
        MyAnnotation annotationOnClass = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnClass.getValue());

        Field name = clazz.getField("name");
        MyAnnotation annotationOnField = name.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnField.getValue());
    }
}
