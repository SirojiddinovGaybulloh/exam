package comsirojiddinovgaybullo.core.di.module.Data.UserData

import android.content.Context
import android.service.autofill.UserData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Provides
    @Singleton
    fun getRoomDbInstance(context: Context):Db{
        return Db.getDbInstance(context)
    }

    @Provides
    @Singleton
    fun getItemDao(db: Db):NoteDao{
        return db.noteDao()
    }


}