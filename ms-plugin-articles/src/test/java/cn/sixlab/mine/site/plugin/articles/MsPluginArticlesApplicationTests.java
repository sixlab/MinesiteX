package cn.sixlab.mine.site.plugin.articles;

import cn.sixlab.mine.site.lib.core.JsonUtl;
import cn.sixlab.mine.site.plugin.articles.bean.MsArticle;
import cn.sixlab.mine.site.plugin.articles.repository.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsPluginArticlesApplicationTests {

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
