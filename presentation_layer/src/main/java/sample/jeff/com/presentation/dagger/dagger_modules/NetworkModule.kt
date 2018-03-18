package sample.jeff.com.presentation.dagger.dagger_modules

import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import sample.jeff.com.presentation.BuildConfig
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Created by  on 16/3/18.
 */

@Module
class NetworkModule(val context: Context) {
    private val baseUrl: String
        get() = BuildConfig.SERVER_URL

    @Provides
    @Singleton
    internal fun providesGson(): Gson {
        return GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES)
                .create()
    }

    @Provides
    @Singleton
    internal fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logginInterceptor = HttpLoggingInterceptor { message -> Timber.d(message) }
        logginInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return logginInterceptor
    }

    @Provides
    @Singleton
    internal fun providesHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder()
//                    .addHeader("", "")
                    .build()
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    internal fun providesOkHttpClient(
            httpLoggingInterceptor: HttpLoggingInterceptor, chuckInterceptor: ChuckInterceptor,
            headerInterceptor: Interceptor): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
                .readTimeout(2, TimeUnit.MINUTES)
        httpClientBuilder.addInterceptor(httpLoggingInterceptor)
        httpClientBuilder.addInterceptor(headerInterceptor)
        if (BuildConfig.DEBUG) {
            httpClientBuilder.addInterceptor(chuckInterceptor)
        }
        return httpClientBuilder.build()
    }

    @Provides
    @Singleton
    internal fun provideChuckInterceptor(): ChuckInterceptor {
        return ChuckInterceptor(context)
    }


    @Provides
    @Singleton
    internal fun providesRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
    /* @Provides
    @Singleton
    internal fun provideHttpResponseInterceptor(): CustomHttpResponseInterceptor {
        return CustomHttpResponseInterceptor()
    }*/
}