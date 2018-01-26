/**
 * Copyright (c) 2018 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2018/1/26 17:38
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.admin.business;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerOperator {
    
    public static void exec(String command) throws IOException {
        exec(command, null);
    }
    
    public static void exec(String command, String dir, String... envp) throws IOException {
        System.out.println("-----------------------");
        System.out.println("开始运行命令：" + command);
        System.out.println("目录：" + dir);
        System.out.println("参数：" + envp);
        Process proc = null;
        if (StringUtils.isEmpty(dir)) {
            Runtime.getRuntime().exec(command, envp);
        }else{
            Runtime.getRuntime().exec(command, envp, new File(dir));
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
