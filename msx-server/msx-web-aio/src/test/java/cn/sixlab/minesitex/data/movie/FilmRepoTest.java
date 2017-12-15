package cn.sixlab.minesitex.data.movie;

import cn.sixlab.minesitex.bean.movie.entity.MsxFilm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FilmRepoTest {
    
    @Autowired
    private FilmRepo filmRepo;
    
    @Test
    public void queryByKeyword() {
        List<MsxFilm> filmList = filmRepo.queryByKeyword("电影院");
        
        System.out.println("1----------------------");
        System.out.println(filmList.size());
        for (MsxFilm s : filmList) {
            System.out.println(s.getId() + ":" + s.getMovieName());
        }
        
        System.out.println("1----------------------");
    }
    
    @Test
    public void queryCinemas() {
        List<String> cinemaList = filmRepo.queryCinemas();
        
        System.out.println("2----------------------");
        System.out.println(cinemaList.size());
        for (String s : cinemaList) {
            System.out.println(s);
        }
        
        System.out.println("2----------------------");
    }
}