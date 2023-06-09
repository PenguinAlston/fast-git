package com.github.penguinalston.fastgit.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.github.penguinalston.fastgit.Bundle
import gitlab.GitLabSettingsState

@Service(Service.Level.PROJECT)
class FastGitProjectService(project: Project) {

    init {
        thisLogger().info(Bundle.message("projectService", project.name))
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
        validateGitLabServer()
    }

    private fun validateGitLabServer() {
        var invalidServerList = mutableListOf<String>()
        var gitLabSettingsState = GitLabSettingsState.getInstance()
        gitLabSettingsState.apply {
            this.gitlabServers.stream().forEach{

            }
        }

    }

    fun getRandomNumber() = (1..100).random()
}
