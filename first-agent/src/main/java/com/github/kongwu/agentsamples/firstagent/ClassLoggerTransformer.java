package com.github.kongwu.agentsamples.firstagent;


import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.ProtectionDomain;

public class ClassLoggerTransformer implements ClassFileTransformer {

    //返回值是替换的字节码数据
    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        try {
            Path path = Paths.get("classes/" + className + ".class");
            System.err.println("load class : "+className);
            //将字节码数据classfileBuffer，存储到classes目录下，以.class文件作为后缀
            Files.write(path, classfileBuffer);
        } catch (Throwable ignored) { // ignored, don’t do this at home kids
        } finally { return classfileBuffer; }
    }
}