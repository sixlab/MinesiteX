/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * License information see the LICENSE file in the project's root directory.
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/4 11:15
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.api.user.feign;

import cn.sixlab.minesitex.api.user.IUserService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("msx-service-user")
public interface UserServiceFeign extends IUserService {

}