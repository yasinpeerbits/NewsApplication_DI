object Dependencies {

    //already available
    val coreKtx by lazy { "androidx.core:core-ktx:1.12.0" }
    val appCompat by lazy { "androidx.appcompat:appcompat:1.6.1" }
    val materialGoogle by lazy { "com.google.android.material:material:1.11.0" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:2.1.4" }
    val testjunit by lazy { "junit:junit:4.13.2" }
    val debugTestjunit by lazy { "androidx.test.ext:junit:1.1.5" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:3.5.1" }


    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:2.7.0" }
    val activityCompose by lazy { "androidx.activity:activity-compose:1.8.2" }
    val composeBom by lazy { "androidx.compose:compose-bom:2023.08.00" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:2.7.7" }
    val composeTestJUnit4 by lazy { "androidx.compose.ui:ui-test-junit4" }
    val lifeCycleViewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0" }
    val debugImpUI by lazy { "androidx.compose.ui:ui-tooling" }
    val debugTestManifest by lazy { "androidx.compose.ui:ui-test-manifest" }

    //Hilt
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:2.51" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-compiler:2.51" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:1.2.0" }

    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:1.2.0" }

    //Retrofit dependency
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:2.9.0" }
    val okhttp by lazy { "com.squareup.okhttp3:okhttp:5.0.0-alpha.2" }
    val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:2.9.0" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:1.13.0" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:2.9.0" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:4.8.1"}

    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3" }

    val splashScreen by lazy {"androidx.core:core-splashscreen:1.0.1"}

    val coil by lazy {"io.coil-kt:coil-compose:2.6.0"}

}

















object Modules{
    const val utilities = ":utilities"
}