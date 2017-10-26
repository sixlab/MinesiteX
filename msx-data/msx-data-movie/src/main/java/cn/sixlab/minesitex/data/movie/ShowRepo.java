/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/26 11:04
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.data.movie;

import cn.sixlab.minesitex.bean.movie.entity.MsxShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowRepo extends JpaRepository<MsxShow, Integer>{
    
    List<MsxShow> findByViewStatus(String viewStatus);
    
    @Query(
            " select u from MsxShow u where" +
                    "       u.tv like concat('%',?1,'%') " +
                    "    OR u.showName like concat('%',?1,'%') " +
                    "    OR u.remark like concat('%',?1,'%') "
    )
    List<MsxShow> findByKeyword(String keyword);
    
    @Query(
            " select u from MsxShow u where" +
                    " u.viewStatus = ?1 " +
                    " and ( " +
                    "       u.tv like concat('%',?2,'%') " +
                    "    OR u.showName like concat('%',?2,'%') " +
                    "    OR u.remark like concat('%',?2,'%') " +
                    "     ) "
    )
    List<MsxShow> findByStatus(String status, String keyword);
}
