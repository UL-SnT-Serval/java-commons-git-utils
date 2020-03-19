package tech.ikora.gitloader.gitlab;

import org.junit.jupiter.api.Test;
import tech.ikora.gitloader.git.LocalRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GitlabIntegrationTest {
    Gitlab createEngine(){
        Gitlab gitlab = new Gitlab();
        gitlab.setToken("oTh9EGjp7UJTBew-aiMg");
        gitlab.setUrl("https://gitlab.com");

        return gitlab;
    }

    @Test
    void testCloningFromName(){
        try {
            Gitlab gitlab = createEngine();
            Set<String> names = new HashSet<>(3);
            names.add("ukwikora/robot-framework-project-a");
            names.add("ukwikora/robot-framework-project-b");
            names.add("ukwikora/robot-framework-project-c");

            gitlab.cloneProjectsFromNames(names);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testCloningFromUsername(){
        try{
            Gitlab gitlab = createEngine();
            gitlab.cloneProjectsFromUser("renaudrwemalika");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testCloningFromGroup(){
        try{
            Gitlab gitlab = createEngine();
            final Set<LocalRepository> localRepositories = gitlab.cloneProjectsFromGroup("ukwikora");
            assertEquals(3, localRepositories.size());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}