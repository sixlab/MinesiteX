/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/21 15:49
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.tools.generator;

import cn.sixlab.minesitex.tools.generator.module.BeanGenerator;
import cn.sixlab.minesitex.tools.generator.module.ConfigGenerator;
import cn.sixlab.minesitex.tools.generator.module.DataGenerator;
import cn.sixlab.minesitex.tools.generator.module.ModuleGenerator;
import cn.sixlab.minesitex.tools.generator.module.PluginGenerator;
import cn.sixlab.minesitex.tools.generator.module.ServerGenerator;

public class CodeGenerator {
    
    private String pluginName;
    
    private CodeGenerator() {
    }
    
    private CodeGenerator(Builder builder) {
        this.pluginName = builder.pluginName.toLowerCase();
        
        generator();
    }
    
    private void generator(){
        try {
            // 获取项目目录
            String path = PathUtil.getProjectPath();
    
            BeanGenerator.generator(path, pluginName);
            
            DataGenerator.generator(path, pluginName);
            
            PluginGenerator.generator(path, pluginName);
            
            ServerGenerator.generator(path, pluginName);
            
            ConfigGenerator.generator(path, pluginName);
            
            ModuleGenerator.generator(path, pluginName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static final class Builder {
        private String pluginName;
        
        public String getPluginName() {
            return pluginName;
        }
        
        public void setPluginName(String pluginName) {
            this.pluginName = pluginName;
        }
        
        public CodeGenerator build() {
            return new CodeGenerator(this);
        }
    }
}
