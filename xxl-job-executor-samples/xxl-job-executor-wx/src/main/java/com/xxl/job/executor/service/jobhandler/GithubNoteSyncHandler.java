package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;
import org.wx.sync.SSHGitRepoSynchronization;
import org.wx.utils.PropertiesUtils;

/**
 * @author wuxin
 * @date 2022/08/22 04:44:07
 */
@Component
public class GithubNoteSyncHandler {

    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("personNotesSync")
    public Boolean personNotesSync() throws Exception {
        String jobParam = XxlJobHelper.getJobParam();
        SSHGitRepoSynchronization sshGitRepoSynchronization = new SSHGitRepoSynchronization(PropertiesUtils.getPropertiesFromDisk(jobParam));
        return sshGitRepoSynchronization.synchronize();
    }


}
