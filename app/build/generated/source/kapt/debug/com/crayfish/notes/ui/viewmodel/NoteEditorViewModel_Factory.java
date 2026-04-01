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
public final class NoteEditorViewModel_Factory implements Factory<NoteEditorViewModel> {
  private final Provider<NoteDao> noteDaoProvider;

  public NoteEditorViewModel_Factory(Provider<NoteDao> noteDaoProvider) {
    this.noteDaoProvider = noteDaoProvider;
  }

  @Override
  public NoteEditorViewModel get() {
    return newInstance(noteDaoProvider.get());
  }

  public static NoteEditorViewModel_Factory create(Provider<NoteDao> noteDaoProvider) {
    return new NoteEditorViewModel_Factory(noteDaoProvider);
  }

  public static NoteEditorViewModel newInstance(NoteDao noteDao) {
    return new NoteEditorViewModel(noteDao);
  }
}
