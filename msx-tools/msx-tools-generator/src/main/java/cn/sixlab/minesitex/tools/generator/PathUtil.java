/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/21 16:04
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.tools.generator;

import org.springframework.util.ClassUtils;

public class PathUtil {
    public static String getProjectPath() {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        
        return path.replace("msx-tools/msx-tools-generator/target/classes/","");
    }
}
