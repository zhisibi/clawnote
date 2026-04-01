package com.crayfish.notes.domain.usecase

import com.crayfish.notes.data.sync.GitRepositoryManager
import com.crayfish.notes.data.sync.GitSyncManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SyncUseCase(
    private val gitRepoManager: GitRepositoryManager,
    private val gitSyncManager: GitSyncManager
) {
    /**
     * 执行全量同步流程：Pull -> Import -> Export -> Push
     */
    suspend fun executeSync() = withContext(Dispatchers.IO) {
        try {
            // 1. 初始化或克隆仓库
            gitRepoManager.initOrClone()

            // 2. 从远端拉取最新改动
            gitRepoManager.pull()

            // 3. 将 Git 仓库中的文件导入到本地数据库
            gitSyncManager.importFromGit()

            // 4. 将本地数据库中的改动导出到 Git 仓库
            gitSyncManager.exportToGit()

            // 5. 提交并推送到远端
            gitRepoManager.commitAndPush("Sync from Android: ${System.currentTimeMillis()}")
            
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
