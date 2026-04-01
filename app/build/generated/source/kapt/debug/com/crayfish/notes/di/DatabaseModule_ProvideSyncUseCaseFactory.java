package com.crayfish.notes.di;

import android.content.Context;
import com.crayfish.notes.data.sync.GitAuthManager;
import com.crayfish.notes.data.sync.GitSyncManager;
import com.crayfish.notes.domain.usecase.SyncUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class DatabaseModule_ProvideSyncUseCaseFactory implements Factory<SyncUseCase> {
  private final Provider<GitAuthManager> gitAuthManagerProvider;

  private final Provider<GitSyncManager> gitSyncManagerProvider;

  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideSyncUseCaseFactory(Provider<GitAuthManager> gitAuthManagerProvider,
      Provider<GitSyncManager> gitSyncManagerProvider, Provider<Context> contextProvider) {
    this.gitAuthManagerProvider = gitAuthManagerProvider;
    this.gitSyncManagerProvider = gitSyncManagerProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public SyncUseCase get() {
    return provideSyncUseCase(gitAuthManagerProvider.get(), gitSyncManagerProvider.get(), contextProvider.get());
  }

  public static DatabaseModule_ProvideSyncUseCaseFactory create(
      Provider<GitAuthManager> gitAuthManagerProvider,
      Provider<GitSyncManager> gitSyncManagerProvider, Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideSyncUseCaseFactory(gitAuthManagerProvider, gitSyncManagerProvider, contextProvider);
  }

  public static SyncUseCase provideSyncUseCase(GitAuthManager gitAuthManager,
      GitSyncManager gitSyncManager, Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideSyncUseCase(gitAuthManager, gitSyncManager, context));
  }
}
