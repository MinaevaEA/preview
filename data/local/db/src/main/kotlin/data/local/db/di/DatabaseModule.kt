package data.local.db.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import data.local.db.DB_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

//    @Provides
//    @Singleton
//    fun provideDatabase(
//        @ApplicationContext context: Context
//    ) : AppDatabase {
//        return Room.databaseBuilder(
//            context = context,
//            klass = AppDatabase::class.java,
//            name = DB_NAME
//        )
//            .build()
//    }

}
