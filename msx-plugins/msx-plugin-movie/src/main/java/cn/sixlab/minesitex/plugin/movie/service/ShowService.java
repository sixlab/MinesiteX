/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/10/26 11:15
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.minesitex.plugin.movie.service;

import cn.sixlab.minesitex.bean.movie.entity.MsxShow;
import cn.sixlab.minesitex.data.movie.ShowRepo;
import cn.sixlab.minesitex.plugin.movie.constants.CONST;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class ShowService {
    private static Logger logger = LoggerFactory.getLogger(ShowService.class);
    
    @Autowired
    private ShowRepo showRepo;
    
    public List<MsxShow> search(String keyword, String status) {
        List<MsxShow> showList = null;
        
        if (StringUtils.isEmpty(keyword) && StringUtils.isEmpty(status)) {
            showList = showRepo.findAll();
        } else if(StringUtils.isEmpty(keyword)){
            showList = showRepo.findByViewStatus(CONST.SHOW_V_STATUS_ING);
        }else if(StringUtils.isEmpty(status)){
            showList = showRepo.findByKeyword(keyword);
        }else{
            showList = showRepo.findByStatus(keyword, status);
        }
    
        return showList;
    }
    
    public void addShow(MsxShow show) {
        show.setViewStatus(CONST.SHOW_V_STATUS_ING);
        show.setBeginDate(new Date());
        showRepo.save(show);
        
        //hisService.beginShow(show);
    }
    
    public void updateSeason(Integer id, Integer season) {
        MsxShow show = showRepo.findOne(id);
        show.setShowEpisode(1);
        show.setShowSeason(season);
        show.setUpdateDate(new Date());
        showRepo.save(show);
        
        //hisService.addSeason(show);
    }
    
    public void updateEpisode(Integer id, Integer episode) {
        MsxShow show = showRepo.findOne(id);
        show.setShowEpisode(episode);
        show.setUpdateDate(new Date());
        showRepo.save(show);
        
        //hisService.addEpisode(toolsShow);
    }
    
    public void updateViewStatus(Integer id, String viewStatus) {
        MsxShow show = showRepo.findOne(id);
        show.setViewStatus(viewStatus);
        show.setUpdateDate(new Date());
        showRepo.save(show);
    }
    
    public MsxShow fetchShow(Integer id) {
        return showRepo.findOne(id);
    }
}

//ToolsShow show = new ToolsShow();
//show.setViewStatus(Meta.SHOW_V_STATUS_ING);
//
//ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
//        .withIgnoreCase(true) //改变默认大小写忽略方式：忽略大小写
//        .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
//
////创建实例
//Example<ToolsShow> ex = Example.of(show, matcher);
//
////ToolsShow show = new ToolsShow();
////show.setViewStatus(Meta.SHOW_V_STATUS_ING);
////
////ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
////        .withIgnoreCase(true) //改变默认大小写忽略方式：忽略大小写
////        .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
////
//////创建实例
////Example<ToolsShow> ex = Example.of(show, matcher);
//showList = showRepo.findByViewStatus(Meta.SHOW_V_STATUS_ING);
//
//ToolsShow show = new ToolsShow();
//show.setShowName(keyword);
//show.setTv(keyword);
//show.setRemark(keyword);
//
//ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
//        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) //改变默认字符串匹配方式：模糊查询
//        .withIgnoreCase(true) //改变默认大小写忽略方式：忽略大小写
//        .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
//
////创建实例
//Example<ToolsShow> ex = Example.of(show, matcher);
