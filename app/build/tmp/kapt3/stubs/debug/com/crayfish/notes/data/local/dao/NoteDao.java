package com.crayfish.notes.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\bH\'J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\b2\u0006\u0010\u0011\u001a\u00020\u000eH\'J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001b"}, d2 = {"Lcom/crayfish/notes/data/local/dao/NoteDao;", "", "deleteNote", "", "note", "Lcom/crayfish/notes/data/local/entity/NoteEntity;", "(Lcom/crayfish/notes/data/local/entity/NoteEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllNotesFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getAllTagsFlow", "Lcom/crayfish/notes/data/local/entity/TagEntity;", "getNoteById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTagsForNote", "noteId", "insertNote", "insertNoteTagCrossRef", "crossRef", "Lcom/crayfish/notes/data/local/entity/NoteTagCrossRef;", "(Lcom/crayfish/notes/data/local/entity/NoteTagCrossRef;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTag", "tag", "(Lcom/crayfish/notes/data/local/entity/TagEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNote", "app_debug"})
@androidx.room.Dao()
public abstract interface NoteDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNote(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.local.entity.NoteEntity note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateNote(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.local.entity.NoteEntity note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteNote(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.local.entity.NoteEntity note, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM notes WHERE is_archived = 0 ORDER BY created_at DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.crayfish.notes.data.local.entity.NoteEntity>> getAllNotesFlow();
    
    @androidx.room.Query(value = "SELECT * FROM notes WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNoteById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.crayfish.notes.data.local.entity.NoteEntity> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTag(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.local.entity.TagEntity tag, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tags")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.crayfish.notes.data.local.entity.TagEntity>> getAllTagsFlow();
    
    @androidx.room.Insert(onConflict = 5)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertNoteTagCrossRef(@org.jetbrains.annotations.NotNull()
    com.crayfish.notes.data.local.entity.NoteTagCrossRef crossRef, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Transaction()
    @androidx.room.Query(value = "\n        SELECT * FROM tags \n        INNER JOIN note_tag_cross_ref ON tags.id = note_tag_cross_ref.tag_id \n        WHERE note_tag_cross_ref.note_id = :noteId\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.crayfish.notes.data.local.entity.TagEntity>> getTagsForNote(@org.jetbrains.annotations.NotNull()
    java.lang.String noteId);
}