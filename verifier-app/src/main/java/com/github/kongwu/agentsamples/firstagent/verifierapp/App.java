package com.github.kongwu.agentsamples.firstagent.verifierapp;

/**
 * Hello world!
 *
 */
public class App 
{

    private static LicenseVerifier licenseVerifier;

    public static void main( String[] args )
    {
        new App().start();
        System.out.println( "VerifierApp start completed!" );
    }

    public void start(){
        prepareResource();
        verifyLicense();
        //正式启动……
    }

    private void verifyLicense() {
        //模拟加载已配置的许可证，一般是存储在本地，文件形式；这里为了简单直接写死，固定验证失败
        String encryptedLicense = "123456";
        boolean passed = licenseVerifier.verifyLicense(encryptedLicense);
        if(!passed){
            System.exit(0);
        }
    }

    private void prepareResource() {
        licenseVerifier = new LicenseVerifier();
    }
}
