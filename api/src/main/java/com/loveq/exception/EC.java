package com.loveq.exception;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author tommy
 */
@Data
@RequiredArgsConstructor(staticName = "of")
public class EC {
    @NonNull
    private int code;
    @NonNull
    private String message;

    public static EC of(int code, String message, Class<? extends CodeInterface> type) {
        String[] names = type.getName().split("\\$");
        switch (names.length) {
            case 2:
                return of((getInterfaceCode(type) << 16) + code, message);
            case 3:
                try {
                    return of((getInterfaceCode(Class.forName(String.format("%s$%s", names[0], names[1]))) << 16) + (getInterfaceCode(type) << 8) + code, message);
                } catch (ClassNotFoundException e) {
//                    log.error("{}", e);
                }
        }

        return of(-1, "Error in EC of");
    }

    private static int getInterfaceCode(Class type) {
        try {
            CodeInterface codeInterface = (CodeInterface) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{
                    type
            }, (Object proxy, Method method, Object[] arguments) -> null);

            Method method = type.getMethod("code");

            Field field = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            field.setAccessible(true);

            MethodHandles.Lookup lookup = (MethodHandles.Lookup) field.get(null);
            return (Integer) lookup.unreflectSpecial(method, method.getDeclaringClass()).bindTo(codeInterface).invokeWithArguments();
        } catch (Throwable t) {
//            log.error("{}", t);
        }

        return -1;
    }

    public EC format(Object... args) {
        return new EC(code, String.format(message, args));
    }

}
