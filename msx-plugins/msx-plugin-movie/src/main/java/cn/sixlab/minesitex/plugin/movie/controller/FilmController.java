/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/26 11:11
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.movie.controller;

import cn.sixlab.minesitex.bean.movie.entity.MsxFilm;
import cn.sixlab.minesitex.lib.base.model.ModelJson;
import cn.sixlab.minesitex.plugin.movie.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class FilmController{
    private static Logger logger = LoggerFactory.getLogger(FilmController.class);
    
    @Autowired
    private FilmService service;
    
    /**
     * 添加一部新观看的电影
     *
     * @param film
     * @return
     */
    @PostMapping(value = "/film")
    public ModelJson add(MsxFilm film) {
        logger.debug("添加电影>>>");
        ModelJson json = new ModelJson();
    
        service.addFilm(film);
        
        return json;
    }
    
    /**
     * 更新某一部电影
     *
     * @param id
     * @param film
     * @return
     */
    @RequestMapping(value = "/film/{id}", method = RequestMethod.PUT)
    public ModelJson update(@PathVariable Integer id, MsxFilm film) {
        logger.debug("更新电影>>>", id);
        
        ModelJson json = new ModelJson();
        
        film.setId(id);
        service.updateFilm(film);
        
        return json;
    }
    
    /**
     * 获取某一部电影
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/film/{id}", method = RequestMethod.GET)
    public ModelJson fetchFilm(@PathVariable Integer id) {
        logger.debug("获取电影>>>", id);
        ModelJson<MsxFilm> json = new ModelJson<>();
    
        MsxFilm film = service.fetchFilm(id);
        json.setData(film);
        
        return json;
    }
    
    /**
     * 搜索电影
     *
     * @param keyword
     * @return
     */
    @GetMapping(value = "/film")
    public ModelJson search(String keyword) {
        logger.debug("搜索电影>>>", keyword);
        ModelJson<List<MsxFilm>> json = new ModelJson<>();
        
        List<MsxFilm> movieList = service.searchFilm(keyword);
    
        json.setData(movieList);
    
        return json;
    }
    
    /**
     * 观看了 id 电影，名字是 name
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(value = "/film/{id}/view/{name}", method = RequestMethod.POST)
    public ModelJson viewFilm(@PathVariable Integer id, @PathVariable String name) {
        logger.debug("重看电影>>>", id);
        logger.debug("重看电影>>>", name);
        ModelJson json = new ModelJson();
        
        service.viewFilm(id, name);
        
        return json;
    }
}
