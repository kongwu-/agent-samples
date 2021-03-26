package com.github.kongwu.agentsamples.firstagent.verifierapp;

public class LicenseVerifier {
    public boolean verifyLicense(String encryptedLicense){
        //模拟请求服务器验证许可……
        boolean passed = "SDB4RkZGRg==".equals(encryptedLicense);
//      boolean passed = licenseServer.verifyLicense(encryptedLicense);

        if(!passed){
            //do sth
            System.err.println("验证失败，许可证无效！");
        }
        return passed;
    }
}
