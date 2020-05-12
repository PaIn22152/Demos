cmake_minimum_required(VERSION 3.4.1)

# 1、指定源文件目录，把 /cpp/giflib 目录的下的所有文件赋值给 GIF_LIB
file(GLOB_RECURSE GIF_LIB ${CMAKE_SOURCE_DIR}/src/main/cpp/giflib/*.*)
#file(GLOB_RECURSE GIF_LIB ${CMAKE_SOURCE_DIR}/src/main/cpp/giflib/*.a)
# 同1，cpp 目录下的文件文件放到 MAIN_SOURCE 里，不用一个一个添加
file(GLOB_RECURSE MAIN_SOURCE ${CMAKE_SOURCE_DIR}/src/main/cpp/*.*)


add_library(
        # 要编译的库的名称，可以改
        GifLibHandler

        # SHARED 表示要编译动态库
        SHARED

        # 2、把giflib源文件和GifLoader.cpp添加到 GifLoader 这个库中去
        ${GIF_LIB}
        #        ${MAIN_SOURCE}
        src/main/cpp/GifLibHandler.cpp
)


target_link_libraries(
        GifLibHandler
        # 3、给GifLoader 添加一些依赖
        log
        jnigraphics
        android
)