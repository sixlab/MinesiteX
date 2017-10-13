package cn.sixlab.mine.site.plugin.archives;

import cn.sixlab.mine.site.lib.core.JsonUtl;
import cn.sixlab.mine.site.plugin.archives.bean.MsArchive;
import cn.sixlab.mine.site.plugin.archives.repository.ArchiveRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsPluginArchivesApplicationTests {

    @Autowired
    private ArchiveRepository repository;

    @Test
    public void contextLoads() {
        MsArchive archive1 = new MsArchive();
        archive1.setUrl("abc");
        archive1.setTitle("看视频1");
        archive1.setPublishTime(LocalDateTime.now());
        repository.save(archive1);

        MsArchive archive = repository.findByUrl("abc");
        System.out.println(JsonUtl.toJson(archive));
    }

}
