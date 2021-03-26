package com.github.kongwu.agentsamples.hackagent;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class HackVerifierClassFileTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        //只替换这个验证的类 - LicenseVerifier
        if(className.equals("com/github/kongwu/agentsamples/firstagent/verifierapp/LicenseVerifier")){
            return loadHackClassBuffer(loader);
        }
        return null;
    }

    private byte[] loadHackClassBuffer(ClassLoader loader) {
        //反编译 -> 修改 -> 重新编译的LicenseVerifier.class 文件，换个后缀防止被JVM自动加载
        try (InputStream input = loader.getResourceAsStream("LicenseVerifier.classdata")){
            int n;
            ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];//4k
            //-1 : end of file
            while (-1 != (n = input.read(buffer))) {
                outputBuffer.write(buffer,0,n);
            }
            return outputBuffer.toByteArray();
        }catch (IOException e){
            System.err.println("load the hackfile failed!");
            return null;
        }
    }
}