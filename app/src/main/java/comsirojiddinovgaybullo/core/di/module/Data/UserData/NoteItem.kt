package comsirojiddinovgaybullo.core.di.module.Data.UserDataimport androidx.room.ColumnInfoimport androidx.room.Entityimport androidx.room.PrimaryKey@Entity(tableName = "note_table")class NoteItem(    @ColumnInfo(name = "note_title")    var title: String){    @ColumnInfo(name = "_id")    @PrimaryKey(autoGenerate = true)    var id: Int? = null}