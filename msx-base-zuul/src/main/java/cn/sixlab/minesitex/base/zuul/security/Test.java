/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/14 04:59
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.base.zuul.security;

import org.springframework.web.bind.annotation.RequestMethod;

public class Test {
    public static void main(String[] args) {
        System.out.println(RequestMethod.POST);
        System.out.println(RequestMethod.POST.equals("POST"));
        System.out.println(RequestMethod.POST.name());
        System.out.println(RequestMethod.POST.name().equals("POST"));
    }
}
