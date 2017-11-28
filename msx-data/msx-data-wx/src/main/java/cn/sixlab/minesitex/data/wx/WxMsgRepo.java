/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/11/2 21:50
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.data.wx;

import cn.sixlab.minesitex.bean.wx.entity.MsxWxMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WxMsgRepo extends JpaRepository<MsxWxMsg, Integer> {
    MsxWxMsg findByMsgId(@Param("msgId") String msgId);
    
    List<MsxWxMsg> findByFromUserNameOrderById(@Param("fromUserName") String fromUserName);
}
