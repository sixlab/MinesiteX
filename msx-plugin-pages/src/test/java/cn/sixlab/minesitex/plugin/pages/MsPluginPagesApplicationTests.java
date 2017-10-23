package cn.sixlab.minesitex.plugin.pages;

import cn.sixlab.minesitex.lib.core.JsonUtl;
import cn.sixlab.minesitex.plugin.pages.bean.MsArticle;
import cn.sixlab.minesitex.plugin.pages.repository.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsPluginPagesApplicationTests {

    @Autowired
    private ArticleRepository repository;

    @Test
    public void contextLoads() {
        MsArticle msArticle = new MsArticle();
        msArticle.setUrl("abc");
        msArticle.setTitle("看视频1");
        msArticle.setPublishTime(LocalDateTime.now());
        repository.save(msArticle);

        MsArticle article = repository.findByUrl("abc");
        System.out.println(JsonUtl.toJson(article));
    }

}
