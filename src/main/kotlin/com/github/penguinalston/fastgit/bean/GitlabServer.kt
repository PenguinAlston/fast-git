package com.github.penguinalston.fastgit.bean;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
class GitlabServer {
    var apiUrl = ""
    var apiToken = ""
    var repositoryUrl = ""
    var preferredConnection = CloneType.SSH
    var validFlag: Boolean? = null

    enum class CloneType {
        SSH,
        HTTPS
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GitlabServer

        if (apiUrl != other.apiUrl) return false
        if (apiToken != other.apiToken) return false
        if (repositoryUrl != other.repositoryUrl) return false
        if (preferredConnection != other.preferredConnection) return false
        return validFlag == other.validFlag
    }

    override fun hashCode(): Int {
        var result = apiUrl.hashCode()
        result = 31 * result + apiToken.hashCode()
        result = 31 * result + repositoryUrl.hashCode()
        result = 31 * result + preferredConnection.hashCode()
        result = 31 * result + (validFlag?.hashCode() ?: 0)
        return result
    }


}
