/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/26 11:14
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.movie.service;

import cn.sixlab.minesitex.bean.movie.entity.MsxFilm;
import cn.sixlab.minesitex.data.movie.FilmRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class FilmService {
    private static Logger logger = LoggerFactory.getLogger(ShowService.class);
    
    @Autowired
    private FilmRepo filmRepo;
    
    public void addFilm(MsxFilm film) {
        filmRepo.save(film);
        
        //hisService.sawFilm(film);
    }
    
    public void updateFilm(MsxFilm film) {
        filmRepo.save(film);
    }
    
    public void viewFilm(Integer id, String name) {
        //hisService.sawFilm(id, name, new Date());
    }
    
    public List<MsxFilm> searchFilm(String keyword) {
        List<MsxFilm> filmList;
        
        if (StringUtils.isEmpty(keyword)) {
            filmList = filmRepo.findAll();
        } else {
            filmList = filmRepo.queryByKeyword(keyword);
        }
        
        return filmList;
    }
    
    public MsxFilm fetchFilm(Integer id) {
        return filmRepo.findOne(id);
    }
    
    public List<MsxFilm> fetchRecentFilm(Integer num) {
        List<MsxFilm> filmList = null;
        
        if (num == null) {
            num = 10;
        }
        
        Page<MsxFilm> filmPage = filmRepo.findAll(new PageRequest(0, num,
                new Sort(Sort.Direction.DESC, "viewDate")));
    
        filmList = filmPage.getContent();
    
        return filmList;
    }
}
