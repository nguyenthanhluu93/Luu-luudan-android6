#include <jni.h>
#include <string>

extern "C"
jstring
Java_com_gvn_pets_ui_activity_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello Pest(Pika) C++";
    return env->NewStringUTF(hello.c_str());
}
