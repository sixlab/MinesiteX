package cn.sixlab.minesitex.data.movie;

import cn.sixlab.minesitex.bean.movie.entity.MsxFilm;
import cn.sixlab.minesitex.lib.base.util.JsonUtl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FilmRepoTest {
    private static Logger logger = LoggerFactory.getLogger(FilmRepoTest.class);
    
    @Autowired
    private FilmRepo filmRepo;
    
    @Test
    public void queryByKeyword() {
        List<MsxFilm> filmList = filmRepo.queryByKeyword("电影院");
        
        logger.info("1----------------------");
        logger.info(filmList.size() + "");
        for (MsxFilm s : filmList) {
            logger.info(s.getId() + ":" + s.getMovieName());
        }
        
        logger.info("1----------------------");
    }
    
    @Test
    public void queryCinemas() {
        List<String> cinemaList = filmRepo.queryCinemas();
        
        logger.info("2----------------------");
        logger.info(cinemaList.size() + "");
        for (String s : cinemaList) {
            logger.info(s);
        }
        
        logger.info("2----------------------");
    }
    
    @Test
    public void queryByDoubanKeyIsNotNullOrderById() {
        List<MsxFilm> filmList = filmRepo.queryTop10ByDoubanKeyIsNullOrderByIdDesc();
        
        logger.info("2----------------------");
        logger.info(filmList.size() + "");
        for (MsxFilm film : filmList) {
            logger.info(JsonUtl.toJson(film));
        }
        
        logger.info("2----------------------");
    }
}