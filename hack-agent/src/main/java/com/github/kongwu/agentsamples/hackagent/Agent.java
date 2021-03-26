package com.github.kongwu.agentsamples.hackagent;


import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String args, Instrumentation instrumentation){
        HackVerifierClassFileTransformer transformer = new HackVerifierClassFileTransformer();
        instrumentation.addTransformer(transformer);
    }
}