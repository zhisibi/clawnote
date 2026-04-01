package com.crayfish.notes.ui.viewmodel;

import com.crayfish.notes.data.local.dao.NoteDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
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
public final class NoteViewModel_Factory implements Factory<NoteViewModel> {
  private final Provider<NoteDao> noteDaoProvider;

  public NoteViewModel_Factory(Provider<NoteDao> noteDaoProvider) {
    this.noteDaoProvider = noteDaoProvider;
  }

  @Override
  public NoteViewModel get() {
    return newInstance(noteDaoProvider.get());
  }

  public static NoteViewModel_Factory create(Provider<NoteDao> noteDaoProvider) {
    return new NoteViewModel_Factory(noteDaoProvider);
  }

  public static NoteViewModel newInstance(NoteDao noteDao) {
    return new NoteViewModel(noteDao);
  }
}
