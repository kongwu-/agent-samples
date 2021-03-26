package com.github.kongwu.agentsamples.firstagent;


import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String args, Instrumentation instrumentation){
        ClassLoggerTransformer transformer = new ClassLoggerTransformer();
        instrumentation.addTransformer(transformer);
    }
}