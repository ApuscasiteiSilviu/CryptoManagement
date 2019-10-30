package util;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.yaml.snakeyaml.Yaml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class GitHub {

    private Config config;

    public void pushRepo() {
//        Repository localRepo = null;
//        try {
//            localRepo = new FileRepository(System.getProperty("user.dir"));
//        } catch (IOException e) {
//            System.out.println("Cannot open de file");
//        }
//        Git git = new Git(localRepo);
//
//            // add remote repo:
//            RemoteAddCommand remoteAddCommand = git.remoteAdd();
//            remoteAddCommand.setName("origin");
//        try {
//            remoteAddCommand.setUri(new URIish("https://github.com/ApuscasiteiSilviu/CryptoManagement"));
//        } catch (URISyntaxException e) {
//            System.out.println("Cannot set uri");
//        }
//        // you can add more settings here if needed
//        try {
//            remoteAddCommand.call();
//        } catch (GitAPIException e) {
//            System.out.println("Cannot call add command");
//        }
//
//        // push to remote:
//            PushCommand pushCommand = git.push();
//            pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider("silviu.alex95@yahoo.ro", "Masterzed98"));
//            // you can add more settings here if needed
//        try {
//            pushCommand.call();
//        } catch (GitAPIException e) {
//            System.out.println("Cannot call push commnad");
//            e.printStackTrace();
//        }

        try
        {
            Repository localRepo = new FileRepository(System.getProperty("user.dir"));
            Git git = new Git(localRepo);

            // commit and push
            git.add().addFilepattern("application.properties").call();
            git.commit().setMessage("Update application.properties file").call();

            git.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider("silviu.alex95@yahoo.ro", "Masterzed98")).call();
        }
        catch(GitAPIException | IOException e)
        {
            System.out.println("Cannot push");
        }

    }
}
