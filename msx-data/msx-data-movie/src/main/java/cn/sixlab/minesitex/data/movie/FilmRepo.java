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

import cn.sixlab.minesitex.bean.movie.entity.MsxFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepo extends JpaRepository<MsxFilm, Integer>{
    
    @Query(
            " select u from MsxFilm u where" +
                    " u.movieName like concat('%',?1,'%') " +
                    " OR u.produceYear like concat('%',?1,'%') " +
                    " OR u.director like concat('%',?1,'%') " +
                    " OR u.remark like concat('%',?1,'%') " +
                    " OR u.doubanScore like concat('%',?1,'%') " +
                    " OR u.doubanKey like concat('%',?1,'%') " +
                    " OR u.doubanInfo like concat('%',?1,'%') "
    )
    List<MsxFilm> queryByKeyword(@Param("keyword") String keyword);
}
