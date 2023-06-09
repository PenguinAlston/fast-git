package gitlab;

import com.github.penguinalston.fastgit.bean.GitlabServer;
import com.intellij.openapi.components.*;
import com.intellij.util.xmlb.XmlSerializerUtil;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@State(name = "SettingsState",storages = {
        @Storage("$APP_CONFIG$/gitlab-setting-persistentstate.xml")
})
public class GitLabSettingsState implements PersistentStateComponent<GitLabSettingsState>
{
    private String host;
    private String token;
    private boolean defaultRemoveBranch;
    private List<GitlabServer> gitlabServers = new ArrayList<>();

    public static GitLabSettingsState getInstance(){
        return ServiceManager.getService(GitLabSettingsState.class);
    }

    @Override
    public @Nullable GitLabSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull GitLabSettingsState state) {
        XmlSerializerUtil.copyBean(state,this);
    }


}
