/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/21 17:08
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.tools.generator.module;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigGenerator {
    public static void generator(String projectPath, String pluginName)
            throws Exception {
        //获取 bean 和 plugin 目录
        String beanPath = beanPath(projectPath);
        String pluginPath = pluginPath(beanPath, pluginName);
        
        generatorSrc(pluginPath, pluginName);
    }
    
    private static void generatorSrc(String pluginPath, String pluginName) throws IOException {
        String staticPath = pluginPath + "src/main/resources/config/";
        new File(staticPath).mkdirs();
        File bs = new File(staticPath + "application-msx-service-"+ pluginName+"-prod.yml");
    
        if (!bs.exists()) {
            String bsText = "server:\n" +
                    "  port: 8802\n";
    
            bs.createNewFile();
            FileWriter writer = new FileWriter(bs);
            writer.write(bsText);
            writer.flush();
            writer.close();
        }
    }
    
    private static String pluginPath(String path, String pluginName) throws IOException {
        String pluginPath = path + "msx-base-config/";
        File pluginDir = new File(pluginPath);
    
        if (!pluginDir.exists() || !pluginDir.isDirectory()) {
            throw new IOException("不存在 config 目录");
        }
        return pluginPath;
    }
    
    private static String beanPath(String projectPath) throws IOException {
        String path = projectPath + "msx-server/";
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()) {
            throw new IOException("不存在 server 目录");
        }
        return path;
    }
}
