import model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("fullName", "Name1");
        Class<? extends Resume> resumeClass = r.getClass();
        Field field = r.getClass().getDeclaredFields()[0];
        System.out.println(field.getName());
        field.setAccessible(true);
        field.set(r, "new uuid");

        Method method = resumeClass.getMethod("toString");
        Object result = method.invoke(r);
        System.out.println(result);

    }
}
