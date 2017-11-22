package cn.sixlab.minesitex;

import cn.sixlab.minesitex.tools.generator.CodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsxToolsGeneratorApplication {
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MsxToolsGeneratorApplication.class, args);
    
        CodeGenerator.Builder builder = new CodeGenerator.Builder();
        builder.setPluginName("award");
        CodeGenerator generator = builder.build();
    }
}
